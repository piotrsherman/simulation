package simulation;

import simulation.entity.Entity;

public class MapConsoleRenderer {
    public void render(Map map){// метод для рендеринга карты, пустые ячейки обозначаем точками, а на занятые ствим существ
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

    private String setSpriteToEntity(String sprite){// метод для получения символа для обозначения существа на карте
        String result = sprite;
        return result;
    }

    private String getSpringForEmptySquare(Coordinates coordinates){// метод для назначения символа пустой ячейки на карте, то есть точки
        return " ·  ";
    }

    private String selectSpriteForEntity(Entity entity){//метод для назначения символов unicode существ для прорисовки на карте
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
