package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {
    /**
     * This method handles the Post-process of game entities.
     *
     * Pre-condition: Main entity processing has been completed.
     * Post-condition: Additional processing (e.g., collision detection) is performed on the entities in the World.
     *
     * @param gameData object contains game state information.
     * @param world object contains all game entities.
     */

    void process(GameData gameData, World world);
}
