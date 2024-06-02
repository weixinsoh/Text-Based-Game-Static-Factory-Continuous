package game.scraps.specialscraps;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.capabilities.Status;

/**
 * Class that represents a Jar Of Pickles that can be consumed to randomly hurt or heal the player
 *
 */
public class JarOfPickles extends Item implements Consumable, Sellable {

    private static final int JAR_OF_PICKLES_HEALTH_AFFECTED = 1;

    private static final double EXPIRED_PROBABILITY = 0.5;

    private static final double SELL_SPECIAL_CASE_CHANCE = 0.5;

    private static final int SELL_SPECIAL_CASE_CREDIT = 50;

    private static final int SELL_CREDIT = 25;

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
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor the actor who consumes the Jar Of Pickles
     * @return a string representing the actor has consumed the Jar Of Pickles and the amount of health the Jar Of Pickles affected
     */
    @Override
    public String consumedBy(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        if(Math.random() <= EXPIRED_PROBABILITY){
            actor.heal(JAR_OF_PICKLES_HEALTH_AFFECTED);
            return String.format("%s consumed %s and %s heals %s by %d points. ", actor, this, this, actor, JAR_OF_PICKLES_HEALTH_AFFECTED);
        } else {
            actor.hurt(JAR_OF_PICKLES_HEALTH_AFFECTED);
            if (!actor.isConscious()){
                actor.unconscious(map);
            }
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
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Allows the actor with jar of pickles to sell the jar of pickles to another actor
     * if that actor has the BUYER status
     * Overrides Item.allowableActions(Actor otherActor, Location location)
     *
     * @param otherActor the other actor that the actor with jar of pickles is next to
     * @param location the location of the other actor
     * @return a list of allowable actions that can be taken
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.BUYER)){
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Sell a jar of pickles with a certain credit (based on probability) and remove it from the actor's item inventory.
     *
     * @see Sellable#sell(Actor, GameMap)
     * @param otherActor The actor who sold the jar of pickles.
     * @param map The map the actor is on.
     * @return a string representing the actor sold the jar of pickles with a certain credit.
     */
    @Override
    public String sell(Actor otherActor, GameMap map) {
        otherActor.removeItemFromInventory(this);
        if (Math.random() <= SELL_SPECIAL_CASE_CHANCE){
            otherActor.addBalance(SELL_SPECIAL_CASE_CREDIT);
            return String.format("%s successfully sold Jar of Pickles for %d credits.", otherActor, SELL_SPECIAL_CASE_CREDIT);
        } else {
            otherActor.addBalance(SELL_CREDIT);
            return String.format("%s successfully sold Jar of Pickles for %d credits.", otherActor, SELL_CREDIT);
        }
    }
}