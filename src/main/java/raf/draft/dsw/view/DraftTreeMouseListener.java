package raf.draft.dsw.view;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;
import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.Project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DraftTreeMouseListener extends MouseAdapter {


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON3) {
            MainFrame frame = MainFrame.getInstance();
            DraftTreeItem selected = frame.getMapTree().getSelectedNode();
            if (selected != null) {
                if (selected.getDraftNode() instanceof Building) frame.setLastSelectedProject(selected);
                else if (selected.getDraftNode() instanceof Project) frame.setLastSelectedProject(selected);
                DraftPanelView draftPanelView = DraftTabs.getInstance().getPanelView();
                draftPanelView.deleteAllTabs();
                List<DraftTreeItem> leafs = selected.getLeafs();
                for (DraftTreeItem leaf : leafs) {
                    String ime = leaf.getDraftNode().getNodeIme();
                    DraftPanel component = new DraftPanel((DraftTreeItem) leaf.getParent(), ime);
                    draftPanelView.addTab(component);
                }
            }
        }
    }
}
