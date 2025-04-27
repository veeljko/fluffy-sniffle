package raf.draft.dsw.core;

import raf.draft.dsw.controller.*;

public class ActionManager {
    private ExitAction exitAction = new ExitAction();
    private AboutUsAction aboutUsAction = new AboutUsAction();
    private NewChildAction newChildAction = new NewChildAction();
    private DeleteAction deleteAction = new DeleteAction();
    private CreateTabsAction createTabsAction = new CreateTabsAction();

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

    public CreateTabsAction getCreateTabsAction() { return createTabsAction; }
}
