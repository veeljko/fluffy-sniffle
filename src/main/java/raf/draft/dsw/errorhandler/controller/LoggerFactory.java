package raf.draft.dsw.errorhandler.controller;

import raf.draft.dsw.errorhandler.Logger;
import raf.draft.dsw.errorhandler.view.ConsoleLogger;
import raf.draft.dsw.errorhandler.view.FileLogger;

public class LoggerFactory {
    public Logger createLogger(String type){
        if (type.equals("consolelogger")) return new ConsoleLogger();
        else if (type.equals("filelogger")) return new FileLogger();
        return null;
    }
}
