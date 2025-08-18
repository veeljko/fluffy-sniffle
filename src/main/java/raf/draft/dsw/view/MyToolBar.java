package raf.draft.dsw.view;

import raf.draft.dsw.actions.AboutUsAction;
import raf.draft.dsw.actions.ExitAction;
import raf.draft.dsw.actions.DeleteAction;
import raf.draft.dsw.actions.NewChildAction;
import raf.draft.dsw.controller.modelEdit.EditAction;
import raf.draft.dsw.core.ActionManager;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    public MyToolBar(){
        super(HORIZONTAL);
        ExitAction ea = ActionManager.getInstance().getExitAction();
        AboutUsAction ab = ActionManager.getInstance().getAboutUsAction();
        NewChildAction nca = ActionManager.getInstance().getNewChildAction();
        DeleteAction da = ActionManager.getInstance().getDeleteAction();
        EditAction ea2 = ActionManager.getInstance().getEditAction();
        setFloatable(false);
        add(ea);
        add(ab);
        add(nca);
        add(da);
        add(ea2);
    }
}
