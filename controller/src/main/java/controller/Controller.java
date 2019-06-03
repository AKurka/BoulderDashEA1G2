package controller;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.model.Direction;
import contract.model.IComportment;
import contract.model.IElement;
import contract.model.IModel;
import contract.view.IView;

public class Controller implements IOrderPerformer {

    private IModel model;

    private IView view;

    private IElement boulder;

    private IElement monster;

    private IElement gravity;

    public Controller(IModel model, IView view){
        this.model = model;
        this.view = view;
    }

    public Controller(){}

    public void play() throws Exception{
        view.start(this.model, this);
        this.boulder = this.model.getBoulder();

        if(!this.model.getMonster().isEmpty()){
            this.monster = this.model.getMonster().get(1);
        }

        this.gravity = this.model.getGravity().get(1);
        this.gameLoop();
    }

    private void gameLoop() throws Exception{
        while(this.boulder != null){
            if(!this.model.getMonster().isEmpty()){
                this.monster.getComportment().moveAll();
            }
            this.gravity.getComportment().gravit1();
            Thread.sleep(100);
        }

    }



    @Override
    public void orderPerformer(Order order) throws Exception {
        switch (order){
            case UP:
                this.boulder.setDirection(Direction.UP);
                break;
            case RIGHT:
                this.boulder.setDirection(Direction.RIGHT);
                break;
            case DOWN:
                this.boulder.setDirection(Direction.DOWN);
                break;
            case LEFT:
                this.boulder.setDirection(Direction.LEFT);
                break;
        }
        this.boulder.getComportment().move();
    }

    public void End(int diamond) throws Exception{
        if (diamond < 10)
            throw new Exception("You need more diamonds");
        else
            this.model.setGame(false);
    }
}
