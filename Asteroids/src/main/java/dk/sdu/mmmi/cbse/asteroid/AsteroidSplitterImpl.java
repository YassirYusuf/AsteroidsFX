package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;

import java.util.Random;

/**
 *
 * @author corfixen
 */
public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        if (!(e instanceof Asteroid)) {
            return;
        }

        Asteroid original = (Asteroid) e;
        Random rnd = new Random();

        int numSplits = 2; // Number of asteroids created from the original
        double sizeReductionFactor = 0.5; // Smaller size for the new asteroids
        double angleVariation = 15; // Degrees to vary the new asteroid's path

        for (int i = 0; i < numSplits; i++) {
            Asteroid split = new Asteroid();
            int newSize = (int)(original.getRadius() * sizeReductionFactor);
            split.setPolygonCoordinates(newSize, -newSize, -newSize, -newSize, -newSize, newSize, newSize, newSize);
            split.setX(original.getX());
            split.setY(original.getY());
            split.setRadius(newSize);

            // Set new rotation slightly varied from the original
            double newRotation = original.getRotation() + rnd.nextDouble() * angleVariation - angleVariation / 2;
            split.setRotation(newRotation);

            world.addEntity(split);
        }


        world.removeEntity(original);
    }

}
