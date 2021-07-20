package controller;

import model.Course;
import model.CourseEnum;
import util.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseController {

    public static Map<CourseEnum, List<Course>> runFirst() throws IOException {
        FileHandler.read();
        Map<CourseEnum, List<Course>> firstResult = FileHandler.courseMap;
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
