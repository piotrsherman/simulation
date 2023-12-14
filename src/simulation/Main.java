package simulation;

import simulation.actions.InitAction;
import simulation.actions.TurnAction;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation(10, 10);
        simulation.initActions.add(new InitAction());
        simulation.turnActions.add(new TurnAction());
        simulation.startSimulation();
    }
}