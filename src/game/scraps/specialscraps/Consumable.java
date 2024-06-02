package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing consumable.
 *
 */
public interface Consumable {

    /**
     * Add the effect to the actor after consuming.
     *
     * @param actor The actor who consumed the consumable.
     * @param map the map where the actor is located
     * @return a string representing the actor consumed the consumable and the effect.
     */
    String consumedBy(Actor actor, GameMap map);
}
