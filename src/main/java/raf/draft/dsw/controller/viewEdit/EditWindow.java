package raf.draft.dsw.controller.viewEdit;

import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.controller.modelEdit.EditButtonClick;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class EditWindow {
    private JFrame frame;
    private JPanel inputPanel;
    private JTextField input3 = null;
    private String path = "";
    private DraftTreeItem lastClickedNode = null;
    private EditButtonClick editButtonClick = null;

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

        input3.setText(path);
        inputPanel.add(input3);

        // Create a button
        JButton button = new JButton("Submit");

        // Add the panel and button to the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        editButtonClick = new EditButtonClick(frame, input1, input2);

        // Make the frame visible
        button.addActionListener(editButtonClick);
    }

    public EditButtonClick getEditButtonClick() {
        return editButtonClick;
    }

    public void setEditButtonClick(EditButtonClick editButtonClick) {
        this.editButtonClick = editButtonClick;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public JTextField getInput3() {
        return input3;
    }

    public void setInput3(JTextField input3) {
        this.input3 = input3;
    }

    public void setVisible(){
        frame.setVisible(true);
    }
}
