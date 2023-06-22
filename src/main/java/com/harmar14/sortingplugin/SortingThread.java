package com.harmar14.sortingplugin;

import java.util.ArrayList;
import java.util.Date;

public class SortingThread extends Thread {
    private String opt;
    private String mode;
    private ArrayList<Integer> array;
    private String value = "";

    public SortingThread(String opt, String mode, ArrayList<Integer> array) {
        this.opt = opt;
        this.mode = mode;
        this.array = array;
    }

    public void run() {
        try {
            Date start, end;
            long resTime;
            start = new Date();
            if (opt.equals("bubble")) {
                BubbleSort.execute(array, mode);
            } else if (opt.equals("selection")) {
                SelectionSort.execute(array, mode);
            } else if (opt.equals("quick")) {
                QuickSort.execute(array, mode);
            } else if (opt.equals("merge")) {
                MergeSort.execute(array, mode);
            } else if (opt.equals("insertion")) {
                InsertionSort.execute(array, mode);
            } else if (opt.equals("comb")) {
                CombSort.execute(array, mode);
            }
            end = new Date();
            resTime = end.getTime() - start.getTime();
            value = opt + " sort exec time: " + Long.toString(resTime) + "\n";
        } catch (Exception e) {

        }
    }

    public String getValue() {
        return value;
    }

}
