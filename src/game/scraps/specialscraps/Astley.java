package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ListenAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an AI device, Astley that can be purchased by the computer terminal and can monologue.
 *
 */
public class Astley extends Item implements Purchasable, Monologuer {

    private static final int CREDIT = 50;

    private static final int TICKS_TO_PAY_SUBSCRIPTION = 5;

    private static final int CREDIT_TO_PAY_SUBSCRIPTION = 1;

    private boolean isSubscribed = false;

    private int count = 0;

    /**
     * Constructor of Astley class.
     *
     */
    public Astley() {
        super("Astley", 'z', true);
    }

    /**
     * Count the passage of carrying time and handle subscription.
     * Overrides Item.tick(Location currentLocation, Actor actor)
     *
     * @see Item#tick(Location currentLocation, Actor actor)
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        Display display = new Display();
        count++;
        if (this.count % TICKS_TO_PAY_SUBSCRIPTION == 0) {
            if (actor.getBalance() >= CREDIT_TO_PAY_SUBSCRIPTION){
                isSubscribed = true;
                actor.deductBalance(CREDIT_TO_PAY_SUBSCRIPTION);
                display.println("Subscription payment received!");
            } else {
                isSubscribed = false;
                display.println("You don't have enough money to continue using our AI services. Goodbye.");
            }
        }
    }

    /**
     *
     * Allow the actor to listen the monologue of the device.
     * Overrides Item.allowableActions(Actor)
     *
     * @see Item#allowableActions(Actor)
     * @param owner the actor that owns the item
     * @return a list of actions that can be performed on the
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        if (isSubscribed)
            actions.add(new ListenAction(this));
        return actions;
    }

    /**
     * Returning a list of monologue options that can be performed by Astley
     * Overrides Monologuer.allowableMonologues(Actor)
     *
     * @see Monologuer#allowableMonologues(Actor)
     * @param owner The actor who listen to the monologuer.
     * @return a list of string containing available monologue options.
     */
    @Override
    public List<String> allowableMonologues(Actor owner){
        List<String> monologues = new ArrayList<>();
        monologues.add("The factory will never gonna give you up, valuable intern!");
        monologues.add("We promise we never gonna let you down with a range of staff benefits.");
        monologues.add("We never gonna run around and desert you, dear intern!");
        if (owner.getItemInventory().size() > 10)
            monologues.add("We never gonna make you cry with unfair compensation.");
        if (owner.getBalance() > 50)
            monologues.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
        if (owner.getAttribute(BaseActorAttributes.HEALTH) < 2)
            monologues.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        return monologues;
    }

    /**
     * Purchase an Astley with a certain credit and add it to actor's item inventory
     * Overrides PurchaseCapable.purchase(Actor)
     *
     * @see Purchasable#purchase(Actor)
     * @param actor The actor who purchases Astley.
     * @return a string representing the actor purchases the Astley with a certain credit.
     */
    @Override
    public String purchase(Actor actor) {
        isSubscribed = true;
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
    }

    /**
     * Retrieve the actual credits needed when purchasing the item.
     *
     * @return the amount of actual credits
     */
    @Override
    public int getActualCredit() {
        return CREDIT;
    }

    /**
     * Returns a string representation of Astley.
     * @return a string representation of Astley
     */
    @Override
    public String toString(){
        return "Astley, an AI device";
    }
}