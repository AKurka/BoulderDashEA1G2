package controller;

import contract.LevelObserve;
import model.DBQuery;
import model.MapBuilder;
import model.Translation;
import view.Menu;

import java.io.File;
import java.io.IOException;

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

                try{
                    translation = new Translation(dbQuery.getTab());
                    builder = new MapBuilder(translation);
                    builder.mapCreation(SET_SIZE);

                    BKeyListener bKeyListener = new BKeyListener();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        })).start();
    }

}
