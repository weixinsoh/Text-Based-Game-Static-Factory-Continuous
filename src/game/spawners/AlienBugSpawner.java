package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.AlienBug;
import game.actors.creatures.HuntsmanSpider;

public class AlienBugSpawner implements Spawner{
    @Override
    public void spawn(Location location) {
        if (Math.random() <= 0.1) {
            new AlienBug();
        }
    }
}
