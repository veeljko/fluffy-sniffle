package raf.draft.dsw.jtree.model;
import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;
import raf.draft.dsw.jtree.model.implementation.Room;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;

public class DraftTreeItem extends DefaultMutableTreeNode {
    private DraftNode draftNode;

    public DraftTreeItem(DraftNode nodeModel) {
        this.draftNode = nodeModel;
    }

    @Override
    public String toString() {
        return draftNode.getNodeIme();
    }

    public void setName(String name) {
        this.draftNode.setIme(name);
    }

    public DraftNode getDraftNode() {
        return draftNode;
    }

    public void setDraftNode(DraftNode draftNode) {
        this.draftNode = draftNode;
    }

    public ArrayList<DraftTreeItem> getLeafs(){
        if (children().equals(Collections.emptyEnumeration())) return null;
        ArrayList<TreeNode> leafs = Collections.list(children());
        ArrayList<DraftTreeItem> items = new ArrayList<DraftTreeItem>();

        DraftTreeItem leaf = (DraftTreeItem) getFirstLeaf();
        while (leaf != null) {
            if (leaf.getDraftNode() instanceof Room) items.add(leaf);
            leaf = (DraftTreeItem) leaf.getNextLeaf();
        }
        return items;
    }
}
