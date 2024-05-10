package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.spawners.Spawner;

import java.util.ArrayList;
import java.util.List;


/**
 * Class representing crater that can spawn creatures.
 *
 */
public class Crater extends Ground {
    private Spawner spawner;

    /**
     * Constructor of the Crater class.
     *
     * @param spawner the spawner associated with the Creature to be created.
     */
    public Crater(Spawner spawner) {
        super('u');
        this.spawner = spawner;
    }

    /**
     * Spawn creature with a probability at every tick.
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
            if (!exit.getDestination().containsAnActor()) {
                exits.add(exit);
            }
        }
        Location destination = exits.get(Utility.generateRandomInt(0, exits.size())).getDestination();
        spawner.spawn(destination);
    }
}
