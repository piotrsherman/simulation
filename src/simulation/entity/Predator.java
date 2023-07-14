package simulation.entity;

import simulation.SimulationMap;

public class Predator extends Creature {
    public Predator(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A"; // Хищник - 🐺
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Herbivore;
    }

    @Override
    public void makeMove(SimulationMap map) {
        // Логика перемещения хищника
        System.out.println("Predator moving");
    }
}