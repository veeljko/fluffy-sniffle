package raf.draft.dsw.errorhandler;

import java.util.ArrayList;
import java.util.List;

public abstract class IPublisher {
    private List<ISubscriber> subscriberList = new ArrayList<>();
    public void addSubscriber(ISubscriber subscriber){
        subscriberList.add(subscriber);
    }
    public void removeSubscriber(ISubscriber subscriber){
        subscriberList.remove(subscriber);
    }
    public abstract void notifySubscribers();

    public List<ISubscriber> getSubscriberList() {
        return subscriberList;
    }
}
