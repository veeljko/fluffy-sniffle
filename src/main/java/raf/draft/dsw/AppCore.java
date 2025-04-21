package raf.draft.dsw;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.view.MainFrame;

public class AppCore {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
    }
}