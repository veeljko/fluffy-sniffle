package raf.draft.dsw.jtree;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.Project;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class DraftTreeImplementation implements DraftTree {
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
        if (!(parent.getDraftNode() instanceof DraftNodeComposite)){
            System.err.println("Room ne moze da ima child");
            return;
        }

        DraftNode child = createChild(parent.getDraftNode());
        DraftTreeItem childWrapper = new DraftTreeItem(child);
        parent.add(childWrapper);
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
        if (parent.getDraftNode() instanceof ProjectExplorer){
            System.out.println("ProjectExplorer ne moze da se izbrise");
            return;
        }
        parent.remove(childIndex);
        ((DraftNodeComposite)parent.getDraftNode()).removeChild((DraftNode) parent.getChildAt(childIndex));
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private DraftNode createChild(DraftNode parent) {
        if (parent instanceof ProjectExplorer)
            return  new Project("Project" +new Random().nextInt(100), parent, "a","a");
        if (parent instanceof Project)
            return new Building("Building" +new Random().nextInt(100), parent, "a","a");
        if (parent instanceof Building)
            return new Room("Room" +new Random().nextInt(100), parent,"a","a");
        return null;
    }
}
