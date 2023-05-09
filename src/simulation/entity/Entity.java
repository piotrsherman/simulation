package simulation.entity;

import simulation.Coordinates;
import simulation.Map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract public class Entity {
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableMoveSquares(Map map){

        Set<Coordinates> result = new HashSet<>();

        for(CoordinatesShift shift : getEntityMoves()){
            if(coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);

                if(isSquareAvailableForMove(newCoordinates, map)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
        return map.isSquareEmpty(coordinates);
    }

    protected Set<CoordinatesShift> getEntityMoves(){// в шахматах это абстрактный метод и описываться для каждой фигуры отельно, а мы сделаем здесь для всех фигур
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1, 0),
                new CoordinatesShift(0, 1),

                new CoordinatesShift(-1, 0),
                new CoordinatesShift(0, -1)
        ));
    }
}
