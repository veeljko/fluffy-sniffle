package raf.draft.dsw.jtree.model.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class DraftNodeComposite extends DraftNode {

    private List<DraftNode> children = new ArrayList<>();

    public DraftNodeComposite(String ime) {
        super(ime);
    }

    public DraftNodeComposite(String ime, DraftNode parent) {
        super(ime, parent);
    }

    public void addChild(DraftNode child) {
        children.add(child);
    }

    public void removeChild(DraftNode child) {
        children.remove(child);
    }

    public List<DraftNode> getChildren() {
        return children;
    }
}
