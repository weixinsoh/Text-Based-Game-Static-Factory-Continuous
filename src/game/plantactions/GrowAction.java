package game.plantactions;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.trees.Inheritree;

public class GrowAction implements PlantAction {
    private int treeAge;
    private Inheritree nextStage;
    private int tickToNextStage;

    public GrowAction(Inheritree nextStage, int tickToNextStage){
        this.treeAge = 0;
        this.nextStage = nextStage;
        this.tickToNextStage = tickToNextStage;
    }

    @Override
    public boolean executeAction(Location location){
        this.treeAge++;
        if (treeAge >= tickToNextStage){
            location.setGround(nextStage);
            return true;
        }
        return false;
    }
}
