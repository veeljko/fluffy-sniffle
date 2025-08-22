package raf.draft.dsw.view;

import raf.draft.dsw.JTabbePane.controller.DraftTabController;
import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.core.ActionManager;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.controller.DraftTreeMouseListener;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private static MainFrame instance = null;
    private ActionManager actionManager;
    private DraftTree draftTree;
    private DraftTabController tabs;


    private MainFrame(){
        this.actionManager = new ActionManager();
        this.draftTree = new DraftTreeImplementation();
        this.tabs = new DraftTabController();

        initialize();

        addSubscriberToITree(actionManager.getEditAction());
        ((DraftTreeImplementation)this.draftTree).getTreeView().addTreeSelectionListener(((DraftTreeImplementation)this.draftTree).getTreeView().getRuTreeSelectionListener());
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
        DraftTreeMouseListener draftTreeMouseListener = new DraftTreeMouseListener();
        draftTreeMouseListener.getTmp().addSubscriber(tabs.getDraftPanel());

        projectExplorer.addMouseListener(draftTreeMouseListener);


        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,tabs.getDraftTabs());
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    private void addSubscriberToITree(ITreeSelectedNodeSubscriber subscriber){
        ((DraftTreeImplementation)this.draftTree).getTreeView().getRuTreeSelectionListener().addSubscriber(subscriber);
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

    public DraftTabController getTabs() {
        return tabs;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }
}
