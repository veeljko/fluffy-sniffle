package raf.draft.dsw.controller;

import raf.draft.dsw.jtree.model.DraftTreeItem;

public class CreateTabsAction implements ITreeSelectedNodeSubscriber{
    private DraftTreeItem treeItem;

    @Override
    public void update(DraftTreeItem node) {
        treeItem = node;

    }
}
