package com.develogical;

import java.util.HashMap;

public class QueryProcessor {
    HashMap<String, String> keyWordsAndAnswers;
    
    QueryProcessor() {
        keyWordsAndAnswers = new HashMap<>();
        setValuesForMap();
    }

    private void setValuesForMap() {
        keyWordsAndAnswers.put("eiffel", "Paris");
        keyWordsAndAnswers.put("first elected as the prime minister", "2016");
    }


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
            int[] numbers = parseInts(lowercaseQuery.split(":")[2]);
            int largestNumber = Integer.MIN_VALUE;
            for (int number : numbers) {
                largestNumber = Math.max(largestNumber, number);
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
            int[] numbers = parseInts(lowercaseQuery.split(":")[2]);
            for (int number : numbers) {
                if (checkSquare(number) && checkCube(number)) {
                    return String.valueOf(number);
                }
            }
        }
        String[] words = lowercaseQuery.split(" ");
        for (String word : words) {
            if (keyWordsAndAnswers.containsKey(word)) {
                return keyWordsAndAnswers.get(word);
            }
        }
        return "";
    }

    private int[] parseInts(String commaSeparatedNumbers) {
        String[] numbersAsStrings = commaSeparatedNumbers.split(", ");
        int[] numbers = new int[numbersAsStrings.length];
        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStrings[i].trim());
        }
        return numbers;
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
