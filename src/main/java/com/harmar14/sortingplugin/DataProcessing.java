package com.harmar14.sortingplugin;

import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.Date;

public class DataProcessing {
    private static ArrayList PrepareInputData(String line, String delimiter) {
        ArrayList <Integer> array = new ArrayList<>();
        if (StringUtils.countMatches(line, delimiter) > 0) {
            String[] subStr = line.split(delimiter);
            for (int i = 0; i < subStr.length; i++) {
                try {
                    array.add(Integer.parseInt(subStr[i].trim()));
                } catch (NumberFormatException e) {
                    Messages.showMessageDialog("Error getting Integer numbers", "Plugin" ,Messages.getErrorIcon());
                    System.exit(1);
                }
            }
        } else {
            Messages.showMessageDialog("Error: no delimiters", "Plugin" ,Messages.getErrorIcon());
            System.exit(1);
        }
        return array;
    }

    private static String PrepareOutputData(ArrayList<Integer> array, String delimiter) {
        String line = "";
        for (int i = 0; i < array.size(); i++) {
            line += Integer.toString(array.get(i)) + delimiter;
        }
        return line;
    }

    private static String GetDelimiter(String delimiterName) {
        String delimiter = "";
        switch (delimiterName) {
            case ("space"):
                delimiter = " ";
                break;
            case ("comma"):
                delimiter = ",";
                break;
            case ("colon"):
                delimiter = ":";
                break;
            case ("semi-colon"):
                delimiter = ";";
        }
        return delimiter;
    }

    public static void ProcessData(String selectedText, ArrayList<String> options) throws InterruptedException {
        String result = "", bubbleRes, selectionRes, quickRes, mergeRes, insertionRes, combRes;
        String mode = options.get(0);
        String delimiter = GetDelimiter(options.get(1));
        ArrayList<Integer> array = PrepareInputData(selectedText, delimiter);

        SortingThread bubbleThread = new SortingThread("bubble", mode, array);
        SortingThread selectionThread = new SortingThread("selection", mode, array);
        SortingThread quickThread = new SortingThread("quick", mode, array);
        SortingThread mergeThread = new SortingThread("merge", mode, array);
        SortingThread insertionThread = new SortingThread("insertion", mode, array);
        SortingThread combThread = new SortingThread("comb", mode, array);

        if (options.contains("bubble")) {
            bubbleThread.start();
        }
        if (options.contains("selection")) {
            selectionThread.start();
        }
        if (options.contains("quick")) {
            quickThread.start();
        }
        if (options.contains("merge")) {
            mergeThread.start();
        }
        if (options.contains("insertion")) {
            insertionThread.start();
        }
        if (options.contains("comb")) {
            combThread.start();
        }

        bubbleThread.join();
        bubbleRes = bubbleThread.getValue();

        selectionThread.join();
        selectionRes = selectionThread.getValue();

        quickThread.join();
        quickRes = quickThread.getValue();

        mergeThread.join();
        mergeRes = mergeThread.getValue();

        insertionThread.join();
        insertionRes = insertionThread.getValue();

        combThread.join();
        combRes = combThread.getValue();

        result = bubbleRes + selectionRes + quickRes + mergeRes + insertionRes + combRes;

        // return PrepareOutputData(array, delimiter);
        Messages.showMessageDialog(result, "Result" ,Messages.getInformationIcon());
    }
}