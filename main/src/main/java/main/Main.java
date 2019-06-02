package main;

import controller.Controller;
import model.Model;
import view.View;

public class Main {

    public static void main(final String[] args) throws Exception {

        final Controller controller = new Controller(new Model(), new View());

        try {
            controller.play();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }
}
