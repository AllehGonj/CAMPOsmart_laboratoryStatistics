package runner;

import controller.Control;

public class Run {

    public static void main(String[] args) {
        Control.getInstance(0);
        Control.getInstance(0).menu();
    }
}
