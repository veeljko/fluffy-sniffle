package raf.draft.dsw.controller;

import com.sun.tools.javac.Main;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractRoomAction {
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Delete Action");
        putValue(SHORT_DESCRIPTION, "Delete Action");
    }

    public void actionPerformed(ActionEvent arg0) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getParent() == null) {
            return;
        }
        int indexSelected = selected.getParent().getIndex(selected);
        MainFrame.getInstance().getMapTree().deleteChild((DraftTreeItem) selected.getParent(), indexSelected);
    }
}
