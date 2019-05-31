package model;

import contract.model.Direction;
import contract.model.IDestroy;
import contract.model.Position;

public class Boulder extends Element implements IDestroy {

    private static String IMAGE = "up";

    private static Boulder boulder;

    private int timeout;

    private int diamond;

    private Direction direction;

    private Boulder(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Controlled(this);
    }

    static public Boulder getInstance(Position position, Map map){
        if(boulder == null){
            boulder = new Boulder(position, map);
        }
        return boulder;
    }

    static public Boulder getInstance(){
        return boulder;
    }

    public int getDiamond(){
        return diamond;
    }

    public void setDiamond(int diamond){
        this.diamond = diamond;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    @Override
    public void destroy() throws Exception {
        this.getMap().destroyElement(Boulder.boulder);
        this.getMap().getModel().setGame(false);
        Boulder.boulder = null;
    }
}
