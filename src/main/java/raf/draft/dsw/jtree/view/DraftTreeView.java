package raf.draft.dsw.jtree.view;

import com.sun.tools.javac.Main;
import raf.draft.dsw.actions.edit.controllerEdit.EditWindowManager;
import raf.draft.dsw.jtree.controller.DraftTreeCellEditor;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.controller.DraftTreeSelectionListener;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class DraftTreeView extends JTree {
    public DraftTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        DraftTreeCellRenderer ruTreeCellRenderer = new DraftTreeCellRenderer();
        DraftTreeSelectionListener ruTreeSelectionListener = new DraftTreeSelectionListener();
        ruTreeSelectionListener.addSubscriber(EditWindowManager.getInstance());
        addTreeSelectionListener(ruTreeSelectionListener);
        setCellEditor(new DraftTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }
}
