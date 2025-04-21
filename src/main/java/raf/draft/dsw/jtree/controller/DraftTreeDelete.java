package raf.draft.dsw.jtree.controller;

import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DraftTreeDelete implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTree dt = MainFrame.getInstance().getMapTree();
        DraftTreeItem target = ((DraftTreeImplementation)dt).getSelectedNode();
    }
}
