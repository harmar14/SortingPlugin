package com.harmar14.sortingplugin;

import java.util.ArrayList;

public class QuickSort {
    public static void execute(ArrayList <Integer> dataSet, String mode) {
        ArrayList <Integer> array = new ArrayList(dataSet);

        QuickSort.sort(array, 0, array.size() - 1, mode);

        // return array;
    }

    private static void sort(ArrayList<Integer> array, int startIdx, int endIdx, String mode) {
        if (startIdx < endIdx) {
            int divideIdx = partition(array, startIdx, endIdx, mode);
            QuickSort.sort(array, startIdx, divideIdx - 1, mode);
            QuickSort.sort(array, divideIdx, endIdx, mode);
        }
    }

    private static int partition(ArrayList<Integer> array, int startIdx, int endIdx, String mode) {
        int right = endIdx;
        int left = startIdx;
        int pivot = array.get((int) Math.floor((left + right) / 2));

        while (left <= right) {
            switch (mode) {
                case ("ASC"):
                    while (array.get(left) < pivot) {
                        left++;
                    }
                    while (array.get(right) > pivot) {
                        right--;
                    }
                    break;
                case ("DESC"):
                    while (array.get(left) > pivot) {
                        left++;
                    }
                    while (array.get(right) < pivot) {
                        right--;
                    }
                    break;
                default:
                    System.out.println("Error");
            }
            if (left <= right) {
                int tmp = array.get(left);
                array.set(left, array.get(right));
                array.set(right, tmp);
                left++;
                right--;
            }
        }
        return left;
    }
}