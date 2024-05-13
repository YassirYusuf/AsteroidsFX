package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class EnemyControlSystem implements IEntityProcessingService {

    private Random rand = new Random();
    private static final double SPAWN_PROBABILITY = 0.001;

    @Override
    public void process(GameData gameData, World world) {

        if (Math.random() < SPAWN_PROBABILITY) {
            world.addEntity(createEnemies(gameData));
        }
        for (Entity enemy : world.getEntities(Enemy.class)) {
            // Random movement
            int move = rand.nextInt(3) - 1; // Randomly generates -1, 0, or 1
            enemy.setRotation(enemy.getRotation() + move * 5);

            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + changeX * 0.5); // Moves slower than the player
            enemy.setY(enemy.getY() + changeY * 0.5);

            // Random shooting
            if (rand.nextDouble() < 0.1) { // 10% chance to shoot each frame
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }

            // Boundary conditions to keep the enemy on screen
            if (enemy.getX() < 0) enemy.setX(gameData.getDisplayWidth());

            if (enemy.getX() > gameData.getDisplayWidth()) enemy.setX(0);

            if (enemy.getY() < 0) enemy.setY(gameData.getDisplayHeight());

            if (enemy.getY() > gameData.getDisplayHeight()) enemy.setY(0);

            if (enemy.isCollided()){
                world.removeEntity(enemy);
            }
        }
    }

    public Entity createEnemies(GameData gameData) {
        Entity Enemy = new Enemy();
        int x = rand.nextInt(gameData.getDisplayWidth());
        int y = rand.nextInt(gameData.getDisplayHeight());
        Enemy.setPolygonCoordinates(-5,-5,10,-2,10,2,-5,5);
        Enemy.setRadius(5);
        return Enemy;
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
