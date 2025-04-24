package raf.draft.dsw.controller;

import raf.draft.dsw.jtree.model.DraftTreeItem;

public interface ITreeSelectedNodeSubscriber {
    public void update(DraftTreeItem node);
}
