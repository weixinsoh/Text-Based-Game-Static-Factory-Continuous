package game.scraps.specialscraps;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing sellable item.
 *
 */
public interface Sellable {
    /**
     * Complete the sale transaction for an item that an actor is trying to sell.
     *
     * @param otherActor The actor who is attempting to sell an item.
     * @param map The map the actor is on.
     * @return a string representing whether the actor sold the item with a certain credit.
     */
    String sell(Actor otherActor, GameMap map);
}
