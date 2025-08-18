package raf.draft.dsw.controller.controllerEdit;

import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.controller.viewEdit.EditWindow;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import java.util.Arrays;

public class EditWindowManager implements ITreeSelectedNodeSubscriber {
    private static EditWindowManager instance = null;
    public EditWindow editWindow;

    public EditWindowManager() {
        editWindow = new EditWindow();
    }

    public static EditWindowManager getInstance() {
        if (instance == null) {
            instance = new EditWindowManager();
        }
        return instance;
    }

    public EditWindow getEditWindow() {
        return editWindow;
    }

    @Override
    public void update(DraftTreeItem node) {
        editWindow.getEditButtonClick().setLastClickedNode(node);
        editWindow.getInput3().setText(Arrays.toString(node.getPath()));
    }
}
