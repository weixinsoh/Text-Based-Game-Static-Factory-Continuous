package game.scraps;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing sellable.
 *
 */
public interface Sellable {
    /**
     * Complete the sale transaction for an item that an actor is trying to sell.
     *
     * @param otherActor The actor who is attempting to sell an item.
     * @param map The map the actor is on.
     */
    String sell(Actor otherActor, GameMap map);
}
