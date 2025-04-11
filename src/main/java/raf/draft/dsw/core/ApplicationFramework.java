package raf.draft.dsw.core;

import raf.draft.dsw.gui.swing.MainFrame;

public class ApplicationFramework {
    //buduca polja za model celog projekta
    private MainFrame mainFrame;
    private static ApplicationFramework instance = null;

    private ApplicationFramework(){
        initialize();
    }

    public void initialize(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    public static ApplicationFramework getInstance(){
        if (instance == null) instance = new ApplicationFramework();
        return instance;
    }
}
