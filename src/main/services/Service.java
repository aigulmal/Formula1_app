package main.services;

import main.dao.DAO;
import main.models.EndLogModel;
import main.models.RacerModel;
import main.models.ResultModel;
import main.models.StartLogModel;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Service {
    DAO dao = new DAO();
    public List<StartLogModel> startLogModelList = dao.getTimeInfoStart();
    public List<EndLogModel> endLogModelList = dao.getTimeInfoEnd();


    public List<ResultModel> getRacersList() {

        ClassLoader classLoader = Service.class.getClassLoader();
        List<RacerModel> racerModelList = dao.getListOfRacers();
        List<StartLogModel> listStartLog = dao.getTimeInfoStart();
        List<EndLogModel> listEndLog = dao.getTimeInfoEnd();
        List<ResultModel> resultModelList = racerModelList.stream()
                .map(rm ->
                {
                    ResultModel resultModel = new ResultModel();
                    resultModel.setAbbreviation(rm.getRacerAbbreviation());
                    resultModel.setRacerName(rm.getRacerName());
                    resultModel.setRacerTeam(rm.getRacerTeam());
                    return resultModel;
                }).peek(r -> {
                    String timeStart = startLogModelList.stream().filter(ls -> ls.getAbbr().equals(r.getAbbreviation())).findAny().orElse(null).getTime();
                    String dateStart = startLogModelList.stream().filter(ls -> ls.getAbbr().equals(r.getAbbreviation())).findAny().orElse(null).getDate();
                    String timeEnd = endLogModelList.stream().filter(le -> le.getAbbr().equals(r.getAbbreviation())).findAny().orElse(null).getTime();
                    String dateEnd = endLogModelList.stream().filter(le -> le.getAbbr().equals(r.getAbbreviation())).findAny().orElse(null).getDate();
                    r.setTimeStartResult(timeStart, dateStart);
                    r.setTimeEndResult(timeEnd, dateEnd);
                    r.setDurationTime();
                    r.setDurationTimeString();
                    Duration duration = r.getDurationTime();
                    r.getDurationTimeString(duration);
                }).sorted(Comparator.comparing(ResultModel::getDurationTime))
                .toList();

    return resultModelList;

    }
}
