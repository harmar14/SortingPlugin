package com.harmar14.sortingplugin;

import java.util.ArrayList;

public class SelectionSort {
    public static void execute(ArrayList <Integer> dataSet, String mode) {
        ArrayList <Integer> array = new ArrayList(dataSet); // we should not change an original array

        switch (mode) {
            case ("ASC"):
                for (int i = 0; i < array.size() - 1; i++) {
                    int min = minIndex(array, i + 1);
                    int val1 = array.get(i);
                    int val2 = array.get(min);
                    if (val1 > val2) {
                        array.set(min, val1);
                        array.set(i, val2);
                    }
                }
                break;
            case ("DESC"):
                for (int i = 0; i < array.size() - 1; i++) {
                    int max = maxIndex(array, i + 1);
                    int val1 = array.get(i);
                    int val2 = array.get(max);
                    if (val1 < val2) {
                        array.set(max, val1);
                        array.set(i, val2);
                    }
                }
                break;
            default:
                System.out.println("Error");
        }
        // return array;
    }

    private static int minIndex(ArrayList <Integer> array, int startIdx) {
        int minIdx = startIdx;
        int minVal = array.get(startIdx);
        for (int i = startIdx + 1; i < array.size(); i++) {
            int checkVal = array.get(i);
            if (checkVal < minVal) {
                minVal = checkVal;
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int maxIndex(ArrayList <Integer> array, int startIdx) {
        int maxIdx = startIdx;
        int maxVal = array.get(startIdx);
        for (int i = startIdx + 1; i < array.size(); i++) {
            int checkVal = array.get(i);
            if (checkVal > maxVal) {
                maxVal = checkVal;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}