package simulation.entity;

import simulation.SimulationMap;

public class Herbivore extends Creature {

    private SimulationMap map;
    public Herbivore(int x, int y, SimulationMap map) {
        super(x, y);
        this.map = map;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC16"; // Травоядное - 🐖
    }

    public void findClosestGrass() {
        Entity closestGrass = null;
        double closestDistance = Double.MAX_VALUE;

        for (Entity entity : map.getEntities()) {
            if (entity instanceof Grass) {
                double distance = getDistance(this, entity);
                if (distance < closestDistance) {
                    closestGrass = entity;
                    closestDistance = distance;
                }
            }
        }

        if (closestGrass != null) {
            System.out.println("Ближайший объект Grass находится по координатам: (" + closestGrass.getX() + ", " + closestGrass.getY() + ")");
        } else {
            System.out.println("Нет объектов Grass на карте.");
        }
    }

    // Метод вычисления расстояния между двумя сущностями
    private double getDistance(Entity e1, Entity e2) {
        int dx = e1.getX() - e2.getX();
        int dy = e1.getY() - e2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void makeMove(SimulationMap map) {


        int oldX = this.getX();
        int oldY = this.getY();

        // Логика перемещения травоядного
        int newX = oldX + 1;
        int newY = oldY;

        findClosestGrass();

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