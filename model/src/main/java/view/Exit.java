package view;

import contract.model.Position;

public class Exit extends Element{

    private final static String IMAGE = "exit";

    private static Exit exit;

    private Exit(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Static(this);
    }

    public static Exit getInstance(Position position, Map map){
        if(exit == null){
            exit = new Exit(position, map);
        }
        return exit;
    }
}
