package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;

public class Project extends DraftNode {

    public Project(String nodeNaziv, String autor) {
        super(nodeNaziv, autor, null);
    }

    public Project(String nodeNaziv, DraftNode parent, String autor) {
        super(nodeNaziv, autor, parent);
    }
}
