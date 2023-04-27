package simulation;

import simulation.entity.*;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entities = new HashMap<>();// коллекция расположения существ на карте, координаты и тип существа

    public void setEntity(Coordinates coordinates, Entity entity){// метод, который выставляет существо на карту
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates){// проверка ячейки на карте, на факт того, что она свободна
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){// метод для получения существа по заданным координатам
        return entities.get(coordinates);
    }

    public void setupDefaultEntitiesPositions(){// метод для расстановки существ на карте при старте симуляции
        setEntity(new Coordinates(File.A, 1), new Predator(new Coordinates(File.A, 1)));
        setEntity(new Coordinates(File.B, 1), new Herbivore(new Coordinates(File.B, 1)));
        setEntity(new Coordinates(File.A, 2), new Tree(new Coordinates(File.A, 2)));
    }
}
