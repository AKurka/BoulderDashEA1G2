package model;

import contract.model.IElement;
import contract.model.Position;
import model.DAO.Level;

import java.util.concurrent.CopyOnWriteArrayList;

public class Map {

    static int HEIGHT = 30;

    static int WIDTH = 50;

    private IElement[][] element;

    private Model model;

    private CopyOnWriteArrayList<IElement> monster;

    private CopyOnWriteArrayList<IElement> gravity;

    private IElement boulder;


    public Map(Model model){
        this.element = new IElement[Map.WIDTH][Map.HEIGHT];
        this.model = model;
        this.monster = new CopyOnWriteArrayList<IElement>();
        this.gravity = new CopyOnWriteArrayList<IElement>();
        this.buildMap();
    }

    private void buildMap(){

        String currentLevel = loadLevel("1");
        int i = 0;
        for (int y = 0; y<Map.HEIGHT; y++){
            for(int x = 0; x<Map.WIDTH; x++){
                char element = currentLevel.charAt(i);

                i++;

                switch (element){
                    case '0' :
                        IElement gravity = new Rock(new Position(x,y, Map.WIDTH, Map.HEIGHT), this);
                        this.gravity.add(gravity);
                        this.setElement(x,y, gravity);
                        break;
                    case '/':
                        this.setElement(x,y,new Wall(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case '@':
                        gravity = new Diamond(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.gravity.add(gravity);
                        this.setElement(x,y,gravity);
                        break;
                    case '*':
                        this.setElement(x,y,new Dirt(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case 'E':
                        this.setElement(x,y,Exit.getInstance(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case '#':
                        this.boulder = Boulder.getInstance(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.setElement(x,y,this.boulder);
                        break;
                    case ' ':
                        this.setElement(x,y,new Background(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case 'K':
                        IElement enemy = new Monster(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.monster.add(enemy);
                        this.setElement(x,y,enemy);
                        break;
                }
            }
        }
    }

    private String loadLevel(String levelToLoad){

        String result ="";

        try {
            result = Level.getLevel(levelToLoad);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public IElement[][] getElements(){
        return element;
    }

    public void setElement(int x, int y, IElement add){
        this.element[x][y] = add;
    }

    public Model getModel(){
        return model;
    }

    public CopyOnWriteArrayList<IElement> getMonster(){
        return monster;
    }

    public void destroyElement(IElement elements) throws Exception{

        this.element[elements.getPosition().getX()][elements.getPosition().getY()] = new Background(new Position(elements.getPosition().getX(),elements.getPosition().getY(),Map.WIDTH,Map.HEIGHT), this);

        for (IElement e : this.monster) {
            if (e.equals(elements)) {
                this.monster.remove(e);
            }
        }

        for (IElement e : this.gravity) {
            if (e.equals(elements)) {
                this.gravity.remove(e);
            }
        }

        if(this.boulder.equals(elements)){
            this.boulder = null;
        }

    }

    public void addMonster(IElement monster){
        this.monster.add(monster);
    }

    public CopyOnWriteArrayList<IElement>getGravity(){
        return gravity;
    }

    public void addGravity(IElement gravity){
        this.gravity.add(gravity);
    }

    public IElement getBoulder(){
        return boulder;
    }
}
