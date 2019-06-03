package contract.model;

/**
 * <h1>The Class Position</h1>
 *
 * @author Groupe2
 */

public class Position {

    /** The x coordinate of the position */
    private int x;

    /** The y coordinate of the position */
    private int y;

    /** The maximum x coordinate of the position */
    private int xMax;

    /** The maximum y coordinate of the position */
    private int yMax;

    /**
     * Instantiate a new Position
     * @param x
     * 		The position along x axis
     * @param y
     * 		The position along y axis
     * @param xMax
     * 		The max position along x axis
     * @param yMax
     * 		The max position along y axis
     * @throws Exception
     *      max position is out of range
     */
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

    /**
     * Instantiate a new Position
     * @param position
     * 		The position
     */
    public Position(Position position){
        this.x = position.getX();
        this.y = position.getY();

        this.xMax = position.getXMax();
        this.yMax = position.getYMax();
    }

    /**
     * Gets the max y coordinate
     * @return the max y coordinate
     */
    public int getYMax() {
        return yMax;
    }

    /**
     * Gets the max x coordinate
     * @return the max x coordinate
     */
    public int getXMax() {
        return xMax;
    }

    /**
     * Gets the y coordinate
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the x coordinate
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate
     * @return x
     * 		The x coordinate to set
     */
    public void setX(int x) throws Exception {

        if (x < 0 || x > xMax)
            throw new Exception("X out of range");
        else
            this.x = x;
    }

    /**
     * Sets the y coordinate
     * @return y
     * 		The y coordinate to set
     */
    public void setY(int y) throws Exception {

        if (y < 0 || y > yMax)
            throw new Exception("Y out of range");
        else
            this.y = y;
    }
    /**
     * Sets the x coordinate
     * @return x
     * 		The x coordinate to set
     */

    public void setxMax(int xMax){
        this.xMax = xMax;
    }

    /**
     * Sets the y coordinate
     * @return y
     * 		The y coordinate to set
     */
    public void setyMax(int yMax){
        this.yMax = yMax;
    }
}
