package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.ExitAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    public MyToolBar(){
        super(HORIZONTAL);
        ExitAction ea = Actions.getInstance().getExitAction();
        AboutUsAction ab = Actions.getInstance().getAboutUsAction();
        setFloatable(false);
        add(ea);
        add(ab);
    }
}
