package raf.draft.dsw.core;

import raf.draft.dsw.errorhandler.ConsoleLogger;
import raf.draft.dsw.errorhandler.FileLogger;
import raf.draft.dsw.errorhandler.LoggerFactory;
import raf.draft.dsw.errorhandler.MessageGenerator;
import raf.draft.dsw.gui.swing.MainFrame;

import java.io.Console;

public class ApplicationFramework {
    //buduca polja za model celog projekta
    private MainFrame mainFrame;
    private static ApplicationFramework instance = null;
    private MessageGenerator messageGenerator;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;


    private ApplicationFramework(){
        initialize();
    }

    public void initialize(){
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
        messageGenerator = new MessageGenerator();
        LoggerFactory f = new LoggerFactory();
        consoleLogger = (ConsoleLogger) f.createLogger("consolelogger");
        fileLogger = (FileLogger) f.createLogger("filelogger");
    }

    public static ApplicationFramework getInstance(){
        if (instance == null) instance = new ApplicationFramework();
        return instance;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }
}
