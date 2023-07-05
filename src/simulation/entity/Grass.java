package simulation.entity;

public class Grass extends Entity{


    private int x;
    private int y;
    public Grass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return "\uD83C\uDF3F"; // Трава - 🌿
    }
}