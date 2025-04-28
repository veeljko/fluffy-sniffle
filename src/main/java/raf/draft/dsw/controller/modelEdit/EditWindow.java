package raf.draft.dsw.controller.modelEdit;

import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.Project;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class EditWindow implements ITreeSelectedNodeSubscriber {
    private JFrame frame;
    private JPanel inputPanel;
    private JTextField input3 = null;
    private String text = new String("");
    private DraftTreeItem lastClickedNode = null;

    public EditWindow() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame("Input Form");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create a panel to hold the input fields
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Create labels and text fields
        inputPanel.add(new JLabel("Node Ime :"));
        JTextField input1 = new JTextField();
        inputPanel.add(input1);

        inputPanel.add(new JLabel("Autor :"));
        JTextField input2 = new JTextField();
        inputPanel.add(input2);

        inputPanel.add(new JLabel("Path :"));
        input3 = new JTextField();
        input3.setEditable(false);

        input3.setText(text);
        inputPanel.add(input3);

        // Create a button
        JButton button = new JButton("Submit");

        // Add the panel and button to the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        // Make the frame visible

        button.addActionListener(e -> {
            // Your action here
            System.out.println("Button was clicked!");
            if (lastClickedNode != null) {
                if (lastClickedNode.getDraftNode() instanceof Building){
                    (((Building) lastClickedNode.getDraftNode())).setIme(input1.getText());
                    (((Building) lastClickedNode.getDraftNode())).setAutor(input2.getText());
                }
                else if (lastClickedNode.getDraftNode() instanceof Room){
                    (((Room) lastClickedNode.getDraftNode())).setIme(input1.getText());
                    (((Room) lastClickedNode.getDraftNode())).setAutor(input2.getText());
                }
                else if (lastClickedNode.getDraftNode() instanceof Project){
                    ((Project) lastClickedNode.getDraftNode()).setIme(input1.getText());
                    ((Project) lastClickedNode.getDraftNode()).setAutor(input2.getText());
                }
                else if (lastClickedNode.getDraftNode() instanceof ProjectExplorer){
                    ((ProjectExplorer) lastClickedNode.getDraftNode()).setIme(input1.getText());
                    ((ProjectExplorer) lastClickedNode.getDraftNode()).setAutor(input2.getText());
                }
            }

            assert lastClickedNode != null;
            lastClickedNode.getDraftNode().setNodeIme(input1.getText());
            frame.dispose();
        });
        if (lastClickedNode != null) {
            input3.setText(text);
        }
    }

    @Override
    public void update(DraftTreeItem node) {
        lastClickedNode = node;
        text = Arrays.toString(node.getPath());
        if (input3 != null) {
            node.getPath();
            input3.setText(text);
        }
    }

    public void setVisible(){
        frame.setVisible(true);
    }
}
