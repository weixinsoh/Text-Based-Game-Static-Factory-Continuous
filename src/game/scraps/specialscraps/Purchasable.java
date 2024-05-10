package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface representing purchase-capable.
 *
 */
public interface Purchasable {

    /**
     * Add the effect to the actor after purchasing.
     *
     * @param actor The actor who purchases the purchasable object.
     * @return a string representing the actor purchases the purchasable object and the effect.
     */
    String purchase(Actor actor);

    /**
     * Retrieve the actual credits needed when purchasing the purchasable object.
     *
     * @return the amount of actual credits
     */
    int getActualCredit();

}
