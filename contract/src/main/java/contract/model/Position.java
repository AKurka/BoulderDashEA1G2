package contract.model;

public class Position {

    private int x;

    private int y;

    private int xMax;

    private int yMax;

    public Position(int x, int y, int xMax, int yMax) throws Exception{
        if (yMax < 0)
            throw new Exception("Ymax out of range");
        else
            this.yMax = yMax;

        if (xMax < 0)
            throw new Exception("Xmax out of range");
        else
            this.xMax = xMax;

        if (x < 0 || x > xMax)
            throw new Exception("X out of range");
        else
            this.x = x;

        if (y < 0 || y > yMax)
            throw new Exception("Y out of range");
        else
            this.y = y;
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

    public void setX(int x) throws Exception {

        if (x < 0 || x > xMax)
            throw new Exception("X out of range");
        else
            this.x = x;
    }

    public void setY(int y) throws Exception {

        if (y < 0 || y > yMax)
            throw new Exception("Y out of range");
        else
            this.y = y;
    }

    public void setxMax(int xMax){
        this.xMax = xMax;
    }

    public void setyMax(int yMax){
        this.yMax = yMax;
    }
}
