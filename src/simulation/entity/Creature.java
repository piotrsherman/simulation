package simulation.entity;

import simulation.Coordinates;
import simulation.Map;

import java.util.HashSet;
import java.util.Set;

public class Creature extends Entity {
    // живое существо - имеет скорость (сколько клеток может пройти за 1 хода) и колличество HP
    // makeMove() - абстрактный метод сделать ход, наследники реализуют его каждый по своему
    public Creature(Coordinates coordinates) {
        super(coordinates);
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

    }
}
