package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.jtree.ITreeSelectedNodePublisher;
import raf.draft.dsw.jtree.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class DraftTreeSelectionListener extends ITreeSelectedNodePublisher implements TreeSelectionListener {
    private static DraftTreeItem lastClicked;
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        DraftTreeItem treeItemSelected = (DraftTreeItem)path.getLastPathComponent();
        lastClicked = treeItemSelected;
        notifySubscribers();
        System.out.println("Selektovan cvor:"+ treeItemSelected.getDraftNode().getNodeIme());
        System.out.println("getPath: "+e.getPath());
    }

    public static DraftTreeItem getLastClicked() {
        return lastClicked;
    }

    @Override
    public void notifySubscribers() {
        for (ITreeSelectedNodeSubscriber sub : super.getSubscriberList()){
            sub.update(lastClicked);
        }
    }
}
