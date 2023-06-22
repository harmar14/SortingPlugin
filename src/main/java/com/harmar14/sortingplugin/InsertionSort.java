package com.harmar14.sortingplugin;

import java.util.ArrayList;

public class InsertionSort {
    public static void execute(ArrayList <Integer> dataSet, String mode) {
        ArrayList <Integer> array = new ArrayList (dataSet);

        switch (mode) {
            case ("ASC"):
                for (int i = 1; i < array.size(); i++) {
                    int current = array.get(i);
                    int j = i;
                    while (j > 0 && array.get(j - 1) > current) {
                        array.set(j, array.get(j - 1));
                        j--;
                    }
                    array.set(j, current);
                }
                break;
            case ("DESC"):
                for (int i = 1; i < array.size(); i++) {
                    int current = array.get(i);
                    int j = i;
                    while (j > 0 && array.get(j - 1) < current) {
                        array.set(j, array.get(j - 1));
                        j--;
                    }
                    array.set(j, current);
                }
                break;
            default:
                System.out.println("Error");
        }
        // return array;
    }
}