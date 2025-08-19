package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;
import raf.draft.dsw.JTabbePane.DraftTabs;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.Project;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class DraftTreeImplementation implements DraftTree {
    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;
    private static int cnt = 0;

    @Override
    public DraftTreeView generateTree(ProjectExplorer projectExplorer) {
        DraftTreeItem root = new DraftTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new DraftTreeView(treeModel);
        return treeView;
    }

    public DraftTreeView getTreeView() {
        return treeView;
    }

    @Override
    public void addChild(DraftTreeItem parent) {
        if (!(parent.getDraftNode() instanceof DraftNodeComposite)){
            System.err.println("Room ne moze da ima child");
            return;
        }

        DraftNode child = createChild(parent.getDraftNode());
        DraftTreeItem childWrapper = new DraftTreeItem(child);
        parent.add(childWrapper);

        if (parent.getDraftNode().getParent() instanceof Project && child instanceof Room){
            MainFrame frame = MainFrame.getInstance();
            DraftPanelView draftPanelView = DraftTabs.getInstance().getPanelView();
            DraftTreeItem lastSelectedProject = frame.getLastSelectedProject();
            if (lastSelectedProject != null) {
                //System.out.println(lastSelectedProject.getDraftNode().getNodeIme() + " " + parent.getDraftNode().getNodeIme());
                if (parent.getParent().equals(lastSelectedProject)) {
                    DraftPanel component = new DraftPanel(parent, childWrapper.getDraftNode().getNodeIme());
                    draftPanelView.addTab(component);
                }
                else if (lastSelectedProject.getDraftNode() instanceof Building){
                    if (childWrapper.getDraftNode().getParent().getNodeIme().equals(lastSelectedProject.getDraftNode().getNodeIme())) {
                        DraftPanel component = new DraftPanel(parent, childWrapper.getDraftNode().getNodeIme());
                        draftPanelView.addTab(component);
                    }
                }
            }
        }

        ((DraftNodeComposite) parent.getDraftNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }


    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void deleteChild(DraftTreeItem parent, int childIndex) {
        DraftTreeItem child = (DraftTreeItem) parent.getChildAt(childIndex);

        ((DraftNodeComposite) parent.getDraftNode()).removeChild(child.getDraftNode());
        parent.remove(childIndex);

        int index = DraftTabs.getInstance().indexOfTab(child.getDraftNode().getNodeIme());
        if (index != -1) DraftTabs.getInstance().remove(index);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private DraftNode createChild(DraftNode parent) {
        if (parent instanceof ProjectExplorer)
            return  new Project("Project" + cnt++, parent, "a");
        if (parent instanceof Project)
            return new Building("Building" + cnt++, parent, "a");
        if (parent instanceof Building)
            return new Room("Room" + cnt++, parent,"a");
        return null;
    }
}
