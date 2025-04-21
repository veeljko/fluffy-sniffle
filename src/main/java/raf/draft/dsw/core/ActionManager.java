package raf.draft.dsw.core;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.DeleteAction;
import raf.draft.dsw.controller.ExitAction;
import raf.draft.dsw.controller.NewChildAction;

public class ActionManager {
    ExitAction exitAction = new ExitAction();
    AboutUsAction aboutUsAction = new AboutUsAction();
    NewChildAction newChildAction = new NewChildAction();
    DeleteAction deleteAction = new DeleteAction();

    public ActionManager() {

    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewChildAction getNewChildAction() {
        return newChildAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }
}
