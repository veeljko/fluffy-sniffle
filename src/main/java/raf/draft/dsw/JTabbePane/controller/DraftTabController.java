package raf.draft.dsw.JTabbePane.controller;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftTabs;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import java.awt.*;

public class DraftTabController {
    private DraftTabs draftTabs;
    private DraftPanel draftPanel;

    public DraftTabController() {
        draftTabs = new DraftTabs();
        draftPanel = new DraftPanel(new BorderLayout());
    }

    public void addTab(DraftTreeItem childWrapper){
        DraftTreeItem parent = (DraftTreeItem) childWrapper.getParent();
        int index = draftPanel.getIndexOfPanelToInsert(parent);
        draftTabs.addTab(childWrapper, index);
    }

    public DraftTabs getDraftTabs() {
        return draftTabs;
    }

    public void setDraftTabs(DraftTabs draftTabs) {
        this.draftTabs = draftTabs;
    }

    public DraftPanel getDraftPanel() {
        return draftPanel;
    }

    public void setDraftPanel(DraftPanel draftPanel) {
        this.draftPanel = draftPanel;
    }
}
