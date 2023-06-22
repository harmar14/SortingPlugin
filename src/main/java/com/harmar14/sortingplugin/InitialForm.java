package com.harmar14.sortingplugin;

import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InitialForm extends JFrame {

    private static JFrame CreateFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        // установить JFrame в центре экрана
        frame.setLocationRelativeTo(null);
        // запретить изменения размера окна в размер JFrame
        frame.setResizable(false);
        // всегда показывать frame поверх всех окон
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        // цвет фона
        frame.getContentPane().setBackground(Color.darkGray);
        return frame;
    }

    private static JLabel SetProperties(JLabel label, int x, int y) {
        // цвет текста метки
        label.setForeground(Color.lightGray);
        label.setBackground(Color.darkGray);
        label.setBounds(x, y, 200,20);
        return label;
    }

    private static JCheckBox SetProperties(JCheckBox checkbox, int x, int y) {
        checkbox.setBackground(Color.darkGray);
        checkbox.setForeground(Color.lightGray);
        checkbox.setBounds(x, y, 200, 20);
        return checkbox;
    }

    private static JComboBox SetProperties(JComboBox combobox, int x, int y) {
        combobox.setBackground(Color.darkGray);
        combobox.setForeground(Color.lightGray);
        // combobox.setEditable(true);
        combobox.setBounds(x, y, 120, 30);
        return combobox;
    }

    private static JButton SetProperties(JButton button, int x, int y) {
        button.setBackground(Color.darkGray);
        button.setForeground(Color.lightGray);
        button.setBounds(x, y, 120, 30);
        return button;
    }

    public static void ShowForm(String selectedText) {

        // frame
        JFrame frame = CreateFrame("SortingPlugin");

        // labels
        JLabel typeLabel = new JLabel("Select sorting type");
        JLabel modeLabel = new JLabel("Select sorting mode");
        JLabel delimiterLabel = new JLabel("Select delimiter");
        SetProperties(typeLabel, 0, 0);
        SetProperties(modeLabel, 200, 0);
        SetProperties(delimiterLabel, 200, 80);
        frame.add(typeLabel);
        frame.add(modeLabel);
        frame.add(delimiterLabel);

        // checkboxes to select sort types
        JCheckBox bubbleCheckBox = new JCheckBox("Bubble sort");
        JCheckBox selectionCheckBox = new JCheckBox("Selection sort");
        JCheckBox quickCheckBox = new JCheckBox("Quick sort");
        JCheckBox mergeCheckBox = new JCheckBox("Merge sort");
        JCheckBox insertionCheckBox = new JCheckBox("Insertion sort");
        JCheckBox combCheckBox = new JCheckBox("Comb sort");
        SetProperties(bubbleCheckBox, 0, 30);
        SetProperties(selectionCheckBox, 0, 60);
        SetProperties(quickCheckBox, 0, 90);
        SetProperties(mergeCheckBox, 0, 120);
        SetProperties(insertionCheckBox, 0, 150);
        SetProperties(combCheckBox, 0, 180);
        frame.add(bubbleCheckBox);
        frame.add(selectionCheckBox);
        frame.add(quickCheckBox);
        frame.add(mergeCheckBox);
        frame.add(insertionCheckBox);
        frame.add(combCheckBox);

        String[] modes = {"ASC", "DESC"};
        String[] delimiters = {"space", "comma", "colon", "semi-colon"};

        JComboBox modesComboBox = new JComboBox(modes);
        JComboBox delimitersComboBox = new JComboBox(delimiters);
        SetProperties(modesComboBox, 200, 30);
        SetProperties(delimitersComboBox, 200, 110);
        frame.add(modesComboBox);
        frame.add(delimitersComboBox);

        // ArrayList to store selected sort types, mode and delimiter
        ArrayList<String> options = new ArrayList<String>();
        // button
        JButton button = new JButton("Submit");
        SetProperties(button, 200, 170);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                options.add(modesComboBox.getSelectedItem().toString());
                options.add(delimitersComboBox.getSelectedItem().toString());
                if (bubbleCheckBox.isSelected()) {
                    options.add("bubble");
                }
                if (selectionCheckBox.isSelected()) {
                    options.add("selection");
                }
                if (quickCheckBox.isSelected()) {
                    options.add("quick");
                }
                if (mergeCheckBox.isSelected()) {
                    options.add("merge");
                }
                if (insertionCheckBox.isSelected()) {
                    options.add("insertion");
                }
                if (combCheckBox.isSelected()) {
                    options.add("comb");
                }
                // Messages.showMessageDialog(String.join(", ", options), "Result" ,Messages.getInformationIcon());
                try {
                    DataProcessing.ProcessData(selectedText, options);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        frame.add(button);

        frame.setVisible(true);
    }
}