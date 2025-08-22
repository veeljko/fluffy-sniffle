package raf.draft.dsw.view;

import raf.draft.dsw.actions.aboutus.AboutUsAction;
import raf.draft.dsw.actions.ExitAction;
import raf.draft.dsw.actions.DeleteAction;
import raf.draft.dsw.actions.NewChildAction;
import raf.draft.dsw.actions.edit.controllerEdit.EditAction;
import raf.draft.dsw.core.ActionManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    private ActionManager actionManager;
    public MyMenuBar(ActionManager actionManager) {
        this.actionManager = actionManager;
        initialize();
    }

    private void initialize(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = actionManager.getExitAction();
        AboutUsAction au = actionManager.getAboutUsAction();
        NewChildAction nca = actionManager.getNewChildAction();
        DeleteAction da = actionManager.getDeleteAction();
        EditAction eaa = actionManager.getEditAction();
        fileMenu.add(ea);
        fileMenu.add(au);
        fileMenu.add(nca);
        fileMenu.add(da);
        fileMenu.add(eaa);
        add(fileMenu);
    }
}
