package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;

import java.awt.*;
import java.nio.file.Path;
import java.util.Random;

public class Building extends DraftNodeComposite {
    private String ime;
    private String autor;
    private Path path;
    private Color color;

    public Building(String nodeNaziv, String ime, String autor, Path path) {
        super(nodeNaziv);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
        setColor();
    }

    public Building(String nodeNaziv, DraftNode parent, String ime, String autor, Path path) {
        super(nodeNaziv, parent);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
        setColor();
    }

    public Building(String nodeNaziv, DraftNode parent, String ime, String autor) {
        super(nodeNaziv, parent);
        this.ime = ime;
        this.autor = autor;
        this.path = path;
        setColor();
    }

    public void setColor(String color) {
        this.color = Color.decode(color);
    }

    public void setColor(){
        Random rand = new Random();
        color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String getIme() {
        return ime;
    }

    @Override
    public void setIme(String ime) {
        this.ime = ime;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
