package simulation.entity;

import simulation.Coordinates;

public class Predator extends Creature {
    // хищник - в дополнение к полям класса simulation.entity.Creature имеет силу атаки
    // может потратить ход на перемещение или на атаку тарвоядного

    public Predator(Coordinates coordinates) {
        super(coordinates);
    }
}
