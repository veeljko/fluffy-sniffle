package raf.draft.dsw.core;

import raf.draft.dsw.errorhandler.view.ConsoleLogger;
import raf.draft.dsw.errorhandler.view.FileLogger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.view.MainFrame;

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
