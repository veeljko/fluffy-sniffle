package raf.draft.dsw.jtree.controller;

import SelectedNodeUpdate.ITreeSelectedNodePublisher;
import SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class DraftTreeSelectionListener extends ITreeSelectedNodePublisher implements TreeSelectionListener{
    private DraftTreeItem lastSelected = null;
    public void valueChanged(TreeSelectionEvent e) {
        lastSelected = (DraftTreeItem) e.getPath().getLastPathComponent();
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for (ITreeSelectedNodeSubscriber sub : super.getSubscriberList()) sub.update(lastSelected);
    }
}
