package raf.draft.dsw.actions;

import raf.draft.dsw.actions.model.AbstractRoomAction;
import raf.draft.dsw.errorhandler.Greska;
import raf.draft.dsw.errorhandler.Logger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Room;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class DeleteAction extends AbstractRoomAction {

    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "Delete Action");
        putValue(SHORT_DESCRIPTION, "Delete Action");
    }

    private void dfs(DraftTreeItem node, ArrayList<DraftTreeItem>leafs){
        leafs.add(node);
        if (node.getDraftNode() instanceof Room) return;

        if (node.children().equals(Collections.emptyEnumeration())) return;
        ArrayList<TreeNode> children = Collections.list(node.children());
        for (TreeNode child : children){
            dfs((DraftTreeItem) child, leafs);
        }
    }

    public void actionPerformed(ActionEvent arg0) {
        DraftTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected.getParent() == null) {
            MessageGenerator newMessage = new MessageGenerator("Can't delete root of file", Greska.UPOZORENJE, new Date());
            Logger logger = new LoggerFactory().createLogger("consolelogger");
            logger.log(newMessage.toString());
            return;
        }
        ArrayList<DraftTreeItem> childs = new ArrayList<>();
        dfs(selected, childs);
        for (DraftTreeItem child : childs) {
            MainFrame.getInstance().getMapTree().deleteChild((DraftTreeItem) child.getParent(), child.getParent().getIndex(child));
        }
    }
}
