package raf.draft.dsw.JTabbePane.view;

import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import java.util.List;

public class DraftPanelView {
    private DraftTabs draftTabs;

    public DraftPanelView(DraftTabs draftTabs) {
        this.draftTabs = draftTabs;
    }

    public void addTab(DraftPanel tab){
        draftTabs.add(tab, tab.getIme());
        setTabColor(tab);
    }

    public void addTabs(List<DraftTreeItem> leafs){
        deleteAllTabs();
        for (DraftTreeItem leaf : leafs) {
            String ime = leaf.getDraftNode().getNodeIme();
            DraftPanel component = new DraftPanel((DraftTreeItem) leaf.getParent(), ime);
            addTab(component);
        }
    }

    public void deleteAllTabs(){
        draftTabs.removeAll();
    }

    public void changeTabName(String oldName, String newName){
        int index = draftTabs.indexOfTab(oldName);
        if (index != -1) draftTabs.setTitleAt(index, newName);
    }

    private void setTabColor(DraftPanel tab){
        int index = draftTabs.indexOfTab(tab.getIme());
        if (index != -1) draftTabs.setBackgroundAt(index, tab.getColor());
    }

}
