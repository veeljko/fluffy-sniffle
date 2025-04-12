package raf.draft.dsw.model;

public class DraftExplorerImplementation implements DraftRepository{
    private ProjectExplorer projectExplorer;

    public DraftExplorerImplementation(ProjectExplorer projectExplorer) {
        this.projectExplorer = projectExplorer;
    }

    public DraftNode getRoot(){
        return getRootI((DraftNode) projectExplorer);
    }
}
