package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;

import java.awt.*;
import java.nio.file.Path;
import java.util.Random;

public class Building extends DraftNodeComposite {
    private Color color;

    public Building(String nodeNaziv, String autor) {
        super(nodeNaziv, autor, null);
        setColor();
    }

    public Building(String nodeNaziv, DraftNode parent, String autor) {
        super(nodeNaziv, autor, parent);
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

}
