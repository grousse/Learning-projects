class Seven {
    public static SeptenaryStringFunction fun = (s0, s1, s2, s3, s4, s5, s6) -> {
        String s = s0 + s1 + s2 + s3 + s4 + s5 + s6;
        return s.trim().toUpperCase();
    };
}

@FunctionalInterface
interface SeptenaryStringFunction {
    String apply(String s1, String s2, String s3, String s4, String s5, String s6, String s7);
}