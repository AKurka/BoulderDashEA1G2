package model;

import contract.ITranslation;
import contract.SpriteType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Translation implements ITranslation {

    private Map<Character, SpriteType> translation = new HashMap<>();
    private int boulderX = 0;
    private int boulderY = 0;
    private SpriteType map[][] = new SpriteType[15][15];



    public Translation(char[][] tab) throws IOException{

        this.translation.put('/', SpriteType.WALL);
        this.translation.put('*', SpriteType.DIRT);
        this.translation.put('X', SpriteType.BACKGROUND);
        this.translation.put('0', SpriteType.ROCK);
        this.translation.put('@', SpriteType.DIAMOND);
        this.translation.put('E', SpriteType.EXIT);
        this.translation.put('K', SpriteType.MONSTER);
        this.translation.put('#', SpriteType.BOULDER);

        int ligne = 0, colonne = 0;
        for (char sousTab[] : tab) {
            colonne = 0;
            for (char chr : sousTab) {
                if (this.translation.containsKey(chr)) {
                    map[ligne][colonne] = this.translation.get(chr);
                    if (chr == 'S') {
                        boulderX = colonne;
                        boulderY = ligne;
                    }
                } else {
                    System.out.println("Error TranslateMap");
                }
                colonne++;
            }
            ligne++;
        }
    }

    public SpriteType[][] getMap(){
        return map;
    }

    public int getBoulderX(){
        return boulderX;
    }

    public int getBoulderY(){
        return boulderY;
    }




}
