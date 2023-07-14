package simulation.entity;

import simulation.Coordinates;
import simulation.PathFinder;
import simulation.SimulationMap;

import java.util.LinkedList;

public class Herbivore extends Creature {

    private SimulationMap map;
    private LinkedList<Coordinates> path;
    private PathFinder pathFinder = new PathFinder();
    public Herbivore(int x, int y, SimulationMap map) {
        super(x, y);
        this.map = map;
    }

    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Grass;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC16"; // Травоядное - 🐖
    }


    @Override
    public void makeMove(SimulationMap map) {

        int oldX = this.getX();
        int oldY = this.getY();

        // Логика перемещения травоядного
        if (this.path == null || this.path.isEmpty()) {
            // Если не задан путь или путь уже завершен, найдите новый путь до ближайшего травяного.
            this.path = new LinkedList<>(pathFinder.findPath(new Coordinates(oldX, oldY), this, map));
        }

        // Продолжаем следовать по пути, если это возможно.
        if (!this.path.isEmpty()) {
            Coordinates nextStep = this.path.removeFirst();

            // Проверить, находится ли новая позиция в пределах карты
            if (map.isWithinBounds(nextStep.getX(), nextStep.getY())) {
                // Проверить, свободна ли новая позиция
                if (map.getObject(nextStep.getX(), nextStep.getY()) == null)  {
                    // Перемещение в новую позицию
                    map.moveCreature(this, nextStep.getX(), nextStep.getY());
                }
            }
        }
        map.updateEntityLocation(this, oldX, oldY);
        System.out.println("Herbivore moving");
    }


}