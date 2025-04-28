package raf.draft.dsw;

import raf.draft.dsw.JTabbePane.CoursePanel;
import raf.draft.dsw.JTabbePane.TabbedPane;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.view.MainFrame;

import java.nio.channels.SelectableChannel;

public class AppCore {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        ApplicationFramework appCore = ApplicationFramework.getInstance();
    }
}