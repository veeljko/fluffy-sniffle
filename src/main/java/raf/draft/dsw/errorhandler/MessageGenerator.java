package raf.draft.dsw.errorhandler;

import java.security.Timestamp;
import java.util.Date;

public class MessageGenerator extends IPublisher{
    private String sadrzaj;
    private Greska greska;
    private Date timestamp;

    public MessageGenerator(){

    }

    public MessageGenerator(String sadrzaj, Greska greska, Date timestamp) {
        this.sadrzaj = sadrzaj;
        this.greska = greska;
        this.timestamp = timestamp;
    }

    @Override
    public void notifySubscribers() {
        System.out.println(getSubscriberList().size());
        for (ISubscriber log : getSubscriberList()){
            log.update(toString());
        }
    }

    @Override
    public String toString(){
        return  "[" + greska + "] [" + timestamp + "] " + sadrzaj + "\n";
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Greska getGreska() {
        return greska;
    }

    public void setGreska(Greska greska) {
        this.greska = greska;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
