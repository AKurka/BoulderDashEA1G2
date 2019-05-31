package contract.model;

/**
 * <h1>The Class Position</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.2
 */
public class Position {

    /** The x coordinate of the position */
    private int x;
    /** The y coordinate of the position */
    private int y;
    /** The maximum x coordinate of the position */
    private int maxX;
    /** The maximum x coordinate of the position */
    private int maxY;

    /**
     * Instantiate a new Position
     * @param x
     * 		The position along x axis
     * @param y
     * 		The position along y axis
     * @param maxX
     * 		The max position along x axis
     * @param maxY
     * 		The max position along y axis
     * @throws Exception
     *      max position is out of range
     */
    public Position(int x, int y, int maxX, int maxY) throws Exception {

        if (maxY < 0)
            throw new Exception("Ymax out of range");
        else
            this.maxY = maxY;

        if (maxX < 0)
            throw new Exception("Xmax out of range");
        else
            this.maxX = maxX;

        if (x < 0 || x > maxX)
            throw new Exception("X out of range");
        else
            this.x = x;

        if (y < 0 || y > maxY)
            throw new Exception("Y out of range");
        else
            this.y = y;
        this.maxY = maxY;
    }

    /**
     * Instantiate a new Position
     * @param position
     * 		The position
     */
    public Position(Position position){
        this.x = position.getX();
        this.y = position.getY();
        this.maxX = position.getMaxX();
        this.maxY = position.getMaxY();
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
     * @param x
     * 		The x coordinate to set
     * @throws Exception
     *      x coordinate is out of range
     */
    public void setX(int x) throws Exception {

        if (x < 0 || x > maxX)
            throw new Exception("X out of range");
        else
            this.x = x;
    }

    /**
     * Gets the y coordinate
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate
     * @param y
     * 		The y coordinate to set
     * @throws Exception
     *      y coordinate is out of range
     */
    public void setY(int y) throws Exception {

        if (y < 0 || y > maxY)
            throw new Exception("Y out of range");
        else
            this.y = y;
    }

    /**
     * Gets the max x coordinate
     * @return the max x coordinate
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Sets the max x coordinate
     * @param maxX
     * 		The max x coordinate to set
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Gets the max y coordinate
     * @return the max y coordinate
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Sets the max y coordinate
     * @param maxY
     * 		The max y coordinate to set
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}