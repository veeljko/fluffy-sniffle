package raf.draft.dsw.JTabbePane;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;

import javax.swing.*;
import java.awt.*;

public class DraftTabs extends JTabbedPane {
    private DraftPanel desktop;
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

    public void setDesktop(DraftPanel desktop) {
        this.desktop = desktop;
        initialize();
    }

    public DraftPanelView getPanelView() {
        return panelView;
    }

}
