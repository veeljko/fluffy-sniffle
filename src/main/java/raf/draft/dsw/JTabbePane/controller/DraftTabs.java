package raf.draft.dsw.JTabbePane.controller;

import com.sun.tools.javac.Main;
import raf.draft.dsw.DraftNodeChangeUpdate.IDraftNodeChangeSubscriber;
import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.DraftPanelView;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.view.DraftTreeView;
import raf.draft.dsw.view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class DraftTabs extends JTabbedPane implements IDraftNodeChangeSubscriber {
    private DraftPanel draftPanel;
    private DraftPanelView panelView;

    public DraftTabs() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        panelView = new DraftPanelView(this);
    }

    public void initialize(){
        setSize(draftPanel.getMaximumSize());
        draftPanel.add(this, BorderLayout.CENTER);
        draftPanel.setVisible(true);
    }

    public void setDraftPanel(DraftPanel draftPanel) {
        this.draftPanel = draftPanel;
        initialize();
    }

    public DraftPanelView getPanelView() {
        return panelView;
    }

    public DraftPanel getDraftPanel() {
        return draftPanel;
    }


    @Override
    public void update(String oldName, String newName, String newAutor) {
        panelView.changeTabName(oldName, newName);
        DraftTreeItem target = MainFrame.getInstance().getDraftTree().getSelectedNode();
        target.setName(newName);
        target.setAutor(newAutor);

        refresh();
    }
}
