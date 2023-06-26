package simulation;

import simulation.entity.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SimulationMap {
    private int width;
    private int height;
    private Map<Coordinates, Entity> entities;

    public SimulationMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public void placeEntity(int x, int y, Entity entity) {
        entities.put(new Coordinates(x, y), entity);
    }

    public Entity getObject(int x, int y) {
        return entities.get(new Coordinates(x, y));
    }

    public Collection<Entity> getEntities() {
        return entities.values();
    }

    public void removeEntity(int x, int y) {
        entities.remove(new Coordinates(x, y));
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Entity entity = getObject(x, y);
                if (entity != null) {
                    System.out.print(entity.toString() + " ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public void populateEntities() {

        Herbivore herbivore1 = new Herbivore(2, 3);
        placeEntity(herbivore1.getX(), herbivore1.getY(), herbivore1);

        Herbivore herbivore2 = new Herbivore(5, 5);
        placeEntity(herbivore2.getX(), herbivore2.getY(), herbivore2);

        Predator predator1 = new Predator(8, 2);
        placeEntity(predator1.getX(), predator1.getY(), predator1);

        Predator predator2 = new Predator(9, 9);
        placeEntity(predator2.getX(), predator2.getY(), predator2);


        placeEntity(1, 1, new Rock());
        placeEntity(4, 4, new Tree());
        placeEntity(8, 3, new Grass());
    }


    public void moveCreature(Creature creature, int newX, int newY) {
        if (isWithinBounds(newX, newY)) {
            if (getObject(newX, newY) == null) {
                placeEntity(newX, newY, creature);
                removeEntity(creature.getX(), creature.getY());
                creature.moveTo(newX, newY);
            } else {
                // Взаимодействие между существами
                Entity targetEntity = getObject(newX, newY);
                if (creature instanceof Herbivore && targetEntity instanceof Grass) {
                    // Логика поедания травы травоядными
                    // ...
                } else if (creature instanceof Predator && targetEntity instanceof Herbivore) {
                    // Логика охоты хищников на травоядных
                    // ...
                }
            }
        }
    }
}
