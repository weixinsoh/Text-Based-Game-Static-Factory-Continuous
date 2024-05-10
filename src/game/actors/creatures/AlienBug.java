package game.actors.creatures;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Ability;
import game.capabilities.Status;

/**
 * Class representing Alien Bug that can be spawned from the crater by its spawner.
 *
 */
public class AlienBug extends Creature {

    private static final int PICKUP_BEHAVIOUR_PRIORITY = 997;
    private static final int FOLLOW_BEHAVIOUR_PRIORITY = 998;
    private static final int WANDER_BEHAVIOUR_PRIORITY = 999;

    private static final int LOWERBOUND_ID = 100;

    private static final int UPPERBOUND_ID = 999;


    /**
     * Constructor of the AlienBug class.
     *
     */
    public AlienBug() {
        super(String.format("Feature-%d", Utility.generateRandomInt(LOWERBOUND_ID, UPPERBOUND_ID)), 'a', 2);
        this.addBehaviour(PICKUP_BEHAVIOUR_PRIORITY, new PickUpBehaviour());
        this.addBehaviour(WANDER_BEHAVIOUR_PRIORITY, new WanderBehaviour());
        this.addCapability(Ability.ENTER_SPACESHIP);
        this.addCapability(Status.HOSTILE_TO_INTERN);
    }

    /**
     * The Alien Bug can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     * Overrides Actor.allowableActions(Actor, String, GameMap)
     *
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return an ActionList of actions that can be performed on it
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.FOLLOWABLE)) {
            this.addBehaviour(FOLLOW_BEHAVIOUR_PRIORITY, new FollowBehaviour(otherActor));
        }
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Method that can be executed when the actor is unconscious due to the action of another actor
     * Overrides Actor.unconscious(GameMap)
     *
     * @see Actor#unconscious(GameMap)
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return an empty string
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        ActionList actions = new ActionList();
        for (Item item: this.getItemInventory()){
            actions.add(item.getDropAction(this));
        }
        for (Action action: actions){
            action.execute(this, map);
        }
        return super.unconscious(actor, map);
    }
}
