package simulation.entity;

import simulation.entity.Entity;

public class Tree extends Entity {

    private int x;
    private int y;
    public Tree(int x, int y) {
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
        return "\uD83C\uDF33"; // Дерево - 🌳
    }
}