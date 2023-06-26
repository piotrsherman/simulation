package simulation.entity;

import simulation.SimulationMap;

public class Herbivore extends Creature {
    public Herbivore(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC16"; // Травоядное - 🐖
    }

    @Override
    public void makeMove(SimulationMap map) {
        // Логика перемещения травоядного
        System.out.println("Herbivore moving");
    }
}
