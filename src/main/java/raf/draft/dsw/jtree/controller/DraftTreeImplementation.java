package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.model.draftnodefactory.DraftNodeChildFactory;
import raf.draft.dsw.jtree.model.draftnodefactory.DraftNodeFactory;
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

    @Override
    public void addChild(DraftTreeItem parent) {
        DraftNodeFactory draftNodeFactory = new DraftNodeChildFactory(parent);
        DraftTreeItem childWrapper = draftNodeFactory.createDraftNode();

        if (childWrapper == null){
            System.err.println("Room ne moze da ima child");
            return;
        }

        if (parent.getDraftNode().getParent() instanceof Project && childWrapper.getDraftNode() instanceof Room){
            MainFrame frame = MainFrame.getInstance();
            DraftPanelView draftPanelView = MainFrame.getInstance().getTabs().getPanelView();
            DraftTreeItem lastSelectedProject = MainFrame.getInstance().getLastSelectedProject();
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

        //((DraftNodeComposite) parent.getDraftNode()).addChild(childWrapper.getDraftNode());
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    public DraftTreeView getTreeView() {
        return treeView;
    }

    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void deleteChild(DraftTreeItem parent, int childIndex) {
        DraftTreeItem child = (DraftTreeItem) parent.getChildAt(childIndex);
        parent.remove(childIndex);

        int index = MainFrame.getInstance().getTabs().indexOfTab(child.getDraftNode().getNodeIme());
        if (index != -1) MainFrame.getInstance().getTabs().remove(index);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
