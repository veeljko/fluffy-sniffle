package raf.draft.dsw.view;

import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.core.ActionManager;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private static MainFrame instance = null;
    private ActionManager actionManager;
    private DraftTree draftTree;
    private DraftTabs tabs;
    private DraftPanel desktop;
    private DraftTreeItem lastSelectedProject;


    private MainFrame(){
        this.draftTree = new DraftTreeImplementation();
        this.actionManager = new ActionManager();
        this.tabs = new DraftTabs();
        this.desktop = new DraftPanel(new BorderLayout());

        lastSelectedProject = null;
        tabs.setDesktop(desktop);
        initialize();
    }

    private void initialize(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DraftRoom");

        MyMenuBar menuBar = new MyMenuBar(actionManager);
        setJMenuBar(menuBar);

        MyToolBar toolBar = new MyToolBar(actionManager);
        add(toolBar, BorderLayout.NORTH);

        JTree projectExplorer = draftTree.generateTree(new ProjectExplorer("Project Explorer", "a"));
        projectExplorer.addMouseListener(new DraftTreeMouseListener());

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);


    }


    public void setLastSelectedProject(DraftTreeItem lastSelectedProject){
        this.lastSelectedProject = lastSelectedProject;
    }

    public DraftTreeItem getLastSelectedProject(){
        return lastSelectedProject;
    }

    public static MainFrame getInstance(){
        if (instance == null) instance = new MainFrame();
        return instance;
    }

    public DraftTree getMapTree() {
        return draftTree;
    }


    public DraftTree getDraftTree() {
        return draftTree;
    }

    public DraftTabs getTabs() {
        return tabs;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }
}
