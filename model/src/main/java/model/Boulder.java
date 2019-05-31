package model;

import contract.model.Direction;
import contract.model.Position;

public class Boulder {

    private static String IMAGE = "up";

    private static Boulder boulder;

    private int timeout;

    private int diamond;

    private Direction direction;

    private Boulder(Position position, Map map){
        super(position, IMAGE, map);

    }
}
