package contract.model;

public class Position {

    private int x;

    private int y;

    private int xMax;

    private int yMax;

    public Position(int x, int y, int xMax, int yMax){
        this.x = x;
        this.y = y;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public Position(Position position){
        this.x = position.getX();
        this.y = position.getY();

        this.xMax = position.getXMax();
        this.yMax = position.getYMax();
    }

    public int getYMax() {
        return yMax;
    }

    public int getXMax() {
        return xMax;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setxMax(int xMax){
        this.xMax = xMax;
    }

    public void setyMax(int yMax){
        this.yMax = yMax;
    }
}
