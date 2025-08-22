package raf.draft.dsw.actions.model;

import raf.draft.dsw.errorhandler.Greska;
import raf.draft.dsw.errorhandler.Logger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.errorhandler.view.ConsoleLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Date;

public abstract class AbstractRoomAction extends AbstractAction {

    public Icon loadIcon(String path){
        Icon icon = null;
        URL ImageURL = getClass().getResource(path);
        if(ImageURL != null)
        {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else
        {
            MessageGenerator newMessage = new MessageGenerator("URL of icon doesn't exits", Greska.UPOZORENJE, new Date());
            Logger logger = new LoggerFactory().createLogger("consolelogger");
            logger.log(newMessage.toString());

        }
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}
