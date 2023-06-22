package com.harmar14.sortingplugin;

import java.util.ArrayList;

public class CombSort {
    public static void execute(ArrayList <Integer> dataSet, String mode) {
        ArrayList <Integer> array = new ArrayList(dataSet);
        int gap = array.size();
        boolean completed = false;

        switch (mode) {
            case ("ASC"):
                while (!completed || gap != 1) {
                    if (gap > 1) {
                        gap = gap * 10 / 13;
                    } else {
                        gap = 1;
                    }
                    completed = true;
                    for (int i = gap; i < array.size(); i++) {
                        int previous = array.get(i - gap);
                        int current = array.get(i);
                        if (previous > current){
                            array.set(i - gap, current);
                            array.set(i, previous);
                            completed = false;
                        }
                    }
                }
                break;
            case ("DESC"):
                while (!completed || gap != 1) {
                    if (gap > 1) {
                        gap = gap * 10 / 13;
                    } else {
                        gap = 1;
                    }
                    completed = true;
                    for (int i = gap; i < array.size(); i++) {
                        int previous = array.get(i - gap);
                        int current = array.get(i);
                        if (previous < current){
                            array.set(i - gap, current);
                            array.set(i, previous);
                            completed = false;
                        }
                    }
                }
                break;
            default:
                System.out.println("Error");
        }
        // return array;
    }
}