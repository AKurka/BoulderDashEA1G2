package model;

import contract.model.Direction;
import contract.model.IElement;

public class Controlled extends Comportment{


    public Controlled(Element element) {
        super(element);
    }


    @Override
    public void move() throws Exception{
        Direction direction = this.element.getDirection();

        switch (direction){
            case LEFT:
                this.goLeft();
                break;
            case RIGHT:
                this.goRight();
                break;
            case UP:
                this.goUp();
                break;
            case DOWN:
                this.goDown();
                break;
        }
    }

    private void goLeft() throws Exception{
        IElement left = element.getMap().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];

        if(left.getClass() == model.Background.class || left.getClass() == model.Dirt.class){
            this.element.getComportment().moveLeft();
        }
        else if(left.getClass() == model.Rock.class){
            IElement left2 = element.getMap().getElements()[element.getPosition().getX()-2][element.getPosition().getY()];;
            if(left2.getClass() == model.Background.class){
                left.getComportment().moveLeft();
                this.element.getComportment().moveLeft();
            }
        }
        else if (left.getClass() == model.Diamond.class){
            this.element.getMap().getModel().getDiamond(left);
            this.element.getMap().destroyElement(left);
            this.element.getComportment().moveLeft();

        }

        else if (left.getClass() == model.Exit.class){
            System.exit(0);
        }
    }

    private void goRight() throws Exception{
        IElement right = element.getMap().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];

        if(right.getClass() == model.Background.class || right.getClass() == model.Dirt.class){
            this.element.getComportment().moveRight();
        }
        else if(right.getClass() == model.Rock.class){
            IElement right2 = element.getMap().getElements()[element.getPosition().getX()+2][element.getPosition().getY()];;
            if(right2.getClass() == model.Background.class){
                right.getComportment().moveRight();
                this.element.getComportment().moveRight();
            }
        }
        else if (right.getClass() == model.Diamond.class){
            this.element.getMap().getModel().getDiamond(right);
            this.element.getMap().destroyElement(right);
            this.element.getComportment().moveRight();

        }
        else if (right.getClass() == model.Exit.class){
            System.exit(0);
        }
    }

    private void goUp() throws Exception{
        IElement up = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()-1];

        if(up.getClass() == model.Background.class || up.getClass() == model.Dirt.class){
            this.element.getComportment().moveUp();
        }
        else if(up.getClass() == model.Rock.class){

        }
        else if (up.getClass() == model.Diamond.class){
            this.element.getMap().getModel().getDiamond(up);
            this.element.getMap().destroyElement(up);
            this.element.getComportment().moveUp();

        }
        else if (up.getClass() == model.Exit.class){
            System.exit(0);
        }
    }

    private void goDown() throws Exception{
        IElement down = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

        if(down.getClass() == model.Background.class || down.getClass() == model.Dirt.class){
            this.element.getComportment().moveDown();
        }
        else if(down.getClass() == model.Rock.class){

        }
        else if (down.getClass() == model.Diamond.class){
            this.element.getMap().getModel().getDiamond(down);
            this.element.getMap().destroyElement(down);
            this.element.getComportment().moveDown();

        }
        else if (down.getClass() == model.Exit.class){
            System.exit(0);
        }
    }

}
