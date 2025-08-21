package raf.draft.dsw.jtree.model.composite;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class DraftNodeComposite extends DraftNode {

    public DraftNodeComposite(String nodeIme, String autor, DraftNode parent) {
        super(nodeIme, autor, parent);
    }
}
