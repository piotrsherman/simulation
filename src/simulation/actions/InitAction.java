package simulation.actions;
import simulation.SimulationMap;
public class InitAction implements Action{
    @Override
    public void perform(SimulationMap map) {
        System.out.println("Performing init actions............");
        map.populateEntities();
        map.render();
    }
}