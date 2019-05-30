package model;

import contract.model.Direction;
import contract.model.IElement;

public class Control extends ComportmentMove {

    public Control(Element element){
        super(element);
    }

    @Override
    synchronized public void move() throws Exception {

        Direction dir = this.element.getDirection();

        switch(dir){
            case LEFT :
                this.goLeft();
                break;
            case RIGHT :
                this.goRight();
                break;
            case UP :
                this.goUp();
                break;
            case DOWN :
                this.goDown();
                break;
        }
    }

    private void goLeft() throws Exception{
        IElement left = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];

        if(left.getClass() == model.Back.class || left.getClass() == model.Dirt.class){
            this.element.getComportment().moveLeft();
        }
        else if(left.getClass() == model.Rock.class){
            IElement left2 = element.getMine().getElements()[element.getPosition().getX()-2][element.getPosition().getY()];;
            if(left2.getClass() == model.Back.class){
                left.getComportment().moveLeft();
                this.element.getComportment().moveLeft();
            }
        }
        else if (left.getClass() == model.Diamond.class){
            this.element.getMine().getModel().getDiamond(left);
            this.element.getMine().destroyElement(left);
            this.element.getComportment().moveLeft();

        }

        else if (left.getClass() == model.Exit.class){
            System.exit(0);
        }
    }

    private void goRight() throws Exception{
        IElement right = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];

        if(right.getClass() == model.Back.class || right.getClass() == model.Dirt.class){
            this.element.getComportment().moveRight();
        }
        else if(right.getClass() == model.Rock.class){
            IElement right2 = element.getMine().getElements()[element.getPosition().getX()+2][element.getPosition().getY()];;
            if(right2.getClass() == model.Back.class){
                right.getComportment().moveRight();
                this.element.getComportment().moveRight();
            }
        }
        else if (right.getClass() == model.Diamond.class){
            this.element.getMine().getModel().getDiamond(right);
            this.element.getMine().destroyElement(right);
            this.element.getComportment().moveRight();

        }

        else if (right.getClass() == model.Exit.class){
            System.exit(0);
        }
    }
}
