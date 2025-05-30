package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.jtree.model.DraftTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class DraftTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
    private Object clickedOn =null;
    private JTextField edit=null;

    public DraftTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public DraftTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor) {
        super(tree, renderer, editor);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent){
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
            return ((MouseEvent) arg0).isControlDown() && ((MouseEvent) arg0).getClickCount() == 1;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof DraftTreeItem))
            return;

        DraftTreeItem clicked = (DraftTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());

    }
}
