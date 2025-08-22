package raf.draft.dsw.JTabbePane.view;

import raf.draft.dsw.DraftNodeChangeUpdate.IDraftNodeChangeSubscriber;
import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.JTabbePane.view.windowImplementation.DraftTabWindow;
import raf.draft.dsw.errorhandler.Greska;
import raf.draft.dsw.errorhandler.Logger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class DraftTabs extends JTabbedPane implements IDraftNodeChangeSubscriber {
    private DraftPanel draftPanel;
    public DraftTabs() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
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


    public DraftPanel getDraftPanel() {
        return draftPanel;
    }


    @Override
    public void update(String oldName, String newName, String newAutor) {
        changeTabName(oldName, newName);
        int index = indexOfTab(newName);
        DraftTabWindow tabWindow = (DraftTabWindow) getComponentAt(index);
        tabWindow.setLabelName(newName);
        tabWindow.setLabelAutor(newAutor);
        refresh();
    }


    public void addTab(DraftTabWindow tab, Color color){
        add(tab, tab.getTabName());
        tab.setColor(color);
        setTabColor(tab);
    }

    public void addTabs(List<DraftTreeItem> leafs){
        deleteAllTabs();
        for (DraftTreeItem leaf : leafs) {
            String ime = leaf.getDraftNode().getNodeIme();
            String autor = leaf.getDraftNode().getAutor();
            DraftTabWindow component = new DraftTabWindow(ime, autor);

            DraftTreeItem parent = (DraftTreeItem) leaf.getParent();
            addTab(component, ((Building)parent.getDraftNode()).getColor());
        }
    }

    public void deleteAllTabs(){
        removeAll();
    }

    public void changeTabName(String oldName, String newName){
        int index = indexOfTab(oldName);
        if (index != -1) setTitleAt(index, newName);
        else{
            MessageGenerator newMessage = new MessageGenerator("Can't find tab to change name", Greska.UPOZORENJE, new Date());
            Logger logger = new LoggerFactory().createLogger("consolelogger");
            logger.log(newMessage.toString());
        }
    }

    private void setTabColor(DraftTabWindow tab){
        int index = indexOfTab(tab.getTabName());
        if (index != -1) setBackgroundAt(index, tab.getColor());
        else{
            MessageGenerator newMessage = new MessageGenerator("Can't find tab to change color", Greska.UPOZORENJE, new Date());
            Logger logger = new LoggerFactory().createLogger("consolelogger");
            logger.log(newMessage.toString());
        }
    }

    public void addTab(DraftTreeItem childWrapper, int index){
        DraftTreeItem parent = (DraftTreeItem) childWrapper.getParent();

        String ime = childWrapper.getDraftNode().getNodeIme();
        String autor = childWrapper.getDraftNode().getAutor();
        DraftTabWindow component = new DraftTabWindow(ime, autor);

        insertTab(childWrapper.getDraftNode().getNodeIme(), null, component, null, index);

        if (parent.getDraftNode() instanceof Building) component.setColor(((Building)parent.getDraftNode()).getColor());

        setTabColor(component);
    }

    public void removeTab(DraftTreeItem child){
        int index = indexOfTab(child.getDraftNode().getNodeIme());
        if (index != -1) remove(index);
    }
}
