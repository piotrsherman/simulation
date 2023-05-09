package simulation;

import simulation.entity.Creature;
import simulation.entity.Entity;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setupDefaultEntitiesPositions();

        MapConsoleRenderer renderer  = new MapConsoleRenderer();
        renderer.render(map);

        Entity entity = map.getEntity(new Coordinates(File.B, 1));
        Set<Coordinates> availableMoveSquares = entity.getAvailableMoveSquares(map);

        int a = 123;
    }
}