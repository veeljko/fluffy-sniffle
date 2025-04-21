package raf.draft.dsw.jtree;

import raf.draft.dsw.errorhandler.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class ITreeSelectedNodePublisher {
    private List<ITreeSelectedNodeSubscriber> subscriberList = new ArrayList<>();
    public void addSubscriber(ITreeSelectedNodeSubscriber subscriber){
        subscriberList.add(subscriber);
    }
    public void removeSubscriber(ITreeSelectedNodeSubscriber subscriber){
        subscriberList.remove(subscriber);
    }
    public abstract void notifySubscribers();

    public List<ITreeSelectedNodeSubscriber> getSubscriberList() {
        return subscriberList;
    }
}
