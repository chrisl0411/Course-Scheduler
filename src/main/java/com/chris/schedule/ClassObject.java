package com.chris.schedule;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class ClassObject {

    protected Long classPriority;
    protected Long priorityID;
    protected Long classID;
    protected String classProfessor;
    protected ArrayList<DayTimeObject> classDayTimes;

    public ClassObject(Long classPriority, Long priorityID, Long classID, String classProfessor, ArrayList<DayTimeObject> classDayTimes) {
        this.classPriority= classPriority;
        this.priorityID = priorityID;
        this.classID = classID;
        this.classProfessor = classProfessor;
        this.classDayTimes = classDayTimes;

    }

    public Long getClassPriority() { return classPriority; }

    public void setClassPriority(Long classPriority) {
        this.classPriority = classPriority;
    }

    public Long getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(Long priorityID) {
        this.priorityID = priorityID;
    }

    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }

    public String getClassProfessor() {
        return classProfessor;
    }

    public void setClassProfessor(String classProfessor) {
        this.classProfessor = classProfessor;
    }

    public ArrayList<DayTimeObject> getClassDayTimes() {
        return classDayTimes;
    }

    public void setClassDayTimes(ArrayList<DayTimeObject> classDayTimes) {
        this.classDayTimes = classDayTimes;
    }





}
