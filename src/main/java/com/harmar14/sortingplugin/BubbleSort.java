package com.harmar14.sortingplugin;

import java.util.ArrayList;

public class BubbleSort {
    public static void execute(ArrayList <Integer> dataSet, String mode) {
        ArrayList <Integer> array = new ArrayList(dataSet);
        int cnt = 0;
        int k = 1;
        int j = array.size();

        switch (mode) {
            case ("ASC"):
                while (k > 0) {
                    k = 0;
                    for (int i = 1; i < j; i++) {
                        int previous = array.get(i - 1);
                        int current = array.get(i);
                        if (previous > current) {
                            array.set(i - 1, current);
                            array.set(i, previous);
                            k = i;
                        }
                        cnt++;
                    }
                    j = k;
                }
                break;
            case ("DESC"):
                while (k > 0) {
                    k = 0;
                    for (int i = 1; i < j; i++) {
                        int previous = array.get(i - 1);
                        int current = array.get(i);
                        if (previous < current) {
                            array.set(i - 1, current);
                            array.set(i, previous);
                            k = i;
                        }
                        cnt++;
                    }
                    j = k;
                }
                break;
            default:
                System.out.println("Error");
        }
        // return array;
    }
}