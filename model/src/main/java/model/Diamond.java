package model;

import contract.model.Position;

public class Diamond extends Element implements Interaction{

    private final static String IMAGE = "diamond";

    public Diamond(Position position, Map map){
        super(position, IMAGE, map);
        comportment = new Gravity(this);
    }

    @Override
    public void get(Boulder boulder) throws Exception{
        boulder.setDiamond(boulder.getDiamond()+1);
        this.getMap().destroyElement(this);
    }


    @Override
    public void kill(Element element) {
        element = null;
    }

}