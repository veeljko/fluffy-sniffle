package raf.draft.dsw.JTabbePane;

import javax.swing.*;
import java.awt.*;

public class SelectCoursePanel extends JPanel {
    private JCheckBox java, swing, hibernate;

    public SelectCoursePanel() {
        java = new JCheckBox("Java");
        swing = new JCheckBox("Spring");
        hibernate = new JCheckBox("Hibernate");
        setLayout(new FlowLayout());
        add(java);
        add(swing);
        add(hibernate);
    }
}
