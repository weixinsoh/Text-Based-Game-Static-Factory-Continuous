package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing crater that can spawn creatures.
 *
 */
public class Crater extends Ground {
    /**
     * Random used to generate random integer.
     */
    public final Random random = new Random();

    private Creature creature;

    /**
     * Constructor of the Crater class.
     *
     * @param creature the type of creature to spawn.
     */
    public Crater(Creature creature) {
        super('u');
        this.creature = creature;
    }

    /**
     * Spawn creature with a probability at every tick.
     *
     * Overrides Ground.tick(Location)
     *
     * @see Ground#tick(Location)
     * @param location The location of the Ground.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

        List<Exit> exits = new ArrayList<>();
        for (Exit exit: location.getExits()) {
            if (exit.getDestination().canActorEnter(creature)) {
                exits.add(exit);
            }
        }
        Location destination = exits.get(random.nextInt(exits.size())).getDestination();

        Creature spawnedCreature = creature.spawn();
        if (spawnedCreature != null) {
            destination.addActor(spawnedCreature);
        }
    }
}
