package raf.draft.dsw.JTabbePane.model;

import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DraftPanel extends JPanel implements ITreeSelectedNodeSubscriber {
    private String ime;
    private Color color;
    private DraftTreeItem lastSelectedProject;
    private DraftTreeItem tabParent;

    public DraftPanel(DraftTreeItem parent, String ime) {
        tabParent = parent;
        this.ime = ime;
        if (parent.getDraftNode() instanceof Building) this.color = ((Building) parent.getDraftNode()).getColor();
        else this.color = Color.BLACK;
    }

    public DraftPanel(BorderLayout borderLayout) {
        super(borderLayout);
    }

    public boolean isAddable(DraftTreeItem childWrapper){
        if (childWrapper == null) return false;

        if (!(childWrapper.getDraftNode() instanceof Room) || lastSelectedProject == null) return false;

        DraftTreeItem parent = (DraftTreeItem) childWrapper.getParent();
        if (lastSelectedProject.getDraftNode() instanceof ProjectExplorer) return false;
        if (parent.getParent().equals(lastSelectedProject)) return true;
        if (lastSelectedProject.getDraftNode() instanceof Building){
            return childWrapper.getDraftNode().getParent().getNodeIme().equals(lastSelectedProject.getDraftNode().getNodeIme());
        }

        return false;
    }

    public int getIndexOfPanelToInsert(DraftTreeItem parent){
        int childCount = parent.getChildCount();
        if (childCount == 1) {
            DraftTreeItem parentOfParent = (DraftTreeItem) parent.getParent();
            var tmp = new Object() {
                int index = 0;
                boolean ok = true;
            };
            parentOfParent.children().asIterator().forEachRemaining(c -> {
                DraftTreeItem child = (DraftTreeItem) c;
                if (child.getDraftNode().getNodeIme().equals(parent.getDraftNode().getNodeIme())){
                    tmp.ok = false;
                }
                else if (tmp.ok) tmp.index += child.getChildCount();
            });
            return tmp.index;
        }
        DraftTabs draftTabs = MainFrame.getInstance().getTabs();
        DraftTreeItem lastChild = parent.getLeafs().get(childCount - 2);
        int index = draftTabs.indexOfTab(lastChild.getDraftNode().getNodeIme());
        return index + 1;
    }

    public String getIme() {
        return ime;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DraftPanel that = (DraftPanel) o;
        return ime.equals(that.ime) && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, color);
    }

    @Override
    public void update(DraftTreeItem node) {
        lastSelectedProject = node;
    }

    public DraftTreeItem getTabParent() {
        return tabParent;
    }
}
