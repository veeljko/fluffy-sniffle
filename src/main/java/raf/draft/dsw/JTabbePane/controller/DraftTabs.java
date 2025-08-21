package raf.draft.dsw.JTabbePane.controller;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;

import javax.swing.*;
import java.awt.*;

public class DraftTabs extends JTabbedPane {
    private DraftPanel draftPanel;
    private DraftPanelView panelView;

    public DraftTabs() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        panelView = new DraftPanelView(this);
    }

    public void initialize(){
        setSize(draftPanel.getMaximumSize());
        draftPanel.add(this, BorderLayout.CENTER);
        draftPanel.setVisible(true);
    }

    public void setDraftPanel(DraftPanel draftPanel) {
        this.draftPanel = draftPanel;
        initialize();
    }

    public DraftPanelView getPanelView() {
        return panelView;
    }

    public DraftPanel getDraftPanel() {
        return draftPanel;
    }



}
