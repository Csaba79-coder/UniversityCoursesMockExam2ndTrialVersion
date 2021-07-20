package util;

import model.Course;
import model.CourseEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {

    private static final String RELATIVE_PATH = "src/resources/szakok.txt";
    private static final String RELATIVE_PATH_TEST_FILE = "src/resources/test.txt";

    public static Map<CourseEnum, List<Course>> courseMap = new HashMap<>();

    public static void read() throws IOException {
        FileReader fileReader = new FileReader(RELATIVE_PATH_TEST_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for (String line; (line = bufferedReader.readLine()) != null;) {
            Course currentCourse = new Course(line.split(";"));
            if (line.contains("*")) {
                currentCourse.setHasNoWeakPrecondition(true);
            }

            courseMap.putIfAbsent(currentCourse.getCourse(), new ArrayList<>());
            courseMap.get(currentCourse.getCourse()).add(currentCourse);
        }
    }
}
