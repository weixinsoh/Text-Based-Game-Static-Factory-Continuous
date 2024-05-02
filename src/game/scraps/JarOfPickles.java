package game.scraps;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.consumable.Consumable;

public class JarOfPickles extends Item implements Consumable {
    private static final int JAR_OF_PICKLES_HEALTH_AFFECTED = 1;

    private static final double EXPIRED_PROBABILITY = 0.5;
    public JarOfPickles() {
        super("Jar Of Pickles", 'n', true);
    }

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

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }
}