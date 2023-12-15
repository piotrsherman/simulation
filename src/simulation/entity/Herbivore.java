package simulation.entity;
import simulation.Coordinates;
import simulation.PathFinder;
import simulation.SimulationMap;
import java.util.LinkedList;
public class Herbivore extends Creature {
    private SimulationMap map;
    private LinkedList<Coordinates> path;
    private PathFinder pathFinder = new PathFinder();
    public Herbivore(int x, int y, SimulationMap map) {
        super(x, y);
        this.map = map;
    }
    @Override
    public boolean isTarget(Entity entity) {
        return entity instanceof Grass;
    }
    @Override
    public String toString() {
        return "\uD83D\uDC16"; // Травоядное - 🐖
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
                if (entityAtNextStep instanceof Grass) {
                    System.out.println("Herbivore ate a Grass");
                    eat(nextStep);
                    this.path.clear();
                } else if (entityAtNextStep == null) {
                    this.path.removeFirst();
                    map.moveCreature(this, nextStep.getX(), nextStep.getY());
                }
            }
        }
        map.updateEntityLocation(this, oldX, oldY);
        System.out.println("Herbivore moving");
    }
    public void eat(Coordinates grassPosition) {
        Entity entity = map.getObject(grassPosition.getX(), grassPosition.getY());
        if (entity instanceof Grass) {
            map.removeEntity(grassPosition.getX(), grassPosition.getY());
            this.moveTo(grassPosition.getX(), grassPosition.getY());
        }
    }
}