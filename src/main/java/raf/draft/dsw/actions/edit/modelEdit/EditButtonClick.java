package raf.draft.dsw.actions.edit.modelEdit;

import com.sun.tools.javac.Main;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditButtonClick implements ActionListener {
    private JFrame frame;
    private JTextField input1, input2;

    public EditButtonClick(JFrame frame, JTextField input1, JTextField input2) {
        this.frame = frame;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem lastClickedNode = MainFrame.getInstance().getDraftTree().getSelectedNode();
        //System.out.println("Button was clicked!");
        if (lastClickedNode != null) {
            MainFrame.getInstance().getTabs().getPanelView().changeTabName(lastClickedNode.getDraftNode().getNodeIme(), input1.getText());
            lastClickedNode.getDraftNode().setNodeIme(input1.getText());
        }


        DraftTreeView treeView = ((DraftTreeImplementation) MainFrame.getInstance().getDraftTree()).getTreeView();
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
        frame.dispose();

    }
}
