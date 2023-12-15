package simulation.entity;
public class Grass extends Entity{
    public Grass(int x, int y) {
        super(x, y);
    }
    @Override
    public String toString() {
        return "\uD83C\uDF3F"; // Трава - 🌿
    }
}