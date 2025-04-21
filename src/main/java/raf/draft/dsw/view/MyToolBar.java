package raf.draft.dsw.view;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.Actions;
import raf.draft.dsw.controller.ExitAction;
import raf.draft.dsw.controller.NewChildAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    public MyToolBar(){
        super(HORIZONTAL);
        ExitAction ea = Actions.getInstance().getExitAction();
        AboutUsAction ab = Actions.getInstance().getAboutUsAction();
        NewChildAction nca = Actions.getInstance().getNewChildAction();
        setFloatable(false);
        add(ea);
        add(ab);
        add(nca);
    }
}
