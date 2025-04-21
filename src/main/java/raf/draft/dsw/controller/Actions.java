package raf.draft.dsw.controller;

public class Actions {
    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewChildAction newChildAction;
    private DeleteAction deleteAction;
    private EditAction editAction;
    private static Actions instance;

    private Actions(){
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

    public static Actions getInstance(){
        if(instance == null){
            instance = new Actions();
        }
        return instance;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }
}
