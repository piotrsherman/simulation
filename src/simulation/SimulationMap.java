package simulation;
import simulation.entity.*;
import java.util.*;
public class SimulationMap {
    private int width;
    private int height;
    private Map<Coordinates, Entity> entities;
    public SimulationMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void placeEntity(int x, int y, Entity entity) {
        entities.put(new Coordinates(x, y), entity);
    }
    public Entity getObject(int x, int y) {
        return entities.get(new Coordinates(x, y));
    }
    public Collection<Entity> getEntities() {
        return new ArrayList<>(entities.values());
    }
    public void removeEntity(int x, int y) {
        entities.remove(new Coordinates(x, y));
    }
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Entity entity = getObject(x, y);
                if (entity != null) {
                    System.out.print(entity.toString() + " ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
    public void populateEntities() {
        Random rand = new Random();
        placeEntityAtRandomLocation(new Herbivore(rand.nextInt(width), rand.nextInt(height), this));
        placeEntityAtRandomLocation(new Herbivore(rand.nextInt(width), rand.nextInt(height), this));
        placeEntityAtRandomLocation(new Herbivore(rand.nextInt(width), rand.nextInt(height), this));
        placeEntityAtRandomLocation(new Predator(rand.nextInt(width), rand.nextInt(height), this));
        placeEntityAtRandomLocation(new Predator(rand.nextInt(width), rand.nextInt(height), this));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Grass(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Tree(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Tree(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Tree(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Rock(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Rock(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Rock(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Rock(rand.nextInt(width), rand.nextInt(height)));
        placeEntityAtRandomLocation(new Rock(rand.nextInt(width), rand.nextInt(height)));
    }
    private void placeEntityAtRandomLocation(Entity entity){
        Random rand = new Random();
        int x,y;
        do{
            x = rand.nextInt(width);
            y = rand.nextInt(height);
        }while(getObject(x, y) != null);
        placeEntity(x, y, entity);
    }
    public void updateEntities(Map<Coordinates, Entity> newEntities) {
        entities.clear();
        entities.putAll(newEntities);
    }
    public void moveCreature(Creature creature, int newX, int newY) {
        int oldX = creature.getX();
        int oldY = creature.getY();
        if (isWithinBounds(newX, newY)) {
            if (getObject(newX, newY) == null) {
                placeEntity(newX, newY, creature);
                removeEntity(oldX, oldY);  // старые значения x и y, потому что у объекта уже обновлены координаты
                creature.moveTo(newX, newY);
            }
        }
    }
    public void updateEntityLocation(Entity entity, int oldX, int oldY){
        entities.remove(new Coordinates(oldX, oldY));
        int newX = ((Creature) entity).getX();
        int newY = ((Creature) entity).getY();
        entities.put(new Coordinates(newX, newY), entity);
    }
}