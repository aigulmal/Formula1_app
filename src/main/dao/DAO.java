package main.dao;
import main.models.EndLogModel;
import main.models.RacerModel;
import main.models.ResultModel;
import main.models.StartLogModel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
    public class DAO {

        public InputStream getResources(String file) {
            ClassLoader classLoader = DAO.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(file);
            return inputStream;
        }
        public BufferedReader getBufferedReader(InputStream inputStream)  {
            ClassLoader classLoader = DAO.class.getClassLoader();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader;
        }
        List<RacerModel> racerModels;
        List<StartLogModel> getTimeInfoStart;
        List<EndLogModel> getTimeInfoEnd;

        public List<RacerModel> getListOfRacers(){
            ClassLoader classLoader = DAO.class.getClassLoader();

            try (InputStream inputStream = getResources("main/resources/abbreviations.txt")){
                BufferedReader bufferedReader = getBufferedReader(inputStream);

                racerModels = bufferedReader.lines()
                        .map(line -> line.split("_"))
                        .map(str -> {
                            RacerModel racerModel = new RacerModel();
                            racerModel.setRacerAbbreviation(str[0]);
                            racerModel.setRacerName(str[1]);
                            racerModel.setRacerTeam(str[2]);
                            return racerModel;
                        }).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return racerModels;
        }
        public List<StartLogModel> getTimeInfoStart() {
            ClassLoader classLoader = DAO.class.getClassLoader();

            try
                    (InputStream inputStream = getResources("main/resources/start.txt")) {
                BufferedReader bufferedReader = getBufferedReader(inputStream);
                getTimeInfoStart =
                        bufferedReader.lines()
                                .map(line -> line.split("_"))
                                .map(str -> {
                                    StartLogModel startLogModel = new StartLogModel();
                                    startLogModel.setAbbr(str[0].substring(0,3));
                                    startLogModel.setDate(str[0].substring(3, 13));
                                    startLogModel.setTime(str[1]);

                                    return startLogModel;
                                }).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return getTimeInfoStart;
        }

        public List<EndLogModel> getTimeInfoEnd() {
            ClassLoader classLoader = DAO.class.getClassLoader();

            try
                    (InputStream inputStream = getResources("main/resources/end.txt")) {
                BufferedReader bufferedReader = getBufferedReader(inputStream);
                getTimeInfoEnd =
                        bufferedReader.lines()
                                .map(line -> line.split("_"))
                                .map(str -> {
                                    EndLogModel endLogModel = new EndLogModel();
                                    endLogModel.setAbbr(str[0].substring(0,3));
                                    endLogModel.setDate(str[0].substring(3));
                                    endLogModel.setTime(str[1]);

                                    return endLogModel;
                                }).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return getTimeInfoEnd;
        }
    }


