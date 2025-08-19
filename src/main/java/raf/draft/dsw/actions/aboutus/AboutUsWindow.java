package raf.draft.dsw.actions.aboutus;

import javax.swing.*;
import java.awt.*;

public class AboutUsWindow extends JFrame {

    public AboutUsWindow() {
        super("About Us");
        initialize();
    }

    private void initialize(){
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Dobrodošli u novi prozor!", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

    }
}
