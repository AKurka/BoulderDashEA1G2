package contract.model;

public interface IComportment {

    void move() throws Exception;
    void moveRight() throws Exception;
    void moveLeft() throws Exception;
    void moveUp() throws Exception;
    void moveDown() throws Exception;

    void moveAll() throws Exception;

    void gravit1() throws Exception;
}
