package simulation.entity;
import simulation.Coordinates;
import simulation.PathFinder;
import simulation.SimulationMap;
import java.util.LinkedList;
public class Predator extends Creature {
    private SimulationMap map;
    private LinkedList<Coordinates> path;
    private PathFinder pathFinder = new PathFinder();
    public Predator(int x, int y, SimulationMap map) {
        super(x, y);
        this.map = map;
    }
    @Override
    public String toString() {
        return "\uD83D\uDC3A"; // Хищник - 🐺
    }
    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Herbivore;
    }
    @Override
    public void makeMove(SimulationMap map) {
        int oldX = this.getX();
        int oldY = this.getY();
        if (this.path == null || this.path.isEmpty()) {
            this.path = new LinkedList<>(pathFinder.findPath(new Coordinates(oldX, oldY), this, map));
            this.path.removeFirstOccurrence(new Coordinates(oldX, oldY));
        }
        if (!this.path.isEmpty()) {
            Coordinates nextStep = this.path.peekFirst();
            if (map.isWithinBounds(nextStep.getX(), nextStep.getY())) {
                Entity entityAtNextStep = map.getObject(nextStep.getX(), nextStep.getY());
                if (entityAtNextStep instanceof Herbivore) {
                    System.out.println("Predator ate a Herbivore");
                    eat(nextStep);
                    this.path.clear();
                } else if (entityAtNextStep == null) {
                    System.out.println("Moving to next positoin");
                    this.path.removeFirst();
                    map.moveCreature(this, nextStep.getX(), nextStep.getY());
                }
            }
        }
        map.updateEntityLocation(this, oldX, oldY);
        System.out.println("Predator moving");
    }
    public void eat(Coordinates herbivorePosition) {
        Entity entity = map.getObject(herbivorePosition.getX(), herbivorePosition.getY());
        if (entity instanceof Herbivore) {
            map.removeEntity(herbivorePosition.getX(), herbivorePosition.getY());
            this.moveTo(herbivorePosition.getX(), herbivorePosition.getY());
        }
    }
}