package raf.draft.dsw.view;

import raf.draft.dsw.JTabbePane.view.DraftPanelView;
import raf.draft.dsw.jtree.model.DraftTreeItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraftTreeMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON3) {
            MainFrame frame = MainFrame.getInstance();
            DraftTreeItem selected = frame.getMapTree().getSelectedNode();
            frame.setLastSelectedProject(selected);
            DraftPanelView draftPanelView = frame.getTabs().getPanelView();
            draftPanelView.addTabs(selected.getLeafs());
        }
    }
}
