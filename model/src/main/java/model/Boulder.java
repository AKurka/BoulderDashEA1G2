package model;

import contract.model.Direction;
import contract.model.IExplosion;
import contract.model.Position;

public class Boulder extends Element implements IExplosion {

    private static String SPRITE = "up";
    private static Boulder boulder;
    private int timeOut;
    private int diamonds;
    private Direction direction;

    private Boulder(Position position, Mine mine){
        super(position, SPRITE, mine);
        comportment = new Control(this);
    }

    public void startTimeOut(){

    }

    static public Boulder getInstance(Position position, Mine mine){
        if(boulder == null){
            boulder = new Boulder(position, mine);
        }
        return boulder;
    }

    static public Boulder getInstance(){
        return boulder;
    }

    public static String getSPRITE(){
        return SPRITE;
    }

    public void setDiamonds(int diamonds){
        this.diamonds = diamonds;
    }

    public int getTimeOut(){
        return timeOut;
    }

    public void setTimeOut(int timeOut){
        this.timeOut = timeOut;
    }

    public Direction getDirection(){
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    @Override
    synchronized public void explosion() throws Exception{
        this.getMine().destroyElement(Boulder.boulder);
        this.getMine().getModel().setGame(false);
        Boulder.boulder = null;
    }
}
