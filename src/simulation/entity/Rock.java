package simulation.entity;

import simulation.entity.Entity;

public class Rock extends Entity {

    public Rock(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\uD83D\uDDFF";
    }
}