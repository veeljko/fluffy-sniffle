package raf.draft.dsw.gui.swing;

import raf.draft.dsw.core.ActionManager;
import raf.draft.dsw.errorhandler.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private static MainFrame instance;
    private ActionManager actionManager;

    private MainFrame(){
        this.actionManager = new ActionManager();
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
}
