package model;


public enum CourseEnum {
    ENG("anglisztika"),
    GER("germanisztika"),
    JAP("japán"),
    CPH("klasszika filológia"),
    HUN("magyar"),
    SCA("skandinavisztika"),
    INF("informatikus könyvtáros"),
    HIS("történelem"),
    OTHER("opsz");

    public final String HUN_NAME;

    CourseEnum(String hunName) {
        this.HUN_NAME = hunName;
    }

    public static CourseEnum getEnumByHunName(String hunName) {
        for (CourseEnum currentEnum : values()) {
            if (currentEnum.HUN_NAME.equals(hunName)) {
                return currentEnum;
            }
        }
        return CourseEnum.OTHER;
    }
}
