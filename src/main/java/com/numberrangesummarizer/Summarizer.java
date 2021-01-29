package com.numberrangesummarizer;

import com.numberrangesummarizer.NumberRangeSummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Summarizer.
 */
public class Summarizer implements NumberRangeSummarizer {

    public Collection<Integer> collect(String input) {
        input = formatInput(input);
        if (input != null) {
            return parseInput(input);
        } else {
            return null;
        }
    }

    public String summarizeCollection(Collection<Integer> input) {
        StringBuilder result = new StringBuilder();
        List<Integer> tempList = new ArrayList<>();
        int[] tempArray = new int[input.size()];
        boolean sequentialVal = false;
        int tempCount = 0;
        for (Integer i : input) {
            tempArray[tempCount] = i;
            tempCount++;
        }
        for (int i = 0; i < tempArray.length; i++) {
            if (i == tempArray.length - 1) {
                result.append(tempArray[i]);
                break;
            } else if (tempArray[i + 1] - tempArray[i] == 1) {
                if (!sequentialVal) {
                    result.append(tempArray[i]).append("-");
                }
                sequentialVal = true;
            } else {
                result.append(tempArray[i]).append(", ");
                sequentialVal = false;
            }
        }
        return result.toString();
    }

    private String formatInput(String input) {
        input = input.replaceAll("\\s+", "");
        while (input.contains(",,")) {
            input = input.replaceFirst(",,", ",");
        }
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (!(((a >= '0') && (a <= '9')) || (a == ',') || (a == ' '))) {
                return "";
            } else if (i == 0 && a == ',') {
                input = input.substring(1);
                i--;
            } else if (i == input.length() - 1 && a == ',') {
                input = input.substring(0, input.length());
            }
        }
        return input;
    }

    private List<Integer> parseInput(String input) {
        int placeHolder = 0;
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                Integer tempValue = parseInt(input.substring(placeHolder, i));
                tempList.add(tempValue);
                placeHolder = i + 1;
            } else if (i == input.length() - 1) {
                tempList.add(parseInt(input.substring(placeHolder, i + 1)));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer i : tempList) {
            if (!result.contains(i)) result.add(i);
        }
        Collections.sort(result);
        return result;
    }
}