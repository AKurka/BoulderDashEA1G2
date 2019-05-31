package controller;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.model.Direction;
import contract.model.IBDModel;
import contract.model.IElement;
import contract.view.IView;

public class BDPerform implements IOrderPerformer {
    private IBDModel model;
    private IView View;
    private IElement boulder;
    private IElement enemy;
    private IElement gravity;

    public BDPerform(IBDModel BDModel, IView view){
        model = BDModel;
        View = view;
    }

    public void play() throws Exception{
        View.start(this.model, this);
        this.boulder = this.model.getBoulder();

        if(!this.model.getEnemy().isEmpty()){
            this.enemy = this.model.getEnemy().get(1);
        }

        this.gravity = this.model.getGravity().get(1);
        this.gameLoop();
    }

    private void gameLoop() throws Exception{
        while (this.boulder != null){
            if(!this.model.getEnemy().isEmpty()){
                this.enemy.getComportment().moveAll();
            }
            this.gravity.getComportment().Gravit();
            Thread.sleep(100);
        }
    }

    @Override
    public void OrderPerform(Order order) throws Exception {
        if (order == Order.DOWN){
            this.boulder.setDirection(Direction.DOWN);
        }
        if (order == Order.UP){
            this.boulder.setDirection(Direction.UP);
        }
        if (order == Order.RIGHT){
            this.boulder.setDirection(Direction.RIGHT);
        }
        if (order == Order.LEFT){
            this.boulder.setDirection(Direction.LEFT);
        }
        this.boulder.getBehaviour().move();
    }

    public void EndGame(int diamond) throws Exception{
        if (diamond < 10)
            throw new Exception("Not Enough Diamonds");
        else
            this.model.setGame(false);
    }
}
