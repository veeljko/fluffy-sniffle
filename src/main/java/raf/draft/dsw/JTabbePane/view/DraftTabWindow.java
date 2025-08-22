package raf.draft.dsw.JTabbePane.view;

import javax.swing.*;
import java.awt.*;

public class DraftTabWindow extends JPanel {
    private String tabName, tabAutor;
    private Color color;
    private JLabel labelName = new JLabel();
    private JLabel labelAutor = new JLabel();

    public DraftTabWindow(String nodeName, String nodeAutor) {
        this.tabName = nodeName;
        this.tabAutor = nodeAutor;
        this.labelName.setText(nodeName);
        this.labelAutor.setText(nodeAutor);
        this.color = Color.black;

        add(labelName);
        add(labelAutor);
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabAutor() {
        return tabAutor;
    }

    public void setTabAutor(String tabAutor) {
        this.tabAutor = tabAutor;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName.setText(labelName);
    }

    public JLabel getLabelAutor() {
        return labelAutor;
    }

    public void setLabelAutor(String labelAutor) {
        this.labelAutor.setText(labelAutor);
    }
}
