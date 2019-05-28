package contract;

public interface IMove {

    public ISprite[][] goLeft(int colonne, int ligne, ISprite sprite, IAudio audio);

    public ISprite[][] goRight(int colonne, int ligne, ISprite sprite, IAudio audio);

    public ISprite[][] goUp(int colonne, int ligne, ISprite sprite, IAudio audio);

    public ISprite[][] goDown(int colonne, int ligne, ISprite sprite, IAudio audio);

    public void gameOver(boolean gameOver);

    public boolean isGameOver();

    public boolean isVictory();

    public void setVictory(boolean victory);

    public Boolean nextToBack(ISprite sprite);

    public Boolean nextToRock(ISprite sprite);

}
