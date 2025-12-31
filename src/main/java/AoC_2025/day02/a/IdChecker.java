package AoC_2025.day02.a;

class IdChecker {
    public static boolean check(String s) {
        String[] split = s.split("-");
        return check(toInt(split[0]), toInt(split[1]));
    }

    private static boolean check(Integer min, Integer max) {
        for (int i = min; i < max; i++) {
            if (check(i)) {
                return false;
            }
        }
        return true;

    }

    private static boolean check(int i) {
        String s = String.valueOf(i);
        return check(s.substring(s.length() / 2), s.substring(0, s.length() / 2));
    }

    private static boolean check(String substring, String substring1) {
        return substring.equals(substring1);
    }

    private static Integer toInt(String split) {
        return Integer.parseInt(split);
    }
}
