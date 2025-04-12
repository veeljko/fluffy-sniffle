package raf.draft.dsw.model;

import java.nio.file.Path;

public class Room extends DraftNode {
    private String ime;
    private String autor;
    private Path path;

    public Room(String nodeNaziv, String ime, String autor, Path path) {
        super(nodeNaziv);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
    }

    public Room(String nodeNaziv, DraftNode parent, String ime, String autor, Path path) {
        super(nodeNaziv, parent);
        this.ime = ime;
        this.autor = autor;
    }
}
