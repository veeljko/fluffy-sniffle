package raf.draft.dsw.controller.modelEdit;

import com.sun.tools.javac.Main;
import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.Project;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class EditButtonClick implements ActionListener {
    private DraftTreeItem lastClickedNode = null;
    private JFrame frame;
    private JTextField input1, input2;

    public EditButtonClick(JFrame frame, JTextField input1, JTextField input2) {
        this.frame = frame;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Button was clicked!");
        if (lastClickedNode != null) {
            MainFrame.getInstance().getTabs().getPanelView().changeTabName(lastClickedNode.getDraftNode().getNodeIme(), input1.getText());
            lastClickedNode.getDraftNode().setNodeIme(input1.getText());
        }
        frame.dispose();
    }

    public void setLastClickedNode(DraftTreeItem lastClickedNode) {
        this.lastClickedNode = lastClickedNode;
    }
}
