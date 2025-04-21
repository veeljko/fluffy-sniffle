package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;

import java.nio.file.Path;

public class ProjectExplorer extends DraftNodeComposite {
    private String ime;
    private String autor;
    private Path path;

    public ProjectExplorer(String nodeNaziv, String ime, String autor, Path path) {
        super(nodeNaziv);
        this.ime = ime;
        this.autor = ime;
        this.path = null;
    }

    public ProjectExplorer(String nodeNaziv, DraftNode parent, String ime, String autor, Path path) {
        super(nodeNaziv, parent);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
    }

    public ProjectExplorer(String nodeNaziv, String ime, String autor) {
        super(nodeNaziv);
        this.ime = ime;
        this.autor = ime;
    }

    @Override
    public String getIme() {
        return ime;
    }

    @Override
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
