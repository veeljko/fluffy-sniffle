package raf.draft.dsw.DraftNodeChangeUpdate;

import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;

public interface IDraftNodeChangeSubscriber {
    public void update(String oldName, String newName, String newAutor);

    public default void refresh(){
        DraftTreeView treeView = ((DraftTreeImplementation) MainFrame.getInstance().getDraftTree()).getTreeView();
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
