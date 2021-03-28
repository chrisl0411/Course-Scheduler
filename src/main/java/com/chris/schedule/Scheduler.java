package com.chris.schedule;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Scheduler {

    public static void generateCombos(int creditHourMin) {
        Map<Long, CourseObject> courseMap = ReadJSON.outputCourseArray("classes.json");
        System.out.println(courseMap);
        ArrayList<CourseObject> currCoursesArray = new ArrayList<>();
        ArrayList<ClassObject> currClassesArray = new ArrayList<>();

        Long currCoursePriority = 1L;
        Double currHours = 0.00;
        //initial combination of high priority classes
        while (currHours < creditHourMin) {
            Long firstClassPriority = 1L;
            CourseObject currCourse = courseMap.get(currCoursePriority);
            currCoursesArray.add(currCourse);
            currClassesArray.add(getClassObject(currCourse, firstClassPriority));

            currHours+=currCourse.courseCreditHours;
            currCoursePriority++;
            //get first combination of courses and class

        }
        //once you get first combination of courses, iterate through every possibility
        //if none of them work, swap courses so that priority sum of all classes is = currPrioritySum + 1
        //get combination of courses with lowest priorityID
        //return currClassesArray with

    }

    public static ClassObject getClassObject(CourseObject courseObject, Long classPriority) {
        ClassObject returnClass = null;
        for(ClassObject classObject: courseObject.classListings) {
            if (classObject.classPriority == classPriority) {
                returnClass = classObject;
            }
        }
        return returnClass;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter minimum credit hours needed: ");
        String creditHourString = userInput.nextLine();
        int creditHourMin = Integer.parseInt(creditHourString);
        System.out.println("Entered credit hours: " + creditHourMin);
        generateCombos(creditHourMin);
    }
}