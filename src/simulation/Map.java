package simulation;

import simulation.entity.*;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity){
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates){
        entities.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to){
        Entity entity = getEntity(from);

        removeEntity(from);
        setEntity(to, entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates){// проверка ячейки на карте, на факт того, что она свободна
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){// метод для получения существа по заданным координатам
        return entities.get(coordinates);
    }

    public void setupDefaultEntitiesPositions(){
        setEntity(new Coordinates(File.A, 1), new Predator(new Coordinates(File.A, 1)));
        setEntity(new Coordinates(File.B, 1), new Herbivore(new Coordinates(File.B, 1)));
        setEntity(new Coordinates(File.A, 2), new Tree(new Coordinates(File.A, 2)));
        setEntity(new Coordinates(File.E, 5), new Grass(new Coordinates(File.E, 5)));
    }
}
