package raf.draft.dsw.JTabbePane.model;

import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.JTabbePane.view.DraftTabs;
import raf.draft.dsw.errorhandler.Greska;
import raf.draft.dsw.errorhandler.Logger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DraftPanel extends JPanel implements ITreeSelectedNodeSubscriber {
    private DraftTreeItem lastSelectedProject;


    public DraftPanel(BorderLayout borderLayout) {
        super(borderLayout);
    }

    public boolean isAddable(DraftTreeItem childWrapper){
        if (childWrapper == null) return false;

        if (!(childWrapper.getDraftNode() instanceof Room)) return false;
        if (lastSelectedProject == null) return false;


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
        DraftTabs draftTabs = MainFrame.getInstance().getTabs().getDraftTabs();
        DraftTreeItem lastChild = parent.getLeafs().get(childCount - 2);
        int index = draftTabs.indexOfTab(lastChild.getDraftNode().getNodeIme());
        return index + 1;
    }


    @Override
    public void update(DraftTreeItem node) {
        lastSelectedProject = node;
    }
}
