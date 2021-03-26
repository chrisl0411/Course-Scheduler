package com.chris.schedule;

//desc, prof: string; hrs: int; daytime: map

import org.json.simple.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseObject {
    protected String courseName;
    protected String courseNumber;
    protected Long coursePriority;
    protected Double courseCreditHours;
    protected ArrayList<ClassObject> classListings;

    public CourseObject(String courseName, String courseNumber, Long coursePriority, Double courseCreditHours, ArrayList<ClassObject> classListings) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.coursePriority = coursePriority;
        this.courseCreditHours = courseCreditHours;
        this.classListings = classListings;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Long getCoursePriority() {
        return coursePriority;
    }

    public void setCoursePriority(Long coursePriority) {
        this.coursePriority = coursePriority;
    }

    public Double getCourseCreditHours() {
        return courseCreditHours;
    }

    public void setCourseCreditHours(Double courseCreditHours) {
        this.courseCreditHours = courseCreditHours;
    }

}
