package raf.draft.dsw.view;

import raf.draft.dsw.controller.*;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = Actions.getInstance().getExitAction();
        AboutUsAction au = Actions.getInstance().getAboutUsAction();
        NewChildAction nca = Actions.getInstance().getNewChildAction();
        DeleteAction da = Actions.getInstance().getDeleteAction();
        EditAction eaa = Actions.getInstance().getEditAction();
        fileMenu.add(ea);
        fileMenu.add(au);
        fileMenu.add(nca);
        fileMenu.add(da);
        fileMenu.add(eaa);
        add(fileMenu);
    }
}
