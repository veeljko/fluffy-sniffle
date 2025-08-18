package raf.draft.dsw.jtree.model.composite;

import java.nio.file.Path;
import java.util.Objects;

public abstract class DraftNode {
    private String nodeIme;
    private String autor;
    private DraftNode parent;


    public DraftNode(String ime) {
        this.nodeIme = ime;
    }

    public DraftNode(String nodeIme, String autor, DraftNode parent) {
        this.nodeIme = nodeIme;
        this.autor = autor;
        this.parent = parent;
    }

    public DraftNode(String ime, DraftNode parent) {
        this.nodeIme = ime;
        this.parent = parent;
    }

    public String getNodeIme() {
        return nodeIme;
    }

    public void setNodeIme(String nodeIme) {
        this.nodeIme = nodeIme;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DraftNode draftNode = (DraftNode) o;
        return Objects.equals(nodeIme, draftNode.nodeIme) && Objects.equals(parent, draftNode.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeIme, parent);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
