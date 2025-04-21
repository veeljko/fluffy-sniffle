package raf.draft.dsw.view;

import raf.draft.dsw.controller.*;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    public MyToolBar(){
        super(HORIZONTAL);
        ExitAction ea = Actions.getInstance().getExitAction();
        AboutUsAction ab = Actions.getInstance().getAboutUsAction();
        NewChildAction nca = Actions.getInstance().getNewChildAction();
        DeleteAction da = Actions.getInstance().getDeleteAction();
        EditAction ea2 = Actions.getInstance().getEditAction();
        setFloatable(false);
        add(ea);
        add(ab);
        add(nca);
        add(da);
        add(ea2);
    }
}
