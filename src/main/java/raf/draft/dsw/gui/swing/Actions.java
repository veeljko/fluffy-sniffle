package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.ExitAction;

public class Actions {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private static Actions instance;

    private Actions(){
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public static Actions getInstance(){
        if(instance == null){
            instance = new Actions();
        }
        return instance;
    }
}
