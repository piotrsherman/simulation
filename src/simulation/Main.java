package simulation;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setupDefaultEntitiesPositions();

        MapConsoleRenderer renderer  = new MapConsoleRenderer();
        renderer.render(map);

        int a = 123;
    }
}