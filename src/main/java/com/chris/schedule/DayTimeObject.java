package com.chris.schedule;

import java.sql.Time;
import java.util.Date;

public class DayTimeObject {
    protected String dayOfWeek;
    protected String classStart;
    protected String classEnd;

    public DayTimeObject(String dayOfWeek, String classStart, String classEnd) {
        this.dayOfWeek = dayOfWeek;
        this.classStart = classStart;
        this.classEnd = classEnd;
    }

    public static Time convertToTime(String time){
        String[] timeArray = time.split(" ");
        String[] hrMin = timeArray[0].split(":");
        int hour = Integer.parseInt(hrMin[0]);
        int minute = Integer.parseInt(hrMin[1]);
        Time timeObject = new Time((3600000*(hour+6)+(60000*minute)));
        if (timeArray[1].equals("pm")) {
            System.out.println("condition met");
            timeObject.setTime((3600000*(hour+6+12))+(60000*minute));
        }
        return timeObject;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getClassStart() {
        return classStart;
    }

    public void setClassStart(String classStart) {
        this.classStart = classStart;
    }

    public String getClassEnd() {
        return classEnd;
    }

    public void setClassEnd(String classEnd) {
        this.classEnd = classEnd;
    }

}
