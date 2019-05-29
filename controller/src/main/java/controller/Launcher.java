package controller;

import contract.LevelObserve;
import model.DBQuery;
import model.MapBuilder;
import model.Translation;
import view.Frame;
import view.Menu;

import java.io.File;

public class Launcher implements LevelObserve {
    private static Menu menu;
    private static MapBuilder builder = null;
    static File music = null;
    private final static int SET_SIZE = 16;

    public Launcher() {
        menu = new Menu();
        menu.getObservators().add(this);
    }

    @Override
    public void selectedLevel(int level){
        (new Thread(new Runnable() {
            @Override
            public void run() {
                DBQuery dbQuery = new DBQuery(level);
                dbQuery.Queries();
                Translation translation;


                try {

                    translation = new Translation(dbQuery.getTab()); //Test commit
                    builder = new MapBuilder(translation);
                    builder.mapCreation(SET_SIZE);

                    BKeyListener bkeyListener = new BKeyListener();
                    Frame frame = new Frame(builder, bkeyListener, dbQuery.getFinalDiamonds(), level); // Ceci est un commentaire
                    Controller controller = new Controller(
                            builder.getCharacter(translation.getBoulderX(), translation.getBoulderY()), frame.getPanel(), SET_SIZE, builder, frame, dbQuery.getFinalDiamonds());

                    bkeyListener.addObserver(controller);
                    bkeyListener.setController(controller);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        })).start();
    }

}
