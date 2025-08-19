package raf.draft.dsw.core;

import raf.draft.dsw.actions.aboutus.AboutUsAction;
import raf.draft.dsw.actions.DeleteAction;
import raf.draft.dsw.actions.ExitAction;
import raf.draft.dsw.actions.NewChildAction;
import raf.draft.dsw.actions.edit.modelEdit.EditAction;

public class ActionManager {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewChildAction newChildAction;
    private DeleteAction deleteAction;
    private EditAction editAction;

    public ActionManager(){
        exitAction = new ExitAction();
        aboutUsAction = new AboutUsAction();
        newChildAction = new NewChildAction();
        deleteAction = new DeleteAction();
        editAction = new EditAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public NewChildAction getNewChildAction() {
        return newChildAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }
}
