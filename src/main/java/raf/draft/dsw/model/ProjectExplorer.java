package raf.draft.dsw.model;

import java.nio.file.Path;

public class ProjectExplorer extends DraftNodeComposite{
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


}
