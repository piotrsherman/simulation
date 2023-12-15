package simulation.actions;
import simulation.Coordinates;
import simulation.SimulationMap;
import simulation.entity.Creature;
import simulation.entity.Entity;
import simulation.entity.Herbivore;
import simulation.entity.Predator;
import java.util.ArrayList;
import java.util.Collection;
public class TurnAction implements Action {
    @Override
    public void perform(SimulationMap map) {
        System.out.println("performing turn actions..........");
        Collection<Entity> entities = map.getEntities();
        Collection<Entity> tempEntities = new ArrayList<>(entities);
        for (Entity entity : tempEntities) {
            if (entity instanceof Creature) {
                Creature creature = (Creature) entity;
                creature.makeMove(map);
            }
        }
        entities.clear();
        entities.addAll(tempEntities);
    }
}