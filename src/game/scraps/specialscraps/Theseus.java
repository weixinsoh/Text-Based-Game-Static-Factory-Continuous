package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class Theseus extends Item implements Purchasable{
    private static final int CREDIT = 100;

    /***
     * Constructor.
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    @Override
    public String purchase(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
    }

    @Override
    public int getActualCredit() {
        return CREDIT;
    }
}
