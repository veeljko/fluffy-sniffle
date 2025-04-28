package raf.draft.dsw.JTabbePane;

import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {
    private JButton addCourse, clear;

    public CoursePanel() {
        addCourse = new JButton("Add Course");
        clear = new JButton("Clear");

        setLayout(new FlowLayout());
        add(addCourse);
        add(clear);
    }
}