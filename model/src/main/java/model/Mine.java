package model;

import contract.model.IElement;
import contract.model.Position;

import java.util.concurrent.CopyOnWriteArrayList;

public class Mine {

    static int HEIGHT = 30;
    static int WIDTH = 50;
    private IElement[][] elements;
    private BDModel model;
    private CopyOnWriteArrayList<IElement> monster;
    private CopyOnWriteArrayList<IElement> gravity;
    private IElement boulder;

    public Mine(BDModel model) throws Exception{
        this.elements = new IElement[Mine.WIDTH][Mine.HEIGHT];
        this.model = model;
        this.monster = new CopyOnWriteArrayList<IElement>();
        this.gravity = new CopyOnWriteArrayList<IElement>();
        this.buildMine();
    }

    private void buildMine() throws Exception{

        String currentLevel = loadLevel("level4");
        int i = 0;
        for(int y = 0; y<Mine.HEIGHT; y++){
            for(int x = 0; x<Mine.WIDTH; x++){

                char element = currentLevel.charAt(i);

                i++;

                switch (element){
                    case '0' :
                        IElement gravit = new Rock(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
                        this.gravity.add(gravit);
                        this.setElement(x,y,gravit);
                        break;
                    case '/' :
                        this.setElement(x,y,new Wall(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
                        break;
                    case '@' :
                        gravit = new Diamond(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
                        this.gravity.add(gravit);
                        this.setElement(x,y,gravit);
                        break;
                    case  '*' :
                        this.setElement(x,y,new Dirt(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
                        break;
                    case ' ' :
                        this.setElement(x,y,Exit.getInstance(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
                        break;
                    case '#' :
                        this.boulder = Boulder.getInstance(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
                        this.setElement(x,y,this.boulder);
                        break;
                    case ' ' :
                        this.setElement(x,y,new Back(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
                        break;
                    case 'K' :
                        IElement monster = new Monster(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
                        this.monster.add(monster);
                        this.setElement(x,y,monster);
                        break;
                }
            }
        }
    }

    private String loadLevel(String levelToLoad){
        String result = "";

        try {
            result = level.getLevel(levelToLoad);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public IElement[][] getElements(){
        return elements;
    }

    public void setElement(int x, int y, IElement add){
        this.elements[x][y] = add;
    }

    public BDModel getModel(){
        return model;
    }

    public CopyOnWriteArrayList<IElement> getMonster{
        return monster;
    }

    public void destroyElement(IElement element) throws Exception{
        this.elements[element.getPosition().getX()][element.getPosition().getY()] = new Back(new Position(element.getPosition().getX(), element.getPosition().getY(), Mine.WIDTH, Mine.HEIGHT), this);

        for (IElement e : this.monster){
            if(e.equals(element)){
                this.monster.remove(e);
            }
        }

        for (IElement e : this.gravity){
            if(e.equals(element)){
                this.gravity.remove(e);
            }
        }

        if(this.boulder.equals(element)){
            this.boulder = null;
        }
    }

    public void addMonster(IElement monster){
        this.monster.add(monster);
    }

    public CopyOnWriteArrayList<IElement> getGravity(){
        return gravity;
    }

    public void addGravity(IElement gravity){
        this.gravity.add(gravity);
    }

    public IElement getBoulder() {
        return boulder;
    }
}
