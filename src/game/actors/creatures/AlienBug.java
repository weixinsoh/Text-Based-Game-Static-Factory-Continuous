package game.actors.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
import game.actions.AttackAction;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;
import game.behaviours.WanderBehaviour;
import game.capabilities.Ability;
import game.capabilities.Status;

public class AlienBug extends Creature {

    private static final int PICKUP_BEHAVIOUR_PRIORITY = 997;
    private static final int FOLLOW_BEHAVIOUR_PRIORITY = 998;
    private static final int WANDER_BEHAVIOUR_PRIORITY = 999;
    private Behaviour followBehaviour;


    /**
     * Constructor of the Creature class.
     *
     */
    public AlienBug() {
        super(String.format("Feature-%d", Utility.generateRandomInt(100, 999)), 'a', 2);
        this.addBehaviour(PICKUP_BEHAVIOUR_PRIORITY, new PickUpBehaviour());
        this.addBehaviour(WANDER_BEHAVIOUR_PRIORITY, new WanderBehaviour());
        this.addCapability(Ability.ENTER_SPACESHIP);
        this.addCapability(Status.HOSTILE_TO_INTERN);
    }

    /**
     * The Alien Bug can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * Overrides Actor.allowableActions(Actor, String, GameMap)
     *
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            this.addBehaviour(FOLLOW_BEHAVIOUR_PRIORITY, new FollowBehaviour(otherActor));
        }
        return actions;
    }

    @Override
    public Creature spawn() {
        return null;
    }

    @Override
    public String unconscious(GameMap map) {
        for (Item item: this.getItemInventory()){
            new DropAction(item).execute(this, map);
        }
        return "";
    }
}
