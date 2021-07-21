package module;

import controller.CourseController;
import model.Course;
import model.CourseEnum;
import util.FileHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Processor {

    public static void run() {

        try {

            Map<CourseEnum, List<Course>> coursesMap = CourseController.runFirst();

            List<Course> weakPrerequisites = CourseController.runSecond(coursesMap);

            List<Course> recommendedSemesterUnits = CourseController.runThird(coursesMap, 1);

            Course mostPreconditions = CourseController.runFourth(coursesMap);

            Map<String, String> averageMap = CourseController.runFifth(coursesMap);

            List<Course> nameIncludesNyelv = CourseController.runSixth(coursesMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
