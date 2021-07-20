package model;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {

    private CourseEnum course;
    private String unitCode;
    private String unitName;
    private UnitType unitType;
    private List<Integer> recommendedSemester;
    private int credit;
    private List<String> precondition = new ArrayList<>();
    private boolean hasNoWeakPrecondition;

    public Course() {
    }

    public Course(String[] parts) {
        this(
                parts[0],
                parts[1],
                parts[2],
                UnitType.valueOf(parts[3]),
                Util.parseIntegerList(Arrays.asList(parts[4].split("\\|"))),
                Integer.parseInt(parts[5]),
                Arrays.asList(parts[6].split("\\|"))
        );
    }

    public Course(String course, String unitCode, String unitName, UnitType unitType, List<Integer> recommendedSemester,
                  int credit, List<String> precondition) {
        this.course = CourseEnum.getEnumByLabel(course);
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.unitType = unitType;
        this.recommendedSemester = recommendedSemester;
        this.credit = credit;
        this.precondition = precondition;
    }

    public CourseEnum getCourse() {
        return course;
    }

    public void setCourse(CourseEnum course) {
        this.course = course;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public List<Integer> getRecommendedSemester() {
        return recommendedSemester;
    }

    public void setRecommendedSemester(List<Integer> recommendedSemester) {
        this.recommendedSemester = recommendedSemester;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<String> getPrecondition() {
        return precondition;
    }

    public void setPrecondition(List<String> precondition) {
        this.precondition = precondition;
    }

    public boolean isHasNoWeakPrecondition() {
        return hasNoWeakPrecondition;
    }

    public void setHasNoWeakPrecondition(boolean hasNoWeakPrecondition) {
        this.hasNoWeakPrecondition = hasNoWeakPrecondition;
    }
}
