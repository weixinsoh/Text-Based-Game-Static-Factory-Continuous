package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Class representing payment process.
 *
 */
public class Payment {

    /**
     * Processes a payment with a certain credits.
     *
     * @param actor the actor who purchased the item
     * @param credit the amount of credits required for purchase
     * @return true as the payment can be successfully processed; false otherwise
     */
    public static boolean makePayment(Actor actor, int credit) {
        if (actor.getBalance() >= credit){
            actor.addBalance(credit * -1);
            return true;
        } else
            return false;
    }
}
