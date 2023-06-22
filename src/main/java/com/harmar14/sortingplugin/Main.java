package com.harmar14.sortingplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Main extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();
        // ArrayList<Integer> selectedList = DataProcessing.PrepareInputData(selectedText, " ");
        InitialForm.ShowForm(selectedText);
        // String processedText = DataProcessing.PrepareOutputData(selectedList, " ");
        // Messages.showMessageDialog(processedText, "Plugin" ,Messages.getInformationIcon());
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }

}
