package simulation.entity;
import simulation.SimulationMap;
public abstract class Creature extends Entity {
    public Creature(int x, int y) {
        super(x, y);
    }
    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
    public abstract void makeMove(SimulationMap map);
    public abstract boolean isTarget(Entity entity);

}