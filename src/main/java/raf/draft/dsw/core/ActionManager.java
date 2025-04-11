package raf.draft.dsw.core;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.ExitAction;

public class ActionManager {
    ExitAction exitAction = new ExitAction();
    AboutUsAction aboutUsAction = new AboutUsAction();

    public ActionManager() {
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }
}
