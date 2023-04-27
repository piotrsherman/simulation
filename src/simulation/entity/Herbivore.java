package simulation.entity;

import simulation.Coordinates;

public class Herbivore extends Creature {
    //Травоядное существо - Стремится найти ресурс (траву)
    // может потратить свой ход либо на движение в сторону травы, либо на её поглощение

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }
}
