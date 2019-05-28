package controller;

import contract.*;

public class Controller {
    private UserOrder stackOrder = UserOrder.NOOP;
    private int SET_SIZE = 0;
    private int colonne = 0;
    private int ligne = 0 ;
    private int finalDiamonds = 0;
    private IPanel panel;
    private ISprite sprite;
    private IMapBuilder builder;
    private IMove move;

    private IFrame frame;
    private End end;

    public Controller(ISprite sprite, IPanel panel, int SET_SIZE, IMapBuilder builder, IFrame frame, int finalDiamonds) {
        this.panel = panel;
        this.sprite = sprite;
        this.SET_SIZE = SET_SIZE;
        this.builder = builder;
        this.frame = frame;
        this.finalDiamonds = finalDiamonds;

         
    }
}
