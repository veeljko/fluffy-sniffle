package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.JTabbePane.view.DraftTabs;
import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodePublisher;
import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.view.MainFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraftTreeMouseListener extends MouseAdapter {
    private Temp tmp = new Temp();
    private DraftTreeItem lastSelectedForShowing = null;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON3) {
            MainFrame frame = MainFrame.getInstance();
            lastSelectedForShowing = frame.getMapTree().getSelectedNode();

            tmp.setLastSelectedForShowing(lastSelectedForShowing);
            tmp.notifySubscribers();

            DraftTabs draftTabs = frame.getTabs().getDraftTabs();
            draftTabs.addTabs(lastSelectedForShowing.getLeafs());
        }
    }

    public static class Temp extends ITreeSelectedNodePublisher {
        private DraftTreeItem lastSelectedForShowing = null;
        @Override
        public void notifySubscribers() {
            for (ITreeSelectedNodeSubscriber sub : super.getSubscriberList()){
                sub.update(lastSelectedForShowing);
            }
        }

        public void setLastSelectedForShowing(DraftTreeItem lastSelectedForShowing) {
            this.lastSelectedForShowing = lastSelectedForShowing;
        }
    }

    public Temp getTmp() {
        return tmp;
    }
}
