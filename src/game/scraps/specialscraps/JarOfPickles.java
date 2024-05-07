package game.scraps.specialscraps;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * Class that represents a Jar Of Pickles that can be consumed to randomly hurt or heal the player
 *
 */
public class JarOfPickles extends Item implements Consumable {
    /**
     * Amount of health that can be affected by the Jar Of Pickles
     */
    private static final int JAR_OF_PICKLES_HEALTH_AFFECTED = 1;

    /**
     * Probability that the Jar Of Pickles has expired and hence hurts instead of heals
     */
    private static final double EXPIRED_PROBABILITY = 0.5;

    /**
     * Constructor of the Jar Of Pickles class.
     *
     */
    public JarOfPickles() {
        super("Jar Of Pickles", 'n', true);
    }

    /**
     * Heals or hurts the actor after consuming and
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
     * Allow the actor to consume the Jar Of Pickles
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
}