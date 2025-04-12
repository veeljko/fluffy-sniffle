package raf.draft.dsw.model;

public interface DraftRepository {
    public default DraftNode getRootI(DraftNode root) {
        if (root.getParent() == null) return root;
        return getRootI(root.getParent());
    }
}
