package controller;

import contract.controller.IOrderPerformer;
import contract.controller.Order;
import contract.model.Direction;
import contract.model.IComportment;
import contract.model.IElement;
import contract.model.IModel;
import contract.view.IView;

/**
 * <h1>The class BoulderDashPerformer</h1>
 *
 * @author Groupe2
 */

public class Controller implements IOrderPerformer {

    /** The model */
    private IModel model;

    /** The view */
    private IView view;

    /** The boulder */
    private IElement boulder;

    /** The monster */
    private IElement monster;

    /** The gravity */
    private IElement gravity;

    /**
     * Create constructor
     * @param model
     *      Use for set the actual model
     * @param view
     *      Use for set the actual view
     */
    public Controller(IModel model, IView view){
        this.model = model;
        this.view = view;
    }

    /**
     * Principal method use for get back initial position of some element
     * @throws Exception
     *      Game loop exception
     */
    public void play() throws Exception{
        view.start(this.model, this);
        this.boulder = this.model.getBoulder();

        if(!this.model.getMonster().isEmpty()){
            this.monster = this.model.getMonster().get(1);
        }

        this.gravity = this.model.getGravity().get(1);
        this.gameLoop();
    }

    /**
     * create a loop and a thread for enemy and gravity
     * @throws Exception
     *      thread exception
     */
    private void gameLoop() throws Exception{
        while(this.boulder != null){
            if(!this.model.getMonster().isEmpty()){
                this.monster.getComportment().moveAll();
            }
            this.gravity.getComportment().gravit1();
            Thread.sleep(100);
        }

    }



    /**
     * @throws Exception
     * 		Thread Exception
     * @see IOrderPerformer
     */
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

    /**
     * Method use when we want end the game
     * @param diamond
     * 		the number of diamond collected
     * @throws Exception
     * 		Exception not enough diamond
     */
    public void End(int diamond) throws Exception{
        if (diamond < 10)
            throw new Exception("You need more diamonds");
        else
            this.model.setGame(false);
    }
}
