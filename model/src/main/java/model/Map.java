package model;

import contract.model.IElement;
import contract.model.Position;
import model.DAO.Level;

import java.util.concurrent.CopyOnWriteArrayList;

public class Map {

    /** The height of the map */
    static int HEIGHT = 30;

    /** The width of the map */
    static int WIDTH = 50;

    /** The tab of the different elements */
    private IElement[][] elements;

    /** The model that contain the map */
    private Model model;

    /** The list of the monster */
    private CopyOnWriteArrayList<IElement> monster;

    /** The list of the gravitable element */
    private CopyOnWriteArrayList<IElement> gravity;

    /** The Boulder */
    private IElement boulder;


    /**
     * Instantiates a new map
     * @param model
     * 		The model
     * @throws Exception
     *		map exception
     */
    public Map(Model model) throws Exception{
        this.elements = new IElement[Map.WIDTH][Map.HEIGHT];
        this.model = model;
        this.monster = new CopyOnWriteArrayList<IElement>();
        this.gravity = new CopyOnWriteArrayList<IElement>();
        this.buildMap();
    }

    /**
     * Builds the map
     * @throws Exception
     * 		position Exception
     */

    private void buildMap() throws  Exception{

        String currentLevel = loadLevel("1");
        int i = 0;
        for(int y = 0 ;y<Map.HEIGHT; y++){
            for (int x = 0; x<Map.WIDTH;x++){

                char element = currentLevel.charAt(i);

                i++;

                switch(element){
                    case '0':
                        IElement gravit = new Rock(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.gravity.add(gravit);
                        this.setElement(x,y,gravit);
                        break;
                    case '/':
                        this.setElement(x,y,new Wall(new Position(x,y,Map.WIDTH,Map.HEIGHT),this));
                        break;
                    case '@':
                        gravit = new Diamond(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.gravity.add(gravit);
                        this.setElement(x,y,gravit);
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

                        IElement monster = new Monster(new Position(x,y,Map.WIDTH,Map.HEIGHT),this);
                        this.monster.add(monster);
                        this.setElement(x,y,monster);
                        break;
                }
            }
        }
    }

    /**
     * Load the level, get it from the database
     * @param levelToLoad
     * 		The level to load
     * @return a String that contain the level template
     */
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

    /**
     * Get a tab that contain all the map elements
     * @return a tab of Elements
     */

    public IElement[][] getElements(){
        return elements;
    }

    /**
     * Add a element in the map
     * @param x
     * 		The x column where add the element
     * @param y
     * 		The y column where add the element
     * @param add
     * 		The element to add
     */

    public void setElement(int x, int y, IElement add){
        this.elements[x][y] = add;
    }

    /**
     * Get the model of the map
     * @return the model of the map
     */
    public Model getModel(){
        return model;
    }

    /**
     * Return the monsters from the tab
      * @return
     */
    public CopyOnWriteArrayList<IElement> getMonster(){
        return monster;
    }

    /**
     * Remove the element from the tab
     * @param elements
     * @throws Exception
     */
    public void destroyElement(IElement elements) throws Exception{

        this.elements[elements.getPosition().getX()][elements.getPosition().getY()] = new Background(new Position(elements.getPosition().getX(),elements.getPosition().getY(),Map.WIDTH,Map.HEIGHT), this);

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

    /**
     * Method for add an monster
     * @param monster
     * 		Name of monster to add
     */
    public void addMonster(IElement monster){
        this.monster.add(monster);
    }

    /**
     * Use for copy and write on a array list
     * @return gravity
     */
    public CopyOnWriteArrayList<IElement>getGravity(){
        return gravity;
    }

    /**
     * try to synchronize thread
     * @param gravity
     * 		element affect by  gravity
     */
    public void addGravity(IElement gravity){
        this.gravity.add(gravity);
    }

    /**
     * Method for get the boulder
     * @return boulder
     */
    public IElement getBoulder(){
        return boulder;
    }
}
