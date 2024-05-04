package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actors.Actor;

public class Payment {

    public static boolean makePayment(Actor actor, int credit) {
        if (actor.getBalance() >= credit){
            actor.addBalance(credit * -1);
            return true;
        } else
            return false;
    }
}
