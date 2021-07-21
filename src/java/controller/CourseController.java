package controller;

import model.Course;
import model.CourseEnum;
import model.UnitType;
import util.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseController {

    public static Map<CourseEnum, List<Course>> runFirst() throws IOException {
        FileHandler.read();
        Map<CourseEnum, List<Course>> firstResult = FileHandler.courseMap;
        System.out.println(firstResult.size());
        System.out.println();
        return firstResult;
    }

    public static List<Course> runSecond(Map<CourseEnum, List<Course>> courseMap) {
        List<Course> resultList = new ArrayList<>();
        List<String> resultUnitNames = new ArrayList<>();
        for (List<Course> courseList : courseMap.values()) {
            for (Course course : courseList) {
                if (course.isHasNoWeakPrecondition()) {
                    resultList.add(course);
                    resultUnitNames.add(course.getUnitName());
                }
            }
        }
        return resultList;
    }

    public static List<Course> runThird(Map<CourseEnum, List<Course>> courseMap, int recommendedSemester) {
        List<Course> resultList = new ArrayList<>();
        List<String> resultUnitNames = new ArrayList<>();
        for (List<Course> courseList : courseMap.values()) {
            for (Course course : courseList) {
                if (course.getRecommendedSemester().contains(recommendedSemester)) {
                    resultUnitNames.add(course.getUnitName());
                }
            }
        }
        return resultList;
    }

    public static Course runFourth(Map<CourseEnum, List<Course>> courseMap) {
        Course result = new Course();
        for (List<Course> majorList : courseMap.values()) {
            for (Course currentMajor : majorList) {
                if (currentMajor.getPrecondition().size() > result.getPrecondition().size()) {
                    result = currentMajor;
                }
            }
        }
        return result;
    }


    public static Map<String, String> runFifth(Map<CourseEnum, List<Course>> courseMap){

        Map<String, String> currentMap = new HashMap<>();
        double counterK = 0;
        double counterG = 0;

        for(CourseEnum key : courseMap.keySet()){
            for (int i = 0; i < courseMap.get(key).size(); i++) {
                if (courseMap.get(key).get(i).getUnitType().equals(UnitType.K)) {
                    counterK++;
                }else if(courseMap.get(key).get(i).getUnitType().equals(UnitType.G)) {
                    counterG++;
                }
            }
            double sum = counterK + counterG;
            counterK = (counterK / sum) * 100;
            counterK = (int)counterK;
            counterG = 100 - counterK;

            currentMap.put(courseMap.get(key).get(0).getUnitName(), (int)counterK + "% - " + (int)counterG + "%");

            counterK = 0;
            counterG = 0;
        }
        return currentMap;
    }


    public static List<Course> runSixth(Map<CourseEnum, List<Course>> courseMap) {
        List<Course> resultList = new ArrayList<>();
        List<String> resultUnitNames = new ArrayList<>();
        for (List<Course> courseList : courseMap.values()) {
            for (Course course : courseList) {
                if (course.getUnitName().contains("nyelv")) {
                    resultList.add(course);
                    resultUnitNames.add(course.getUnitName());
                }
            }
        }
        return resultList;
    }
}
