package raf.draft.dsw.jtree;

import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;

public interface DraftTree {
    DraftTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(DraftTreeItem parent);
    DraftTreeItem getSelectedNode();
    void deleteChild(DraftTreeItem parent, int childIndex);
}
