package raf.draft.dsw.controller.viewEdit;

import raf.draft.dsw.controller.AbstractRoomAction;
import raf.draft.dsw.controller.controllerEdit.WindowManager;
import raf.draft.dsw.controller.modelEdit.EditWindow;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRoomAction {
    private JTextField input3 = null;
    private String text = new String("");
    private DraftTreeItem lastClickedNode = null;
    private EditWindow editWindow = null;

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Edit Action");
        putValue(SHORT_DESCRIPTION, "Edit Action");
    }

    public void actionPerformed(ActionEvent arg0) {
        editWindow = WindowManager.getInstance().getEditWindow();
        editWindow.setVisible();
    }

}
