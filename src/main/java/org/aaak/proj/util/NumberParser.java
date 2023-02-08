package org.aaak.proj.util;

public class NumberParser {
    public static int safeIntParser(String str) {
        return safeIntParser(str, -1);
    }

    public static double safeDoubleParser(String str) {
        return safeDoubleParser(str, -1d);
    }

    public static double safeDoubleParser(String str, double defaultVal) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            //ignore
            return defaultVal;
        }
    }

    public static int safeIntParser(String str, int defaultVal) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            //ignore
            return defaultVal;
        }
    }

    public static long safeLongParser(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            //ignore
            return 0;
        }
    }

    public static long urlToId(String url) {
        try {
            String revUrl = new StringBuilder(url).reverse().toString();
            String sanitizedRevUrl = revUrl.startsWith("/") ? revUrl.replaceFirst("/","") : revUrl;
            String revIdStr = new StringBuilder(sanitizedRevUrl.split("/")[0]).reverse().toString();
            return safeLongParser(revIdStr);
        } catch (Exception e) {
            //ignore
            return 0;
        }
    }

}
