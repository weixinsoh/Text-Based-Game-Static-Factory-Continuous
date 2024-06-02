package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HumanoidFigure;
import game.actors.Player;
import game.grounds.*;
import game.grounds.trees.SproutTree;
import game.scraps.LargeBolt;
import game.scraps.specialscraps.JarOfPickles;
import game.scraps.specialscraps.MetalPipe;
import game.scraps.MetalSheet;
import game.scraps.specialscraps.PotOfGold;
import game.spawners.AlienBugSpawner;
import game.spawners.HuntsmanSpiderSpawner;
import game.spawners.SuspiciousAstronautSpawner;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new SproutTree(), new ComputerTerminal());

        // Polymorphia
        List<String> polymorphia = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~..,....................",
                "...~~~..................,.....",
                "..............................",
                ".............#####............",
                "......,......#___#...........~",
                ".............#___#..........~~",
                ".............##_##.....,...~~~",
                "...,.............~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        // Factory's spaceship parking lot
        List<String> parkingLot = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......");

        // New moon Refactorio
        List<String> refactorio = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~.......,....,...,.....,...~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~.....,....#___#.....,......",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~.....,.........~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");


        // Create maps
        GameMapFactory polymorphiaFactory = new GameMapFactory(polymorphia, "Polymorphia", 15, 6);
        GameMapFactory refactorioFactory = new GameMapFactory(refactorio, "Refactorio", 15, 6);
        GameMapFactory factoryParkingLotFactory = new GameMapFactory(parkingLot, "factory's parking lot", 3, 3);
        polymorphiaFactory.setMap(groundFactory);
        refactorioFactory.setMap(groundFactory);
        factoryParkingLotFactory.setMap(groundFactory);

        world.addGameMap(polymorphiaFactory.getMap());
        world.addGameMap(refactorioFactory.getMap());
        world.addGameMap(factoryParkingLotFactory.getMap());


        // Insert computer terminal into each map
        ComputerTerminal computerTerminal = new ComputerTerminal();
        polymorphiaFactory.getMap().at(15, 5).setGround(computerTerminal);
        refactorioFactory.getMap().at(15, 5).setGround(computerTerminal);
        factoryParkingLotFactory.getMap().at(3, 2).setGround(computerTerminal);

        computerTerminal.addTravelMap(polymorphiaFactory);
        computerTerminal.addTravelMap(refactorioFactory);
        computerTerminal.addTravelMap(factoryParkingLotFactory);


        //Insert HumanoidFigure into Parking Lot
        HumanoidFigure humanoidFigure = new HumanoidFigure();
        factoryParkingLotFactory.getMap().at(2, 3).addActor(humanoidFigure);


        // Insert scraps
        LargeBolt largeBolt = new LargeBolt();
        polymorphiaFactory.getMap().at(8, 2).addItem(largeBolt);

        MetalSheet metalSheet = new MetalSheet();
        polymorphiaFactory.getMap().at(6, 2).addItem(metalSheet);

        MetalPipe metalPipe = new MetalPipe();
        polymorphiaFactory.getMap().at(10, 10).addItem(metalPipe);

        JarOfPickles jarOfPickles = new JarOfPickles();
        polymorphiaFactory.getMap().at(8,8).addItem(jarOfPickles);

        PotOfGold potOfGold = new PotOfGold();
        polymorphiaFactory.getMap().at(8,9).addItem(potOfGold);


        // Set craters
        Crater hunstmanSpiderCrater = new Crater(new HuntsmanSpiderSpawner());
        polymorphiaFactory.getMap().at(9, 10).setGround(hunstmanSpiderCrater);

        Crater alienBugCrater = new Crater(new AlienBugSpawner());
        polymorphiaFactory.getMap().at(12, 12).setGround(alienBugCrater);

        Crater suspiciousAstronautCrater = new Crater(new SuspiciousAstronautSpawner());
        polymorphiaFactory.getMap().at(16, 12).setGround(suspiciousAstronautCrater);

        // Add player
        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, polymorphiaFactory.getMap().at(15, 6));


        // Display game title
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        world.run();
    }
}