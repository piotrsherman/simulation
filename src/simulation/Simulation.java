package simulation;

import simulation.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private SimulationMap map;
    private int turnCounter;
    public List<Action> initActions;
    public List<Action> turnActions;

    public Simulation(int width, int height) {
        map = new SimulationMap(width, height);
        turnCounter = 0;
        initActions = new ArrayList<>();
        turnActions = new ArrayList<>();
    }

    public void addInitAction(Action action) {
        initActions.add(action);
    }

    public void addTurnAction(Action action) {
        turnActions.add(action);
    }

    public void nextTurn() throws InterruptedException {
        System.out.println("Turn: " + turnCounter);
        for (Action action : turnActions) {
            action.perform(map);
        }
        map.render();
        Thread.sleep(2000); // задержка на 3 секунды
        turnCounter++;
    }


    public void startSimulation() throws InterruptedException {
        System.out.println("Simulation started.");
        for (Action action : initActions) {
            action.perform(map);
        }
        map.render();
        while (true) {
            nextTurn();
        }
    }

    public void pauseSimulation() {
        System.out.println("Simulation paused.");
        // Дополнительные операции при приостановке симуляции (при необходимости)
    }
}