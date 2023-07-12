package simulation.entity;

import simulation.entity.Entity;

public class Tree extends Entity {


    public Tree(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33"; // Дерево - 🌳
    }
}