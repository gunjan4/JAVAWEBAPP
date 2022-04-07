package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("your name")) {
            return "JavaWeb-GR";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            String[] numbers = query.toLowerCase().split(":")[1].split(", ");
            int i = 0;
            for (String number : numbers) {
                int parsed = Integer.parseInt(number.trim());
                i = Math.max(i, parsed);
            }
            return String.valueOf(i);
        }
        if (query.toLowerCase().contains("plus")) {
            return "JavaWeb-GR";
        }
        return "";
    }
}
