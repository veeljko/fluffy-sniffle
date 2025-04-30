package raf.draft.dsw.JTabbePane.view;

import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.JTabbePane.model.DraftPanel;

import java.awt.*;
import java.util.List;

public class DraftPanelView {
    private DraftTabs draftTabs;

    public void addTabs(List<DraftPanel> tabs){
        for (DraftPanel tab : tabs) {
            DraftTabs.getInstance().getActiveTabs().add(tab);
        }
    }

    public void addTab(DraftPanel tab){
        DraftTabs.getInstance().getActiveTabs().add(tab);
        DraftTabs.getInstance().add(tab, tab.getIme());
        setTabColor(tab);
    }

    public void deleteAllTabs(){
        for (DraftPanel tab : DraftTabs.getInstance().getActiveTabs()) {
            DraftTabs.getInstance().remove(tab);
        }
        DraftTabs.getInstance().getActiveTabs().clear();
//        DraftTabs.getInstance().getDesktop().add(DraftTabs.getInstance(), BorderLayout.CENTER);
    }

    public void deleteTab(DraftPanel tab){
        DraftTabs.getInstance().getActiveTabs().remove(tab);
        DraftTabs.getInstance().remove(tab);
        DraftTabs.getInstance().getDesktop().removeAll();
        DraftTabs.getInstance().getDesktop().add(DraftTabs.getInstance(), BorderLayout.CENTER);
    }

    public void setTabColor(DraftPanel tab){
        int index = DraftTabs.getInstance().indexOfTab(tab.getIme());
        if (index != -1) DraftTabs.getInstance().setBackgroundAt(index, tab.getColor());
    }
}
