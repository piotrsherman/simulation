package simulation;

import simulation.entity.CoordinatesShift;
import simulation.entity.Creature;
import simulation.entity.Entity;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setupDefaultEntitiesPositions();

        MapConsoleRenderer renderer  = new MapConsoleRenderer();
        renderer.render(map);

        Entity entity = map.getEntity(new Coordinates(File.B, 1));//схватили фигуру
        Set<Coordinates> availableMoveSquares = entity.getAvailableMoveSquares(map);

        Coordinates sourceCoordinates = new Coordinates(File.B, 1);
        Coordinates targetCoordinates = new Coordinates(File.C, 2);

        map.moveEntity(sourceCoordinates, targetCoordinates);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        renderer.render(map);
        int a = 123;
    }
}