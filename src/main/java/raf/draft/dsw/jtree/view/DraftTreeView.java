package raf.draft.dsw.jtree.view;

import raf.draft.dsw.controller.Actions;
import raf.draft.dsw.jtree.controller.DraftTreeCellEditor;
import raf.draft.dsw.jtree.controller.DraftTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class DraftTreeView extends JTree {
    public DraftTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        DraftTreeCellRenderer ruTreeCellRenderer = new DraftTreeCellRenderer();
        DraftTreeSelectionListener ruTreeSelectionListener = new DraftTreeSelectionListener();
        ruTreeSelectionListener.addSubscriber(Actions.getInstance().getEditAction());
        addTreeSelectionListener(ruTreeSelectionListener);
        setCellEditor(new DraftTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }
}
