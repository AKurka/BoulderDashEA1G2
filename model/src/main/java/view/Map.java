package view;

import contract.model.IElement;
import contract.model.Position;
import view.DAO.Level;

import java.util.concurrent.CopyOnWriteArrayList;

public class Map {

    static int HEIGHT = 30;

    static int WIDTH = 50;

    private IElement[][] elements;

    private Model model;

    private CopyOnWriteArrayList<IElement> monster;

    private CopyOnWriteArrayList<IElement> gravity;

    private IElement boulder;


    public Map(Model model){
        this.elements = new IElement[Map.WIDTH][Map.HEIGHT];
        this.model = model;
        this.monster = new CopyOnWriteArrayList<IElement>();
        this.gravity = new CopyOnWriteArrayList<IElement>();
        this.buildMap();
    }

    private void buildMap(){

        String currentLevel = loadLevel("level1");
        int i = 0;
        for (int y = 0; y<Map.HEIGHT; y++){
            for(int x = 0; x<Map.WIDTH; x++){
                char element = currentLevel.charAt(i);

                i++;

                switch (element){
                    case 'o' :
                        IElement gravity = new Rock(new Position(x,y, Map.WIDTH, Map.HEIGHT), this);
                        this.gravity.add(gravity);
                        this.setElement(x,y, gravity);
                        break;
                    case 'x':
                        this.setElement(x,y,new Wall(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case 'v':
                        gravity = new Diamond(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.gravity.add(gravity);
                        this.setElement(x,y,gravity);
                        break;
                    case '.':
                        this.setElement(x,y,new Dirt(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case 'u':
                        this.setElement(x,y,Exit.getInstance(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case 'y':
                        this.boulder = Boulder.getInstance(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.setElement(x,y,this.boulder);
                        break;
                    case ' ':
                        this.setElement(x,y,new Background(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case 'n':
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
        return elements;
    }

    public void setElement(int x, int y, IElement add){
        this.elements[x][y] = add;
    }

    public Model getModel(){
        return model;
    }

    public CopyOnWriteArrayList<IElement> getMonster(){
        return monster;
    }

    public void destroyElement(IElement element) throws Exception{

        this.elements[element.getPosition().getX()][element.getPosition().getY()] = new Background(new Position(element.getPosition().getX(),element.getPosition().getY(),Map.WIDTH,Map.HEIGHT), this);

        for (IElement e : this.monster) {
            if (e.equals(element)) {
                this.monster.remove(e);
            }
        }

        for (IElement e : this.gravity) {
            if (e.equals(element)) {
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
