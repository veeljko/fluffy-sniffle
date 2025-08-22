package raf.draft.dsw.actions.edit.modelEdit;

import com.sun.tools.javac.Main;
import raf.draft.dsw.DraftNodeChangeUpdate.IDaftNodeChangePublisher;
import raf.draft.dsw.DraftNodeChangeUpdate.IDraftNodeChangeSubscriber;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditButtonClick extends IDaftNodeChangePublisher implements ActionListener {
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
        notifySubscribers(lastClickedNode.getDraftNode().getNodeIme(), input1.getText(), input2.getText());
        frame.dispose();
    }

    @Override
    public void notifySubscribers(String oldName, String newName, String newAutor) {
        for (IDraftNodeChangeSubscriber sub : super.getSubscribers()) {
            sub.update(oldName, newName, newAutor);
        }
    }
}
