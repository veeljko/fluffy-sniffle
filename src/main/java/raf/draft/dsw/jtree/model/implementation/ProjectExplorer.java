package raf.draft.dsw.jtree.model.implementation;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.composite.DraftNodeComposite;

import java.nio.file.Path;

public class ProjectExplorer extends DraftNodeComposite {

    public ProjectExplorer(String nodeNaziv, String autor) {
        super(nodeNaziv, autor, null);
    }

    public ProjectExplorer(String nodeNaziv, DraftNode parent, String autor) {
        super(nodeNaziv, autor, parent);
    }

}
