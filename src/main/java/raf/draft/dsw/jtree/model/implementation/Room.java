package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;

import java.nio.file.Path;

public class Room extends DraftNode {

    public Room(String nodeNaziv, String autor) {
        super(nodeNaziv, autor, null);
    }

    public Room(String nodeNaziv, DraftNode parent, String autor) {
        super(nodeNaziv, autor, parent);
    }
}
