package main.controllers;

import main.models.ResultModel;
import main.services.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {
    public static void main(String[] args){
        ClassLoader classLoader = Controller.class.getClassLoader();
        Service service = new Service();
        final int[] i = {0};

        List<ResultModel> resultModelList = service.getRacersList();
        resultModelList.stream()
                .peek(r->{r.setId(i[0]);
                    i[0] += 1;
                }).peek(r-> {
                    r.setDurationTime();
                    r.setDurationTimeString();
                    r.getDurationTimeString(r.getDurationTime());
                }).toList();

        List<ResultModel> list1 = resultModelList.stream().limit(15).peek(System.out::println).toList();
        System.out.println("---------------------------------------------------------------------");
        List<ResultModel> list2 = resultModelList.stream().skip(15).peek(System.out::println).toList();

    }

}
