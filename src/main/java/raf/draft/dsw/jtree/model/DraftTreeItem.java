package raf.draft.dsw.jtree.model;
import raf.draft.dsw.jtree.model.composite.DraftNode;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;

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
}
