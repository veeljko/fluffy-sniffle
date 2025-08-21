package raf.draft.dsw.jtree.model.draftnodefactory;

import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.implementation.Building;
import raf.draft.dsw.jtree.model.implementation.Project;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;
import raf.draft.dsw.jtree.model.implementation.Room;

public class DraftNodeChildFactory extends DraftNodeFactory{

    public DraftNodeChildFactory(DraftTreeItem parent) {
        super(parent);
    }

    @Override
    public DraftTreeItem createDraftNode() {
        DraftNode parent = super.getParent().getDraftNode();
        DraftNode child = null;
        if (parent instanceof ProjectExplorer)
            child = new Project("Project" + getCnt(), parent, "autor");
        else if (parent instanceof Project)
            child = new Building("Building" + getCnt(), parent, "autor");
        else if (parent instanceof Building)
            child = new Room("Room" + getCnt(), parent, "autor");
        else return null;

        DraftTreeItem childWrapper = new DraftTreeItem(child);
        super.getParent().add(childWrapper);

        return childWrapper;
    }
}
