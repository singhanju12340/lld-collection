package interview.TestApplication.kotak.model;

/**
 * @author anju
 * @created on 20/03/25 and 10:23 AM
 */
public class Ship {
    String name;
    int x;
    int y;
    int size;
    boolean isDistroyed;

    void calculateCordinates(int x, int y){

    }

    public Ship(String name, int x, int y, int size) {

        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
        this.isDistroyed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isDistroyed() {
        return isDistroyed;
    }

    public void setDistroyed(boolean distroyed) {
        isDistroyed = distroyed;
    }
}
