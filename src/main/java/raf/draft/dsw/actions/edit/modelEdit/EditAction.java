package raf.draft.dsw.actions.edit.modelEdit;

import raf.draft.dsw.actions.model.AbstractRoomAction;
import raf.draft.dsw.actions.edit.controllerEdit.EditWindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRoomAction {

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Edit Action");
        putValue(SHORT_DESCRIPTION, "Edit Action");
    }

    public void actionPerformed(ActionEvent arg0) {
        EditWindowManager.getInstance().getEditWindow().setVisible();
    }

}
