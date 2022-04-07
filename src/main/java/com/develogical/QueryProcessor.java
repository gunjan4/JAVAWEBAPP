package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        String lowercaseQuery = query.toLowerCase();
        if (lowercaseQuery.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (lowercaseQuery.contains("your name")) {
            return "JavaWeb-GR";
        }
        if (lowercaseQuery.contains("which of the following numbers is the largest")) {
            String[] numbers = lowercaseQuery.split(":")[2].split(", ");
            int largestNumber = Integer.MIN_VALUE;
            for (String number : numbers) {
                int parsed = Integer.parseInt(number.trim());
                largestNumber = Math.max(largestNumber, parsed);
            }
            return String.valueOf(largestNumber);
        }
        if (lowercaseQuery.contains("plus")) {
            String[] words = query.split(" ");
            int firstNumber = Integer.parseInt(words[words.length - 3]);
            int secondNumber = Integer.parseInt(words[words.length - 1]);
            return String.valueOf(firstNumber + secondNumber);
        }
        if (lowercaseQuery.contains("multiplied")) {
            String[] words = query.split(" ");
            int firstNumber = Integer.parseInt(words[words.length - 4]);
            int secondNumber = Integer.parseInt(words[words.length - 1]);
            return String.valueOf(firstNumber * secondNumber);
        }
        if (lowercaseQuery.contains("which of the following numbers is both a square and a cube")) {
            String[] numbers = lowercaseQuery.split(":")[2].split(", ");
            for (String numberAsString : numbers) {
                double number = Double.parseDouble(numberAsString.trim());
                if (checkSquare(number) && checkCube(number)) {
                    return numberAsString.trim();
                }
            }
        }



        return "";
    }

    public boolean checkSquare(double i) {
        double sq = Math.sqrt(i);
        return ((sq - Math.floor(sq)) == 0);
    }

    public boolean checkCube(double i) {
        double cubeRoot = Math.cbrt(i);
        return Math.round(cubeRoot) == cubeRoot;
    }
}
