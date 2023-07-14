package simulation;

import simulation.entity.*;

import java.util.ArrayList;
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


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void placeEntity(int x, int y, Entity entity) {
        entities.put(new Coordinates(x, y), entity);
    }

    public Entity getObject(int x, int y) {
        return entities.get(new Coordinates(x, y));
    }

    public Collection<Entity> getEntities() {
        return new ArrayList<>(entities.values());
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

        //Herbivore herbivore1 = new Herbivore(2, 3);
        //placeEntity(herbivore1.getX(), herbivore1.getY(), herbivore1);

        Herbivore herbivore1 = new Herbivore(2, 3, this);
        placeEntity(herbivore1.getX(), herbivore1.getY(), herbivore1);

        Predator predator1 = new Predator(8, 2);
        placeEntity(predator1.getX(), predator1.getY(), predator1);

        Rock rock1 = new Rock(9, 5);
        placeEntity(rock1.getX(), rock1.getY(), rock1);

        Tree tree1 = new Tree(3, 5);
        placeEntity(tree1.getX(), tree1.getY(), tree1);

        Grass grass1 = new Grass(9, 9);
        placeEntity(grass1.getX(), grass1.getY(), grass1);

        Grass grass2 = new Grass(5, 5);
        placeEntity(grass2.getX(), grass2.getY(), grass2);
    }

    public void updateEntities(Map<Coordinates, Entity> newEntities) {
        entities.clear();
        entities.putAll(newEntities);
    }




    public void moveCreature(Creature creature, int newX, int newY) {

        int oldX = creature.getX();
        int oldY = creature.getY();

        if (isWithinBounds(newX, newY)) {
            if (getObject(newX, newY) == null) {
                placeEntity(newX, newY, creature);
                removeEntity(oldX, oldY);  // старые значения x и y, потому что у объекта уже обновлены координаты
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

    public void updateEntityLocation(Entity entity, int oldX, int oldY){
        entities.remove(new Coordinates(oldX, oldY));
        int newX = ((Creature) entity).getX();
        int newY = ((Creature) entity).getY();
        entities.put(new Coordinates(newX, newY), entity);
    }

}