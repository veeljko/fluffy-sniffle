package raf.draft.dsw.jtree.model.draftnodefactory;

import raf.draft.dsw.jtree.model.DraftTreeItem;

public abstract class DraftNodeFactory {
    private DraftTreeItem parent;
    private static int cnt = 0;

    public DraftNodeFactory(DraftTreeItem parent) {
        this.parent = parent;
    }

    public abstract DraftTreeItem createDraftNode();

    public static int getCnt() {
        return cnt++;
    }

    public DraftTreeItem getParent() {
        return parent;
    }

    public void setParent(DraftTreeItem parent) {
        this.parent = parent;
    }
}
