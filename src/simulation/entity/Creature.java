package simulation.entity;

import simulation.Coordinates;
import simulation.Map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Creature extends Entity {
    // живое существо - имеет скорость (сколько клеток может пройти за 1 хода) и колличество HP
    // makeMove() - абстрактный метод сделать ход, наследники реализуют его каждый по своему
    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

}
