package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * Class that represents a Pot of Gold that can be used by the intern to add 10 gold to the Intern's balance
 *
 */
public class PotOfGold extends Item implements Consumable {

    /**
     * The amount of gold in the Pot
     */
    private static final int POT_OF_GOLD_BALANCE = 10;


    /**
     * Constructor of the PotOfGold class.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }

    /**
     * Adds the POT_OF_GOLD_BALANCE to the actor's balance and
     * Removes the Pot of Gold from the actor's inventory
     * Overrides Consumable.consumedBy(Actor)
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor the actor who consumes the Pot of Gold
     * @return a string representing the actor has consumed the Pot of Gold and the amount the Pot of Gold adds to the actor's balance
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(POT_OF_GOLD_BALANCE);
        return String.format("%s is placed into %s's wallet and the amount of gold increases by %d.", this, actor, POT_OF_GOLD_BALANCE);
    }

    /**
     * Allow the actor to consume the Pot of Gold
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @return a list of actions that can be performed on the consumable item Pot of Gold
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
