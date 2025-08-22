package raf.draft.dsw.core;

import com.sun.tools.javac.Main;
import raf.draft.dsw.DraftNodeChangeUpdate.IDaftNodeChangePublisher;
import raf.draft.dsw.DraftNodeChangeUpdate.IDraftNodeChangeSubscriber;
import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodePublisher;
import raf.draft.dsw.SelectedNodeUpdate.ITreeSelectedNodeSubscriber;
import raf.draft.dsw.actions.edit.modelEdit.EditButtonClick;
import raf.draft.dsw.errorhandler.view.ConsoleLogger;
import raf.draft.dsw.errorhandler.view.FileLogger;
import raf.draft.dsw.errorhandler.controller.LoggerFactory;
import raf.draft.dsw.errorhandler.model.MessageGenerator;
import raf.draft.dsw.jtree.DraftTree;
import raf.draft.dsw.jtree.controller.DraftTreeImplementation;
import raf.draft.dsw.view.MainFrame;

public class ApplicationFramework {
    //buduca polja za model celog projekta
    private MainFrame mainFrame;
    private MessageGenerator messageGenerator;
    private ConsoleLogger consoleLogger;
    private FileLogger fileLogger;

    public ApplicationFramework(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        IDaftNodeChangePublisher publisher = mainFrame.getActionManager().getEditAction().getEditWindow().getEditButtonClick();
        IDraftNodeChangeSubscriber sub1 = mainFrame.getTabs().getDraftTabs();
        IDraftNodeChangeSubscriber sub2 = (DraftTreeImplementation) mainFrame.getDraftTree();
        publisher.addSubscriber(sub1);
        publisher.addSubscriber(sub2);

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
