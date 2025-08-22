package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.DraftNodeChangeUpdate.IDraftNodeChangeSubscriber;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.model.draftnodefactory.DraftNodeChildFactory;
import raf.draft.dsw.jtree.model.draftnodefactory.DraftNodeFactory;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;
import raf.draft.dsw.view.MainFrame;
import javax.swing.tree.DefaultTreeModel;

public class DraftTreeImplementation implements DraftTree, IDraftNodeChangeSubscriber {
    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;

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

        if (MainFrame.getInstance().getTabs().getDraftPanel().isAddable(childWrapper)){
            MainFrame.getInstance().getTabs().addTab(childWrapper);
        }

        refresh();
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
        MainFrame.getInstance().getTabs().getDraftTabs().removeTab(child);
        refresh();
    }

    @Override
    public void update(String oldName, String newName, String newAutor) {
        getSelectedNode().setName(newName);
        getSelectedNode().setAutor(newAutor);

        refresh();
    }

}
