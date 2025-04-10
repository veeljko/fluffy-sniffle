package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.ExitAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = Actions.getInstance().getExitAction();
        AboutUsAction au = Actions.getInstance().getAboutUsAction();
        fileMenu.add(ea);
        fileMenu.add(au);
        add(fileMenu);

    }
}
