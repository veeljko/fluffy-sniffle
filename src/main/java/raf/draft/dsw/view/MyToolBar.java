package raf.draft.dsw.view;

import com.sun.tools.javac.Main;
import raf.draft.dsw.actions.aboutus.AboutUsAction;
import raf.draft.dsw.actions.ExitAction;
import raf.draft.dsw.actions.DeleteAction;
import raf.draft.dsw.actions.NewChildAction;
import raf.draft.dsw.actions.edit.modelEdit.EditAction;
import raf.draft.dsw.core.ActionManager;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    private ActionManager actionManager;

    public MyToolBar(ActionManager actionManager) {
        super(HORIZONTAL);
        this.actionManager = actionManager;
        initialize();
    }

    private void initialize(){
        ExitAction ea = actionManager.getExitAction();
        AboutUsAction ab = actionManager.getAboutUsAction();
        NewChildAction nca = actionManager.getNewChildAction();
        DeleteAction da = actionManager.getDeleteAction();
        EditAction ea2 = actionManager.getEditAction();
        setFloatable(false);
        add(ea);
        add(ab);
        add(nca);
        add(da);
        add(ea2);
    }
}
