package raf.draft.dsw.JTabbePane.view;

import raf.draft.dsw.JTabbePane.DraftTabs;
import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import java.util.List;

public class DraftPanelView {

    public void addTab(DraftPanel tab){
        DraftTabs.getInstance().add(tab, tab.getIme());
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
        DraftTabs.getInstance().removeAll();
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
