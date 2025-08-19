package raf.draft.dsw.actions.edit.controllerEdit;

import raf.draft.dsw.actions.edit.viewEdit.EditWindow;
import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;

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
        editWindow.getInput3().setText(node.getDraftNode().getNodeIme());
        editWindow.getInput1().setText(node.getDraftNode().getNodeIme());
        editWindow.getInput2().setText(node.getDraftNode().getAutor());
    }
}
