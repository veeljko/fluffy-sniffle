package raf.draft.dsw.JTabbePane.model;

import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DraftPanel extends JPanel {
    private String ime;
    private Color color;

    public DraftPanel(DraftTreeItem parent, String ime) {
        this.ime = ime;
        if (parent == null) this.color = Color.BLACK;
        else this.color = ((Building) parent.getDraftNode()).getColor();
    }

    public DraftPanel(BorderLayout borderLayout) {
        super(borderLayout);
    }

    public String getIme() {
        return ime;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DraftPanel that = (DraftPanel) o;
        return ime.equals(that.ime) && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, color);
    }

}
