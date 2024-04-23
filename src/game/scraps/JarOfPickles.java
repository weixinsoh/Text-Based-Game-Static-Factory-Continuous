package game.scraps;


import edu.monash.fit2099.engine.actors.Actor;
import game.consumable.ConsumableItem;

public class JarOfPickles extends ConsumableItem {
    private static final int JAR_OF_PICKLES_HEALTH_AFFECTED = 1;

    private static final double EXPIRED_PROBABILITY = 0.5;
    public JarOfPickles() {
        super("Jar Of Pickles", 'n', true);
    }

    @Override
    public String consumedBy(Actor actor) {
        if(Math.random() <= EXPIRED_PROBABILITY){
            actor.heal(JAR_OF_PICKLES_HEALTH_AFFECTED);
            return String.format("%s and %s heals %s by %d points.", super.consumedBy(actor), this, actor, JAR_OF_PICKLES_HEALTH_AFFECTED);
        } else {
            actor.hurt(JAR_OF_PICKLES_HEALTH_AFFECTED);
            return String.format("%s and %s hurts %s by %d points.", super.consumedBy(actor), this, actor, JAR_OF_PICKLES_HEALTH_AFFECTED);
        }
    }
}