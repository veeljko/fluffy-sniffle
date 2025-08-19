package raf.draft.dsw.view;

import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;
import raf.draft.dsw.JTabbePane.DraftTabs;
import raf.draft.dsw.core.ApplicationFramework;
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
            frame.setLastSelectedProject(selected);
            DraftPanelView draftPanelView = DraftTabs.getInstance().getPanelView();
            draftPanelView.addTabs(selected.getLeafs());
        }
    }
}
