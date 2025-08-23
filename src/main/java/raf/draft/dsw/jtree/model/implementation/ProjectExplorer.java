package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;

public class ProjectExplorer extends DraftNode {

    public ProjectExplorer(String nodeNaziv, String autor) {
        super(nodeNaziv, autor, null);
    }

    public ProjectExplorer(String nodeNaziv, DraftNode parent, String autor) {
        super(nodeNaziv, autor, parent);
    }

}
