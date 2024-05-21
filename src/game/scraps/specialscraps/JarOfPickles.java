package game.scraps.specialscraps;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Status;
import game.scraps.Sellable;

/**
 * Class that represents a Jar Of Pickles that can be consumed to randomly hurt or heal the player
 *
 */
public class JarOfPickles extends Item implements Consumable, Sellable {

    private static final int JAR_OF_PICKLES_HEALTH_AFFECTED = 1;

    private static final double EXPIRED_PROBABILITY = 0.5;

    /**
     * Constructor of the Jar Of Pickles class.
     *
     */
    public JarOfPickles() {
        super("Jar Of Pickles", 'n', true);
    }

    /**
     * Heals or hurts the actor after consuming randomly depending on the probability of expiry and
     * Removes the Jar Of Pickles from the actor's inventory
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumes the Jar Of Pickles
     * @return a string representing the actor has consumed the Jar Of Pickles and the amount of health the Jar Of Pickles affected
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        if(Math.random() <= EXPIRED_PROBABILITY){
            actor.heal(JAR_OF_PICKLES_HEALTH_AFFECTED);
            return String.format("%s consumed %s and %s heals %s by %d points. ", actor, this, this, actor, JAR_OF_PICKLES_HEALTH_AFFECTED);
        } else {
            actor.hurt(JAR_OF_PICKLES_HEALTH_AFFECTED);
            return String.format("%s consumed %s and %s hurts %s by %d points. ", actor, this, this, actor, JAR_OF_PICKLES_HEALTH_AFFECTED);
        }
    }

    /**
     * Allow the actor to consume the Jar Of Pickles by returning an ActionList that consists of ConsumeAction
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the consumable item Jar Of Pickles
     */

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }
        return actions;
    }

    @Override
    public int getCreditForSale() {
        if (Math.random() <= 0.5){
            return 50;
        } else {
            return 25;
        }
    }

    @Override
    public Item soldBy() {
        return this;
    }
}