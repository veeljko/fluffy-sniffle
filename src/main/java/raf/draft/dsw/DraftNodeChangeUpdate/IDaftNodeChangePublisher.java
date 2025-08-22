package raf.draft.dsw.DraftNodeChangeUpdate;

import raf.draft.dsw.jtree.model.DraftTreeItem;

import java.util.ArrayList;
import java.util.List;

public abstract class IDaftNodeChangePublisher {
    private List<IDraftNodeChangeSubscriber> subscribers = new ArrayList<>();

    public void addSubscriber(IDraftNodeChangeSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(IDraftNodeChangeSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public abstract void notifySubscribers(String oldName, String newName, String newAutor);

    public List<IDraftNodeChangeSubscriber> getSubscribers() {
        return subscribers;
    }
}
