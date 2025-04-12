package raf.draft.dsw.model;

public abstract class DraftNode {
    private String nodeIme;
    private DraftNode parent;

    public DraftNode(String ime) {
        this.nodeIme = ime;
    }

    public DraftNode(String ime, DraftNode parent) {
        this.nodeIme = ime;
        this.parent = parent;
    }

    public String getIme() {
        return nodeIme;
    }

    public void setIme(String ime) {
        this.nodeIme = ime;
    }

    public DraftNode getParent() {
        return parent;
    }

    public void setParent(DraftNode parent) {
        this.parent = parent;
    }
}
