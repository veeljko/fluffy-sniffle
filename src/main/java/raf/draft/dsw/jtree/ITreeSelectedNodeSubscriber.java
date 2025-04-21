package raf.draft.dsw.jtree;

import raf.draft.dsw.jtree.model.DraftTreeItem;

public interface ITreeSelectedNodeSubscriber {
    public void update(DraftTreeItem node);
}
