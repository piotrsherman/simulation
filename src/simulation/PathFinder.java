package simulation;

import simulation.entity.Creature;
import simulation.entity.Entity;

import java.util.*;

public class PathFinder {

    public List<Coordinates> findPath(Coordinates startPosition, Creature creature, SimulationMap map) {
        Deque<Coordinates> positionQueue = new ArrayDeque<>();
        Set<Coordinates> visitedPositions = new HashSet<>();

        HashMap<Coordinates, Coordinates> parents = new HashMap<>();
        positionQueue.add(startPosition);
        Coordinates targetPosition = null;
        boolean foundTarget = false;

        while (!positionQueue.isEmpty() && !foundTarget) {
            Coordinates currentPosition = positionQueue.remove();
            visitedPositions.add(currentPosition);
            List<Coordinates> neighborPositions = getNeighborPositions(currentPosition, map.getWidth(), map.getHeight());

            for (Coordinates neighborPosition : neighborPositions) {
                if (map.isWithinBounds(neighborPosition.getX(), neighborPosition.getY()) && !visitedPositions.contains(neighborPosition)) {
                    Entity entityAtLocation = map.getObject(neighborPosition.getX(), neighborPosition.getY());
                    if (creature.isTarget(entityAtLocation)) {
                        targetPosition = neighborPosition;
                        parents.put(neighborPosition, currentPosition);
                        foundTarget = true;
                        break;
                    }
                    if (entityAtLocation == null) {
                        positionQueue.add(neighborPosition);
                        parents.put(neighborPosition, currentPosition);
                    }
                }
            }
        }

        List<Coordinates> path = new LinkedList<>();
        if (targetPosition != null) {
            path.add(targetPosition);
            Coordinates tempPosition = targetPosition;
            while (path.get(path.size() - 1) != startPosition) {
                tempPosition = parents.get(tempPosition);
                path.add(tempPosition);
            }
            Collections.reverse(path);
        }

        return path;
    }

    public Coordinates findNearestEntity(Creature creature, SimulationMap map) {
        int currentX = creature.getX();
        int currentY = creature.getY();

        Entity nearestEntity = null;
        double nearestDistance = Double.POSITIVE_INFINITY;

        for (Entity entity: map.getEntities()) {
            int entityX = entity.getX();
            int entityY = entity.getY();

            if (creature.isTarget(entity)) {
                double distance = calculateDistance(currentX, currentY, entityX, entityY);

                if (distance < nearestDistance) {
                    nearestEntity = entity;
                    nearestDistance = distance;
                }
            }
        }

        if(nearestEntity != null) {
            return new Coordinates(nearestEntity.getX(), nearestEntity.getY());
        } else {
            return null;
        }
    }


    private double calculateDistance(int x1, int y1, int x2, int y2) {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


    private List<Coordinates> getNeighborPositions(Coordinates position, int mapWidth, int mapHeight) {
        int width;
        int height;
        List<Coordinates> neighborPositions = new ArrayList<>();

        if ((width = position.getX() - 1) >= 0) {
            neighborPositions.add(new Coordinates(width, position.getY()));
        }
        if ((width = position.getX() + 1) < mapWidth) {
            neighborPositions.add(new Coordinates(width, position.getY()));
        }
        if ((height = position.getY() - 1) >= 0) {
            neighborPositions.add(new Coordinates(position.getX(), height));
        }
        if ((height = position.getY() + 1) < mapHeight) {
            neighborPositions.add(new Coordinates(position.getX(), height));
        }

        return neighborPositions;
    }
}