package raf.draft.dsw.jtree.controller;

import org.w3c.dom.Node;
import raf.draft.dsw.controller.ITreeSelectedNodePublisher;
import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.composite.DraftNode;

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
