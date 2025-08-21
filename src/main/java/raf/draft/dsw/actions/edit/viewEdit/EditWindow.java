package raf.draft.dsw.actions.edit.viewEdit;

import raf.draft.dsw.actions.edit.modelEdit.EditButtonClick;

import javax.swing.*;
import java.awt.*;

public class EditWindow {
    private JFrame frame;
    private JPanel inputPanel;
    private JTextField input3 = null;
    private JTextField input1 = null, input2 = null;
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
        input1 = new JTextField();
        inputPanel.add(input1);

        inputPanel.add(new JLabel("Autor :"));
        input2 = new JTextField();
        inputPanel.add(input2);

        inputPanel.add(new JLabel("Selected :"));
        input3 = new JTextField();
        input3.setEditable(false);


        inputPanel.add(input3);

        // Create a button
        JButton button = new JButton("Submit");

        // Add the panel and button to the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        editButtonClick = new EditButtonClick(frame, input1);

        // Make the frame visible
        button.addActionListener(editButtonClick);
    }

    public JTextField getInput1() {
        return input1;
    }

    public JTextField getInput2() {
        return input2;
    }

    public void update(String nodeIme, String autor){
        getInput1().setText(nodeIme);
        getInput2().setText(autor);
        getInput3().setText(nodeIme);
    }

    public EditButtonClick getEditButtonClick() {
        return editButtonClick;
    }

    public void setEditButtonClick(EditButtonClick editButtonClick) {
        this.editButtonClick = editButtonClick;
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
