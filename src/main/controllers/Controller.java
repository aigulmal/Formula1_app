package main.controllers;
import main.models.ResultModel;
import main.services.Service;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class Controller {
    public static void main(String[] args){
        Service service = new Service();
        final int[] i = {0};
        List<ResultModel> resultModelList = service.getRacersList();
        resultModelList.stream()
                .peek(r->{r.setId(i[0]);
                    i[0] += 1;
                }).peek(r-> {
                    r.setDurationTimeString(formatDuration(r.getDurationTime()));
                }).toList();
        List<ResultModel> list1 = resultModelList.stream().limit(15).peek(System.out::println).toList();
        System.out.println("---------------------------------------------------------------------");
        List<ResultModel> list2 = resultModelList.stream().skip(15).peek(System.out::println).toList();
    }
    private static String formatDuration(Duration duration) {
        return LocalTime.MIDNIGHT.plus(duration).format(DateTimeFormatter.ofPattern("mm:ss.SSS"));
    }
}
