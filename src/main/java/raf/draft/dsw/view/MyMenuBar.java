package raf.draft.dsw.view;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.Actions;
import raf.draft.dsw.controller.ExitAction;
import raf.draft.dsw.controller.NewChildAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = Actions.getInstance().getExitAction();
        AboutUsAction au = Actions.getInstance().getAboutUsAction();
        NewChildAction nca = Actions.getInstance().getNewChildAction();
        fileMenu.add(ea);
        fileMenu.add(au);
        fileMenu.add(nca);
        add(fileMenu);

    }
}
