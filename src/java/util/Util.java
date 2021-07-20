package util;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Integer> parseIntegerList(List<String> in) {
        List<Integer> out = new ArrayList<>();
        for (String str : in) {
            out.add(Integer.parseInt(str));
        }
        return out;
    }
}
