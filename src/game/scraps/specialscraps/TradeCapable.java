package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface representing trade-capable.
 *
 */
public interface TradeCapable {

    /**
     * Add the effect to the actor after trading.
     *
     * @param actor The actor who purchases the tradeCapable object.
     * @return a string representing the actor trades the tradeCapable object and the effect.
     */
    String trade(Actor actor);

    /**
     * Retrieve the actual credits needed when purchasing the tradable item.
     *
     * @return the amount of actual credits
     */
    int getActualCredit();

}
