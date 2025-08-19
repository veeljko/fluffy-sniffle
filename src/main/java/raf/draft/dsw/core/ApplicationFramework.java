package raf.draft.dsw.core;

import raf.draft.dsw.errorhandler.view.ConsoleLogger;
import raf.draft.dsw.errorhandler.view.FileLogger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.view.MainFrame;

public class ApplicationFramework {
    //buduca polja za model celog projekta
    private MainFrame mainFrame;
    private MessageGenerator messageGenerator;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;

    public ApplicationFramework(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initialize();
    }

    public void initialize(){
        mainFrame.setVisible(true);
        messageGenerator = new MessageGenerator();
        LoggerFactory f = new LoggerFactory();
        consoleLogger = (ConsoleLogger) f.createLogger("consolelogger");
        fileLogger = (FileLogger) f.createLogger("filelogger");
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }

}
