package simulation.entity;

import simulation.entity.Entity;

public class Rock extends Entity {

    private int x;
    private int y;
    public Rock(int x, int y) {
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
        return "\uD83D\uDDFF";
    }
}