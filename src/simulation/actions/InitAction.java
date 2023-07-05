package simulation.actions;

import simulation.SimulationMap;

public class InitAction implements Action{
    @Override
    public void perform(SimulationMap map) {
        // Действия, выполняемые перед стартом симуляции
        // Например, расстановка объектов и существ на карту
        System.out.println("Performing init actions............");
        map.populateEntities();
        map.render();
    }
}