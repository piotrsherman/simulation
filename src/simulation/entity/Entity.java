package simulation.entity;
public abstract class Entity {
    int x;
    int y;
    public Entity(int x, int y) {
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
        return "";
    }
}