package model;

import contract.model.Position;

public class Exit extends Element {

    private final static String STRING = "exit";

    private static Exit EXIT;

    private Exit(Position position, Mine mine){
        super(position, STRING, mine);
        comportment = new Fix(this);
    }

    public static Exit getInstance(Position position, Mine mine){
        if(EXIT == null){
            EXIT = new Exit(position, mine);
        }
        return EXIT;
    }
}
