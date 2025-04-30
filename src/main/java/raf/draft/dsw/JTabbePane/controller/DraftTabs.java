package raf.draft.dsw.JTabbePane.controller;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DraftTabs extends JTabbedPane {
    private List<DraftPanel> activeTabs = new ArrayList<>();
    private JPanel desktop;
    private static DraftTabs instance = null;
    private DraftPanelView panelView;

    private DraftTabs() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        panelView = new DraftPanelView();
    }

    public static DraftTabs getInstance() {
        if (instance == null) {
            instance = new DraftTabs();
        }
        return instance;
    }

    public void initialize(){
        setSize(desktop.getMaximumSize());
        desktop.add(this, BorderLayout.CENTER);
        desktop.setVisible(true);
    }

    public void setDesktop(JPanel desktop) {
        this.desktop = desktop;
        initialize();
    }

    public JPanel getDesktop(){
        return desktop;
    }

    public List<DraftPanel> getActiveTabs() {
        return activeTabs;
    }

    public DraftPanelView getPanelView() {
        return panelView;
    }

}
