package raf.draft.dsw.jtree;

import raf.draft.dsw.jtree.model.composite.DraftNode;
import raf.draft.dsw.jtree.model.implementation.ProjectExplorer;

public class DraftExplorerImplementation implements DraftRepository{
    private ProjectExplorer projectExplorer;

    public DraftExplorerImplementation(ProjectExplorer projectExplorer) {
        this.projectExplorer = projectExplorer;
    }

    public DraftNode getRoot(){
        return getRootI((DraftNode) projectExplorer);
    }
}
