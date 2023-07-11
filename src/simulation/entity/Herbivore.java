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

        int oldX = this.getX();
        int oldY = this.getY();

        // Логика перемещения травоядного
        int newX = oldX + 1;
        int newY = oldY;

        // Проверить, находится ли новая позиция в пределах карты
        if (map.isWithinBounds(newX, newY)) {
            // Проверить, свободна ли новая позиция
            if (map.getObject(newX, newY) == null)  {
                // Перемещение в новую позицию
                map.moveCreature(this, newX, newY);
            }
        }
        else
        {
            // Перенаправление Herbivore или игнорирование этого хода
            // ...
        }
        map.updateEntityLocation(this, oldX, oldY);
        System.out.println("Herbivore moving");
    }

}