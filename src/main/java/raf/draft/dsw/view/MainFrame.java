package raf.draft.dsw.view;

import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.core.ActionManager;
import raf.draft.dsw.errorhandler.ISubscriber;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private static MainFrame instance;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private DraftTree draftTree;
    private DraftTabs tabs;
    private JPanel desktop;
    private DraftTreeItem lastSelectedProject;


    private MainFrame(){
        this.actionManager = new ActionManager();
        this.draftTree = new DraftTreeImplementation();
        lastSelectedProject = null;

        tabs = DraftTabs.getInstance();
        desktop = new JPanel(new BorderLayout());
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

        MyMenuBar menuBar = new MyMenuBar();
        setJMenuBar(menuBar);

        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);

        JTree projectExplorer = draftTree.generateTree(new ProjectExplorer("Project Explorer", "a", "a"));
        projectExplorer.addMouseListener(new DraftTreeMouseListener());

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }
//
//    public void addTab(DraftPanel component){
//        tabs.addTab(component.getIme(), component);
//        desktop.add(tabs, BorderLayout.CENTER);
//    }
//
//    public void deleteTabs(){
//        tabs.removeAll();
//        desktop.removeAll();
//    }
//
//    public JTabbedPane getTabs(){
//        return tabs;
//    }

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

    public ActionManager getActionManager() {
        return actionManager;
    }

    @Override
    public void update(String message) {
        JOptionPane.showMessageDialog(null, "Uneta poruka: " + message, "Prikaz poruke", JOptionPane.INFORMATION_MESSAGE);
    }

    public DraftTree getMapTree() {
        return draftTree;
    }
}
