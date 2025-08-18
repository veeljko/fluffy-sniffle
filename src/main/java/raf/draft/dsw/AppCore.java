package raf.draft.dsw;
import raf.draft.dsw.JTabbePane.controller.DraftTabs;
import raf.draft.dsw.JTabbePane.model.DraftPanel;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.view.MainFrame;

import java.awt.*;

public class AppCore {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
    }
}