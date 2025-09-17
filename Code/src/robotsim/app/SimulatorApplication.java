package robotsim.app;

import robotsim.model.*;

import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.view.*;

import java.util.logging.Logger;

import fr.tp.inf112.projects.canvas.controller.*;

public class SimulatorApplication {

	public static void main(String[] args) {
		
		final Logger LOGGER = Logger.getLogger(SimulatorApplication.class.getName());
		
		Color backgroundColor = new DisplayColor(0,200,200);
		
		Color solidStrokeColor = new DisplayColor(244,128,252);
		Color dottedStrokeColor = new DisplayColor(255,240,255);
		
		float[] solidStrokePattern = {(float) 0.5};
		float[] dottedStrokePattern = {(float) 5};
		
		Stroke solidStroke = new DisplayStroke(solidStrokeColor,(float) 5.0,solidStrokePattern);
		Stroke dottedStroke = new DisplayStroke(dottedStrokeColor,(float) 3.0,dottedStrokePattern);
		
		Style basicStyle = new DisplayStyle(backgroundColor, solidStroke);
		Style zoneStyle = new DisplayStyle(backgroundColor, dottedStroke);
		
		Factory myFactory = new Factory("Synthwave Factory", "SWF", basicStyle, 100, 100, new Position(0,0),0);

		Shape room1Shape = new Rectangle(50,25);
		Room room1 = myFactory.addRoom("Room 1", basicStyle, room1Shape, new Position(0,0), 0);
		Room room2 = myFactory.addRoom("Room 2", basicStyle, room1Shape, new Position(50,0), 0);
		Shape room2Shape = new Rectangle(100,25);
		Room room3 = myFactory.addRoom("Room 3", basicStyle, room2Shape, new Position(0,25), 0);
		
		Shape productionZoneShape = new Rectangle (20,20);
		ProductionZone productionZone1 = myFactory.addProductionZone("Production Zone 1", zoneStyle, productionZoneShape, new Position(30, 0), 0);
		ProductionZone productionZone2 = myFactory.addProductionZone("Production Zone 2", zoneStyle, productionZoneShape, new Position(80, 30), 0);
		ProductionZone productionZone3 = myFactory.addProductionZone("Production Zone 3", zoneStyle, productionZoneShape, new Position(80, 40), 0);
		
		Shape machineShape = new Rectangle (10,10);
		Machine machine1 = myFactory.addMachine("Machine 1", basicStyle, machineShape, new Position(40, 5), 0.0);
		Machine machine2 = myFactory.addMachine("Machine 2", basicStyle, machineShape, new Position(90, 20), 0.0);
		Machine machine3 = myFactory.addMachine("Machine 3", basicStyle, machineShape, new Position(90, 45), 0.0);
		
		Shape chargingStationShape = new Rectangle(20,10);
		ChargingStation chargingStation1 = myFactory.addChargingStation("Charging Station 1", basicStyle, chargingStationShape, new Position(40, 35), 0.0);
		
		Shape doorsShape1 = new Rectangle(2,10);
		Door door1 = myFactory.addDoor("Door1", zoneStyle, doorsShape1, new Position(49,0), 0);
		
		Shape doorsShape2 = new Rectangle(10,2);
		Door door2 = myFactory.addDoor("Door2", zoneStyle, doorsShape2, new Position(80,24), 0);

		Shape robotShape = new Oval(2,2);
		FactoryPathFinder factoryPathFinder = new BasicPathFinder(myFactory);
		Robot robot1 = myFactory.addRobot("Robot 1", basicStyle, robotShape, 2, 100, factoryPathFinder);
		
		robot1.addComponentToBeVisited(machine1);
		robot1.addComponentToBeVisited(machine2);
		robot1.addComponentToBeVisited(chargingStation1);

		FileCanvasChooser fileCanvasChooser = new FileCanvasChooser(".txt", ".txt");
		CanvasPersistenceManager persistenceManager = new SimulatorPersistenceManager(fileCanvasChooser);
		CanvasViewerController factoryController = new SimulatorController(myFactory, persistenceManager);
		CanvasViewer viewer = new CanvasViewer(factoryController);
		
		LOGGER.info("Starting the robot simulator...");
		LOGGER.config("With parameters " + myFactory.toString() + ".");

		factoryController.startAnimation();
	}

}
