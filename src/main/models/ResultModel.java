package main.models;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultModel {
    private int id;
    public void setId(int id) {
        this.id = id+1;
    }
    public int getId() {
        return id;
    }
    private String racerAbbreviation;
    private String racerName;
    private String racerTeam;

    private String timeStart;
    private String timeEnd;
    private String dataStart;
    private String dataEnd;
    private LocalDateTime timeStartResult;
    private LocalDateTime timeEndResult;
    private Duration durationTime;
    private String durationTimeString;

        public void setTimeStartResult(String timeStart, String dataStart){
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String text = dataStart + " " + timeStart;
        this.timeStartResult = LocalDateTime.parse(text, formatter);
    }
    public void setTimeEndResult(String timeEnd, String dataEnd){
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String text = dataEnd + " " + timeEnd;
        this.timeEndResult = LocalDateTime.parse(text, formatter);
    }
    public void setAbbreviation(String abbreviation) {
        this.racerAbbreviation = abbreviation;
    }
    public String getAbbreviation() {
        return racerAbbreviation;
    }
    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }
    public String getRacerName() {
        return racerName;
    }
    public void setRacerTeam(String racerTeam) { this.racerTeam = racerTeam; }
    public String getRacerTeam() { return racerTeam; }
    public void setDurationTime() {

        this.durationTime = Duration.between(this.timeStartResult, this.timeEndResult);
    }
    public Duration getDurationTime() {
        return durationTime;
    }
    public void setDurationTimeString() {
        this.durationTimeString = String.valueOf(durationTime.toMinutes()+":"+durationTime.toSeconds()%60+"."+durationTime.toMillis()%1000);
    }
    public String getDurationTimeString(Duration durationTime) {

            return durationTimeString;
    }

    @Override
    public String toString() {
        return id + " | " +
                racerAbbreviation  + " | " +
                racerName + " | " +
                racerTeam + " | " +
                durationTimeString;
    }




}
