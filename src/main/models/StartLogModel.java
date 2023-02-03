package main.models;
public class StartLogModel {
    private String racerAbbreviation;
    private String startDate;
    private String startTime;
    public String getAbbr() {
        return racerAbbreviation;
    }
    public void setAbbr(String abbr) {
        this.racerAbbreviation = abbr;
    }
    public String getTime() {
        return startTime;
    }
    public void setTime(String time) {
        this.startTime = time;
    }
    public void setDate(String date) {
        this.startDate = date;
    }
    public String getDate() {
        return startDate;
    }
    @Override
    public String toString() {
        return "Time  {" +
                "abbr='" + racerAbbreviation + '\'' +
                ", date='" + startDate + '\'' +
                ", time='" + startTime + '\'' +
                '}';
    }
}
