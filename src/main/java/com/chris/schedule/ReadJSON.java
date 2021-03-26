package com.chris.schedule;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {

    @SuppressWarnings("unchecked")
    public static ArrayList<CourseObject> outputCourseArray(String fileName) {
        //ArrayList holds CourseObjects > ClassObjects > DayTimeObjects
        ArrayList<CourseObject> courseArrayList = new ArrayList<>();
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);


            JSONArray coursesList = (JSONArray) obj;
            Iterator<JSONObject> iterator = coursesList.iterator();
            while (iterator.hasNext()) {
                //Map<String, Object> courseMap = new HashMap<String, Object>();

                JSONObject iterationObject = iterator.next();
                JSONObject courseObject = parseObject(iterationObject, "course");

                String courseName = parseString(courseObject, "courseName");
                String courseNumber = parseString(courseObject, "courseNumber");
                Long coursePriority = parseLong(courseObject, "coursePriority");
                Double courseCreditHours = parseDouble(courseObject, "courseCreditHours");
                JSONArray classListings = parseJSONArray(courseObject, "classListings");
                //addToCourseMap(courseMap, courseName, courseNumber, coursePriority, courseCreditHours);

                Iterator<JSONObject> classIterator = classListings.iterator();
                JSONArray classArray = new JSONArray();
                ArrayList<ClassObject> classArrayList = new ArrayList<>();
                int alphaInit = Character.getNumericValue('a'); //a = 061 in ascii
                while (classIterator.hasNext()) {
                    //Map<String, Object> classMap = new HashMap<>();

                    JSONObject classIterationObj = classIterator.next();
                    classIterationObj.put("priorityID", coursePriority*alphaInit);
                    Long classPriority = parseLong(classIterationObj, "classPriority");
                    Long priorityID = parseLong(classIterationObj, "priorityID");
                    Long classID = parseLong(classIterationObj, "classID");
                    String classProfessor = parseString(classIterationObj, "classProfessor");
                    JSONObject classDayTimes = parseObject(classIterationObj, "classDayTime");

                    ClassObject currClass = new ClassObject(classPriority, priorityID, classID, classProfessor, classTimeArray(classDayTimes));
                    classArrayList.add(currClass);

                    alphaInit++;
                }
                CourseObject currCourse = new CourseObject(courseName, courseNumber, coursePriority, courseCreditHours, classArrayList);
                courseArrayList.add(currCourse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseArrayList;
    }

    private static ArrayList<DayTimeObject> classTimeArray(JSONObject classDayTimes){
        Iterator<String> keys = classDayTimes.keySet().iterator();
        ArrayList<DayTimeObject> classTimeArray = new ArrayList<>();
        while (keys.hasNext()){
            String day = keys.next();
            JSONObject classTimes = parseObject(classDayTimes, day);
            String classStartTime = (String) classTimes.get("classStart");
            String classEndTime = (String) classTimes.get("classEnd");
            DayTimeObject currDayTime = new DayTimeObject(day, classStartTime, classEndTime);
            classTimeArray.add(currDayTime);
        }
        return classTimeArray;
        
    }

    private static Map<String, Object> addToCourseMap(Map<String, Object> courseMap, String courseName, String courseNumber, Long coursePriority, Double courseCreditHours) {
        courseMap.put("courseName", courseName);
        courseMap.put("courseNumber", courseNumber);
        courseMap.put("coursePriority", coursePriority);
        courseMap.put("courseCreditHours", courseCreditHours);
        return courseMap;
    }

    private static Map<String, Object> addToClassMap(Map<String, Object> classMap, Long classPriority, Long priorityID, Long classID, String classProfessor, JSONObject classDayTime) {
        classMap.put("classPriority", classPriority);
        classMap.put("priorityID", priorityID);
        classMap.put("classID", classID);
        classMap.put("classProfessor", classProfessor);
        classMap.put("classDayTime", classDayTime);
        return classMap;
    }

    private static JSONObject parseObject(JSONObject course, String node) {
        //Get employee object within list
        JSONObject object = (JSONObject) course.get(node);
        return object;
    }

    private static String parseString(JSONObject courseObject, String node) {
        String str = (String) courseObject.get(node);
        return str;
    }

    private static Long parseLong(JSONObject courseObject, String node) {
        Long lng = (Long) courseObject.get(node);
        return lng;
    }

    private static Double parseDouble(JSONObject courseObject, String node) {
        Double dbl = (Double) courseObject.get(node);
        return dbl;
    }

    private static JSONArray parseJSONArray(JSONObject courseObject, String node) {
        JSONArray jArray = (JSONArray) courseObject.get(node);
        return jArray;
    }

    public static void main(String[] strings) {
        System.out.println(outputCourseArray("classes.json"));
    }
//    private static void parseClassObject(JSONObject course) {
//        //Get employee object within list
//        JSONObject courseObject = (JSONObject) course.get("course");
//
//        //Get employee first name
//        String courseName = (String) courseObject.get("courseName");
//        System.out.println(courseName);
//
//        //Get employee last name
//        String courseNumber = (String) courseObject.get("courseNumber");
//        System.out.println(courseNumber);
//
//        //Get employee website name
//        Long coursePriority = (Long) courseObject.get("coursePriority");
//        System.out.println(coursePriority);
//
//        Double courseCreditHours = (Double) courseObject.get("courseCreditHours");
//        System.out.println(courseCreditHours);
//
//        JSONArray classListings = (JSONArray) courseObject.get("classListings");
//        System.out.println(classListings);
//    }

}
