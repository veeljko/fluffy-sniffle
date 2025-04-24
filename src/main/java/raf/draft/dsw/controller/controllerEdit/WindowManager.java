package raf.draft.dsw.controller.controllerEdit;

import raf.draft.dsw.controller.modelEdit.EditWindow;

public class WindowManager {
    private static WindowManager instance = null;
    public EditWindow editWindow;

    public WindowManager() {
        editWindow = new EditWindow();
    }

    public static WindowManager getInstance() {
        if (instance == null) {
            instance = new WindowManager();
        }
        return instance;
    }

    public EditWindow getEditWindow() {
        return editWindow;
    }
}
