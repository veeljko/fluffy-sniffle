package raf.draft.dsw.JTabbePane.model;

import raf.draft.dsw.jtree.model.DraftTreeItem;
import raf.draft.dsw.jtree.model.implementation.Building;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DraftPanel extends JPanel {
    private String ime;
    private JButton addCourse, clear;
    private DraftTreeItem parent;
    private Color color;

    public DraftPanel(DraftTreeItem parent, String ime) {
        this.ime = ime;
        this.parent = parent;
        if (parent == null) this.color = Color.BLACK;
        else this.color = ((Building) parent.getDraftNode()).getColor();
        initialize();
    }

    public void initialize() {
        addCourse = new JButton("Add Course");
        clear = new JButton("Clear");

        setLayout(new FlowLayout());
        add(addCourse);
        add(clear);
    }

    public String getIme() {
        return ime;
    }

    public DraftTreeItem getDraftParent() {
        return parent;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DraftPanel that = (DraftPanel) o;
        return ime.equals(that.ime) && parent.equals(that.parent) && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, parent, color);
    }

}
