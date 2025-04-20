package raf.draft.dsw.errorhandler;

public class LoggerFactory {
    public Logger createLogger(String type){
        if (type.equals("consolelogger")) return new ConsoleLogger();
        else if (type.equals("filelogger")) return new FileLogger();
        return null;
    }
}
