package simulation.entity;

import simulation.SimulationMap;

public abstract class Creature extends Entity {
    private int x;
    private int y;

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public abstract void makeMove(SimulationMap map);
}