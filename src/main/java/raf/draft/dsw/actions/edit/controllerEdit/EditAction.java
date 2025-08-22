package raf.draft.dsw.actions.edit.controllerEdit;

import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.actions.edit.viewEdit.EditWindow;
import raf.draft.dsw.actions.model.AbstractRoomAction;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRoomAction implements ITreeSelectedNodeSubscriber {
    private EditWindow editWindow = new EditWindow();


    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Edit Action");
        putValue(SHORT_DESCRIPTION, "Edit Action");
    }

    public void actionPerformed(ActionEvent arg0) {
        editWindow.setVisible();
    }

    public EditWindow getEditWindow() {
        return editWindow;
    }

    @Override
    public void update(DraftTreeItem node) {
        editWindow.update(node.getDraftNode().getNodeIme(), node.getDraftNode().getAutor());
    }

}
