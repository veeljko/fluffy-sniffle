package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.controller.ITreeSelectedNodePublisher;
import raf.draft.dsw.controller.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Project;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.util.List;

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

        if (lastClicked.getDraftNode() instanceof Project) {
            List<DraftTreeItem> childs = lastClicked.getLeafs();
            System.out.println("Sobe koje se nalaze u Project-u su: " + childs);
        }
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
