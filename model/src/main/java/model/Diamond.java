package model;

import contract.model.Position;

public class Diamond extends Element implements IGet, IKill {

    private final static String STRING = "diamond";

    public Diamond(Position position, Mine mine){
        super(position, STRING, mine);
        comportment = new Gravity(this);
    }

    @Override
    public void get(Boulder boulder) throws Exception{
        boulder.setDiamonds(boulder.getDiamonds()+1);
        this.getMine().destroyElement(this);
    }

    @Override
    public void kill(Element element){
        element = null;
    }
}
