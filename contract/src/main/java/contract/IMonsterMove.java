package contract;

public interface IMonsterMove {

    public ISprite[][] toMoveTheMonsters(ISprite[][] sprites, IAudio audio);

    public Boolean isSpriteNearToBackground(ISprite sprite);

    public void gameOver();

    public Boolean isSpriteNearToCharacter(ISprite sprite);

    public boolean isGameOver();
}
