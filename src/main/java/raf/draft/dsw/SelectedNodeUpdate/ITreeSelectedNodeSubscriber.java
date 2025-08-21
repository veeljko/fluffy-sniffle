package raf.draft.dsw.SelectedNodeUpdate;

import raf.draft.dsw.jtree.model.DraftTreeItem;

public interface ITreeSelectedNodeSubscriber {
    public void update(DraftTreeItem node);
}
