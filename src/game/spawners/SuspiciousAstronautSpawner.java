package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.SuspiciousAstronaut;

/**
 * A class that represents a Suspicious Astronaut Spawner as it spawns a Suspicious Astronaut
 */
public class SuspiciousAstronautSpawner implements Spawner{

    private static final double SUSPICIOUS_ASTRONAUT_SPAWN_PROBABILITY = 0.05;
    /**
     * The method that spawns a new Suspicious Astronaut with a specific probability
     *
     * @param location Location that the Suspicious Astronaut can be spawned
     */
    @Override
    public void spawn(Location location) {
        if (Math.random() <= SUSPICIOUS_ASTRONAUT_SPAWN_PROBABILITY) {
            SuspiciousAstronaut suspiciousAstronaut = new SuspiciousAstronaut();
            location.addActor(suspiciousAstronaut);
        }
    }
}
