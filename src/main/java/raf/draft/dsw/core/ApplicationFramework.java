package raf.draft.dsw.core;

import raf.draft.dsw.gui.swing.MainFrame;

public class ApplicationFramework {
    //buduca polja za model celog projekta
    private MainFrame mainFrame;
    private ApplicationFramework instance = null;

    private ApplicationFramework(){
        if (instance == null) initialize();
    }

    public void initialize(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }

    public static ApplicationFramework getInstance(){
        ApplicationFramework applicationFramework = new ApplicationFramework();
        return applicationFramework;
    }
}
