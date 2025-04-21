package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;

import java.nio.file.Path;

public class Project extends DraftNodeComposite {
    private String ime;
    private String autor;
    private Path path;

    public Project(String nodeNaziv, String ime, String autor, Path path) {
        super(nodeNaziv);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
    }

    public Project(String nodeNaziv, DraftNode parent, String ime, String autor, Path path) {
        super(nodeNaziv, parent);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
    }

    public Project(String nodeNaziv, DraftNode parent, String ime, String autor) {
        super(nodeNaziv, parent);
        this.ime = ime;
        this.autor = autor;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
