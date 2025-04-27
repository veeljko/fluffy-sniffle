package raf.draft.dsw.JTabbePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabbedPane extends JFrame {
    private JTabbedPane tabs;
    private CoursePanel cource;
    private SelectCoursePanel selectCourse;

    public TabbedPane() {
        super("Tabbed Pane Example");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the JTabbedPane Position and Layout as Wrap
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        cource = new CoursePanel();
        selectCourse = new SelectCoursePanel();
        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Cources", cource);
        tabs.addTab("Select Course", selectCourse);

        // Adding JPanels to JTabbedPane
        tabs.addTab("Listing", new JPanel());
        tabs.addTab("Comment", new JTextArea(10, 40));

        tabs.addTab("Register", new JPanel());
        tabs.addTab("Contact Us", new JPanel());

        tabs.addTab("More..", new JPanel());

        getContentPane().add(tabs);
    }
}
