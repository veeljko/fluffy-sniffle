package raf.draft.dsw;

import com.sun.tools.javac.Main;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.errorhandler.Greska;
import raf.draft.dsw.gui.swing.MainFrame;

import java.util.Date;

public class AppCore {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
    }
}