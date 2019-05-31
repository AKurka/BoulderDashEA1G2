package view;

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

        if(left.getClass() == view.Background.class || left.getClass() == view.Dirt.class){
            this.element.getComportment().moveLeft();
        }
        else if(left.getClass() == view.Rock.class){
            IElement left2 = element.getMap().getElements()[element.getPosition().getX()-2][element.getPosition().getY()];;
            if(left2.getClass() == view.Background.class){
                left.getComportment().moveLeft();
                this.element.getComportment().moveLeft();
            }
        }
        else if (left.getClass() == view.Diamond.class){
            this.element.getMap().getModel().getDiamond(left);
            this.element.getMap().destroyElement(left);
            this.element.getComportment().moveLeft();

        }

        else if (left.getClass() == view.Exit.class){
            System.exit(0);
        }
    }

    private void goRight() throws Exception{
        IElement right = element.getMap().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];

        if(right.getClass() == view.Background.class || right.getClass() == view.Dirt.class){
            this.element.getComportment().moveRight();
        }
        else if(right.getClass() == view.Rock.class){
            IElement right2 = element.getMap().getElements()[element.getPosition().getX()+2][element.getPosition().getY()];;
            if(right2.getClass() == view.Background.class){
                right.getComportment().moveRight();
                this.element.getComportment().moveRight();
            }
        }
        else if (right.getClass() == view.Diamond.class){
            this.element.getMap().getModel().getDiamond(right);
            this.element.getMap().destroyElement(right);
            this.element.getComportment().moveRight();

        }
        else if (right.getClass() == view.Exit.class){
            System.exit(0);
        }
    }

    private void goUp() throws Exception{
        IElement up = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()-1];

        if(up.getClass() == view.Background.class || up.getClass() == view.Dirt.class){
            this.element.getComportment().moveUp();
        }
        else if(up.getClass() == view.Rock.class){

        }
        else if (up.getClass() == view.Diamond.class){
            this.element.getMap().getModel().getDiamond(up);
            this.element.getMap().destroyElement(up);
            this.element.getComportment().moveUp();

        }
        else if (up.getClass() == view.Exit.class){
            System.exit(0);
        }
    }

    private void goDown() throws Exception{
        IElement down = element.getMap().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];

        if(down.getClass() == view.Background.class || down.getClass() == view.Dirt.class){
            this.element.getComportment().moveDown();
        }
        else if(down.getClass() == view.Rock.class){

        }
        else if (down.getClass() == view.Diamond.class){
            this.element.getMap().getModel().getDiamond(down);
            this.element.getMap().destroyElement(down);
            this.element.getComportment().moveDown();

        }
        else if (down.getClass() == view.Exit.class){
            System.exit(0);
        }
    }

}
