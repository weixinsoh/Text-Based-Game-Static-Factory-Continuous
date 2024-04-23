package game.consumable;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface representing consumable.
 *
 */
public interface Consumable {
    /**
     * Add the effect to the actor after consuming.
     *
     * @param actor The actor who consumed the consumable.
     * @return a string representing the actor consumed the consumable and the effect.
     */
    String consumedBy(Actor actor);
}
