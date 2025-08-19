package raf.draft.dsw.JTabbePane.controller;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;

import javax.swing.*;
import java.awt.*;

public class DraftTabs extends JTabbedPane {
    private DraftPanel desktop;
    private DraftPanelView panelView;

    public DraftTabs() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        panelView = new DraftPanelView(this);
    }

    public void initialize(){
        setSize(desktop.getMaximumSize());
        desktop.add(this, BorderLayout.CENTER);
        desktop.setVisible(true);
    }

    public void setDesktop(DraftPanel desktop) {
        this.desktop = desktop;
        initialize();
    }

    public DraftPanelView getPanelView() {
        return panelView;
    }

}
