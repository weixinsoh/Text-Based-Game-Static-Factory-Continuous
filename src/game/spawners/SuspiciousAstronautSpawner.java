package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.AlienBug;
import game.actors.creatures.SuspiciousAstronaut;

public class SuspiciousAstronautSpawner implements Spawner{
    @Override
    public void spawn(Location location) {
        if (Math.random() <= 0.05) {            //5% chance of spawning
            SuspiciousAstronaut suspiciousAstronaut = new SuspiciousAstronaut();
            location.addActor(suspiciousAstronaut);
        }
    }
}
