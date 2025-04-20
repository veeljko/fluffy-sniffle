package raf.draft.dsw.errorhandler;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void update(String message) {
        log(message);
    }
}
