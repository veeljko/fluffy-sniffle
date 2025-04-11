package raf.draft.dsw.controller;

import raf.draft.dsw.core.AbstractRoomAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class AboutUsAction extends AbstractRoomAction {
    public AboutUsAction(){
        //bitno
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, super.loadIcon("/images/exit.png"));
        putValue(NAME, "About Us");
        putValue(SHORT_DESCRIPTION, "About Us");
    }

//    //deo koda za ucitavanje ikonice...
//    private Icon loadIcon(String path){
//        Icon icon = null;
//        URL ImageURL = getClass().getResource(path);
//        if(ImageURL != null)
//        {
//            Image img = new ImageIcon(ImageURL).getImage();
//            Image newImg = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//            icon = new ImageIcon(newImg);
//        }
//        else
//        {
//            System.err.println("File " + "images/exit.png" + " not found");
//        }
//        return icon;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Novi Prozor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Dobrodošli u novi prozor!", SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}