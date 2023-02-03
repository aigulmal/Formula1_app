package main.models;

public class EndLogModel {
    private String racerAbbreviation;
    private String endDate;
    private String endTime;
    public String getAbbr() {
        return racerAbbreviation;
    }
    public void setAbbr(String abbr) {
        this.racerAbbreviation = abbr;
    }
    public String getTime() {
        return endTime;
    }
    public void setTime(String time) {
        this.endTime = time;
    }
    public String getDate() {
        return endDate;
    }
    public void setDate(String date) {
        this.endDate = date;
    }

    @Override
    public String toString() {
        return "Time {" +
                "abbr='" + racerAbbreviation + '\'' +
                ", date='" + endDate + '\'' +
                ", time='" + endTime + '\'' +
                '}';
    }
}
