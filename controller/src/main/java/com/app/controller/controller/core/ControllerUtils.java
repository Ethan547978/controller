package com.app.controller.controller.core;

import java.util.ArrayList;
import java.util.List;

public class ControllerUtils {

    private List<Controller> mRegistedControllers;

    public final Controller registController(Controller controller) {
        if (mRegistedControllers == null) {
            mRegistedControllers = new ArrayList<>();
        }

        if (controller != null) {
            mRegistedControllers.add(controller);
        }

        return controller;
    }

    public void clearAllControllerListener() {
        if (mRegistedControllers != null) {
            List<Controller> controllers = new ArrayList<>(mRegistedControllers);
            for (Controller controller : controllers) {
                if (controller != null) {
                    controller.clearListener();
                }
            }

            controllers.clear();
            mRegistedControllers.clear();
            mRegistedControllers = null;
        }
    }
}
