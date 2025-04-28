package raf.draft.dsw.jtree;

import raf.draft.dsw.jtree.model.composite.DraftNode;

public interface DraftRepository {
    public default DraftNode getRootI(DraftNode root) {
        if (root.getParent() == null) return root;
        return getRootI(root.getParent());
    }
}
