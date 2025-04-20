package raf.draft.dsw.errorhandler;

import java.util.concurrent.Flow;

public interface Logger extends ISubscriber {
    void log(String message);

    void update(String message);
}
