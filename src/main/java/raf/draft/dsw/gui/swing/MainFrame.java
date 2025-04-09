package raf.draft.dsw.gui.swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //buduca polja za sve komponente view-a na glavnom prozoru
    private Toolkit kit;
    private Dimension screenSize;
    private MyMenuBar menu;
    private MyToolBar toolBar;
    private int screenHeight;
    private int screenWidth;
    private MainFrame instance = null;

    private MainFrame(){
        if (instance == null) initialize();
    }

    private void initialize(){
        kit = Toolkit.getDefaultToolkit();
        screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DraftRoom");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
    }

    public static MainFrame getInstance(){
        MainFrame frame = new MainFrame();
        return frame;
    }
}
