package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;

import java.nio.file.Path;

public class Project extends DraftNodeComposite {

    public Project(String nodeNaziv, String autor) {
        super(nodeNaziv, autor, null);
    }

    public Project(String nodeNaziv, DraftNode parent, String autor) {
        super(nodeNaziv, autor, parent);
    }
}
