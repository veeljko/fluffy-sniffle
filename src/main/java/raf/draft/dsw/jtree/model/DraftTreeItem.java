package raf.draft.dsw.jtree.model;
import com.sun.source.tree.Tree;
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

    private void dfs(DraftTreeItem node, ArrayList<DraftTreeItem>leafs){
        if (node.getDraftNode() instanceof Room){
            leafs.add(node);
        }
        else{
            if (node.children().equals(Collections.emptyEnumeration())) return;
            ArrayList<TreeNode> children = Collections.list(node.children());
            for (TreeNode child : children){
                dfs((DraftTreeItem) child, leafs);
            }
        }
    }

    public ArrayList<DraftTreeItem> getLeafs(){
        ArrayList<DraftTreeItem> items = new ArrayList<DraftTreeItem>();
        dfs(this, items);
        return items;
    }
}
