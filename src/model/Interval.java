package model;

public class Interval {
    String fromDate;
    Integer fromMinute;

    String toDate;
    Integer toMinute;

    public Interval(String fromDate, Integer fromMinute, String toDate, Integer toMinute) {
        this.fromDate = fromDate;
        this.fromMinute = fromMinute;
        this.toDate = toDate;
        this.toMinute = toMinute;
    }

    public String getFromDate() {
        return fromDate;
    }

    public Integer getFromMinute() {
        return fromMinute;
    }

    public String getToDate() {
        return toDate;
    }

    public Integer getToMinute() {
        return toMinute;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setFromMinute(Integer fromMinute) {
        this.fromMinute = fromMinute;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void setToMinute(Integer toMinute) {
        this.toMinute = toMinute;
    }
}
