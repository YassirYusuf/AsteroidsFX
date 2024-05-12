package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        enemy = createEnemies(gameData);
        world.addEntity(enemy);
    }
    public Entity createEnemies(GameData gameData) {
        Entity Enemy = new Enemy();
        int spawncoordsE = (int)(Math.random()*(5)) - 1;
        Enemy.setX((double) gameData.getDisplayWidth()/spawncoordsE);
        Enemy.setY((double )gameData.getDisplayWidth()/spawncoordsE);
        Enemy.setPolygonCoordinates(-5,-5,10,-2,10,2,-5,5);
        Enemy.setRadius(5);
        return Enemy;
    }

    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }
}
