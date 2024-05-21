package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
/**
 *  This interface manages the lifecycles of the game plugins
 */

public interface IGamePluginService {
    /**
     * Starts the game plugin.
     *
     * Pre-condition: GameData and World instances are being properly initialized.
     * Post-condition: Game plugin is initialized, and then all game entities are being created and added into the world
     *
     * @param gameData object contains game state information.
     * @param world object contains all game entities.
     */
    void start(GameData gameData, World world);
    /**
     * Stops the game plugin.
     *
     * Pre-condition: Game Plugin is up and running
     * Post-condition: Game plugin are being stopped, and the game entities are removed from the word
     *
     * @param gameData object contains game state information.
     * @param world object contains all game entities.
     */

    void stop(GameData gameData, World world);
}
