package simulation;

import simulation.entity.Entity;

public class MapConsoleRenderer {
    public void render(Map map){
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for(File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                if(map.isSquareEmpty(coordinates)){
                    line += getSpringForEmptySquare(new Coordinates(file, rank));
                }else{
                    line += getEntitySprite(map.getEntity(coordinates));
                }
            }

            System.out.println(line);
        }
    }

    private String setSpriteToEntity(String sprite){
        String result = sprite;
        return result;
    }

    private String getSpringForEmptySquare(Coordinates coordinates){
        return " ·  ";
    }

    private String selectSpriteForEntity(Entity entity){
        switch (entity.getClass().getSimpleName()){
            case "Grass":
                return "\uD83C\uDF3F";

            case "Rock":
                return "\uD83E\uDEA8";

            case "Tree":
                return "\uD83C\uDF33";

            case "Herbivore":
                return "\uD83D\uDC16";

            case "Predator":
                return "\uD83D\uDC3A";
        }
        return "";
    }

    private String getEntitySprite(Entity entity) {//метод для получения символа (эмодзи) существа
        return setSpriteToEntity(selectSpriteForEntity(entity) + "  ");
    }

}
