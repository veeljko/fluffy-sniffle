package raf.draft.dsw.actions.aboutus;

import raf.draft.dsw.actions.model.AbstractRoomAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AboutUsAction extends AbstractRoomAction {
    public AboutUsAction(){
        //bitno
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, super.loadIcon("/images/exit.png"));
        putValue(NAME, "About Us");
        putValue(SHORT_DESCRIPTION, "About Us");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutUsWindow window = new AboutUsWindow();
        window.setVisible(true);
    }
}