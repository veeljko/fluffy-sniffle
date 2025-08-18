package raf.draft.dsw.view;

import raf.draft.dsw.actions.AboutUsAction;
import raf.draft.dsw.actions.ExitAction;
import raf.draft.dsw.actions.DeleteAction;
import raf.draft.dsw.actions.NewChildAction;
import raf.draft.dsw.controller.modelEdit.EditAction;
import raf.draft.dsw.core.ActionManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = ActionManager.getInstance().getExitAction();
        AboutUsAction au = ActionManager.getInstance().getAboutUsAction();
        NewChildAction nca = ActionManager.getInstance().getNewChildAction();
        DeleteAction da = ActionManager.getInstance().getDeleteAction();
        EditAction eaa = ActionManager.getInstance().getEditAction();
        fileMenu.add(ea);
        fileMenu.add(au);
        fileMenu.add(nca);
        fileMenu.add(da);
        fileMenu.add(eaa);
        add(fileMenu);
    }
}
