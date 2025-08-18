package raf.draft.dsw.JTabbePane.view;

import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.JTabbePane.model.DraftPanel;

import java.awt.*;
import java.util.List;

public class DraftPanelView {
    private DraftTabs draftTabs;

    public void addTabs(List<DraftPanel> tabs){
        for (DraftPanel tab : tabs) addTab(tab);
    }

    public void addTab(DraftPanel tab){
        DraftTabs.getInstance().getActiveTabs().add(tab);
        DraftTabs.getInstance().add(tab, tab.getIme());
        setTabColor(tab);
    }

    public void deleteAllTabs(){
        DraftTabs.getInstance().removeAll();
        DraftTabs.getInstance().getActiveTabs().clear();
    }

    public void deleteTab(DraftPanel tab){
        DraftTabs.getInstance().getActiveTabs().remove(tab);
        DraftTabs.getInstance().remove(tab);
    }

    public void changeTabName(String oldName, String newName){
        int index = DraftTabs.getInstance().indexOfTab(oldName);
        if (index != -1) DraftTabs.getInstance().setTitleAt(index, newName);
    }

    private void setTabColor(DraftPanel tab){
        int index = DraftTabs.getInstance().indexOfTab(tab.getIme());
        if (index != -1) DraftTabs.getInstance().setBackgroundAt(index, tab.getColor());
    }

}
