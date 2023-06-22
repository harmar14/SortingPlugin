package com.harmar14.sortingplugin;

import java.util.ArrayList;

public class MergeSort {
    public static void execute(ArrayList <Integer> dataSet, String mode) {
        ArrayList <Integer> array = new ArrayList (dataSet);

        ArrayList <Integer> tmp;
        ArrayList <Integer> currentList = array;
        ArrayList <Integer> currentResult = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            currentResult.add(0);
        }

        int size = 1;

        while (size < array.size()) {
            for (int i = 0; i < array.size(); i += size * 2) {
                MergeSort.merge(currentList, i, currentList, size + i, currentResult, i, size, mode);
            }
            tmp = currentList;
            currentList = currentResult;
            currentResult = tmp;
            size = size * 2;
        }
        // return array;
    }

    private static void merge(ArrayList <Integer> list1, int list1Start, ArrayList <Integer> list2, int list2Start,
                              ArrayList <Integer> result, int resultStart, int size, String mode) {
        int idx1 = list1Start;
        int idx2 = list2Start;
        int list1End = Math.min(list1Start + size, list1.size());
        int list2End = Math.min(list2Start + size, list2.size());

        if (list1Start + size > list1.size()) {
            for (int i = list1Start; i < list1End; i++) {
                result.set(i, list1.get(i));
            }
        }

        int iterationCnt = list1End - list1Start + list2End - list2Start;

        for (int i = resultStart; i < resultStart + iterationCnt; i++) {
            switch (mode) {
                case ("ASC"):
                    if (idx1 < list1End && (idx2 >= list2End || list1.get(idx1) < list2.get(idx2))) {
                        result.set(i, list1.get(idx1));
                        idx1++;
                    } else {
                        result.set(i, list2.get(idx2));
                        idx2++;
                    }
                    break;
                case ("DESC"):
                    if (idx1 < list1End && (idx2 >= list2End || list1.get(idx1) > list2.get(idx2))) {
                        result.set(i, list1.get(idx1));
                        idx1++;
                    } else {
                        result.set(i, list2.get(idx2));
                        idx2++;
                    }
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }
}