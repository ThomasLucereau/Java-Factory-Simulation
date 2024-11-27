package robotsim.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.tp.inf112.projects.canvas.controller.*;
import fr.tp.inf112.projects.canvas.model.*;

public class Factory extends StaticComponent implements Canvas, Observable {
	
	public static final long serialVersionUID = 202405241503L;
	
	private List<Robot> robots;
	
	private List<Room> rooms;
	
	private List<ProductionZone> productionZones;
	
	private List<Puck> pucks;
	
	private ArrayList<Door> doors;
	
	private List<Machine> machines;
	
	private List<ChargingStation> chargingStations;
	
	private List<Component> components;
	
	private int width;
	
	private int height;
	
	private String id;
	
	private transient List<Observer> observers;
	
	private transient boolean simulationRunning;
	
	private boolean checkComponent(Component component) {
		boolean isUnique=true;
		for (Component existingComponent : components) {
			if (existingComponent == component) {
				isUnique=false;
			}
		}
		return isUnique;
	}

	private boolean addComponent(Component component) {
		if (checkComponent(component)) {
		components.add(component);
		return true;
		}
		else {
		return false;
		}
	}
	
	private boolean checkRobotName(String name) {
		//may be better to call it robotNameIsUnique
		boolean isUnique=true;
		for (Robot existingRobot : robots) {
			String existingRobotName = existingRobot.getName();
			if (name.equals(existingRobotName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public Robot addRobot(String name, Style style, Shape robotShape, int speed, int battery, FactoryPathFinder factoryPathFinder) {
		if (checkRobotName(name)) {
			Robot newRobot = new Robot(name, style, robotShape, new Position(10,10), 0, speed, battery, factoryPathFinder);
			robots.add(newRobot);
			addComponent(newRobot);
			return newRobot;
		}
		else {
			return null;
		}
	}
	
	private boolean checkRoomName(String name) {
		//may be better to call it roomNameIsUnique
		boolean isUnique=true;
		for (Room existingRoom : rooms) {
			String existingRoomName = existingRoom.getName();
			if (name.equals(existingRoomName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public Room addRoom(String name, Style style, Shape roomShape, Position position, double orientation) {
		if (checkRoomName(name)) {
			Room room = new Room(name, style, roomShape, position, orientation);
			rooms.add(room);
			addComponent(room);
			return room;
		}
		else {
			return null;
		}
	}

	private boolean checkProductionZoneName(String name) {
		//may be better to call it productionZoneNameIsUnique
		boolean isUnique=true;
		for (ProductionZone existingProductionZone : productionZones) {
			String existingProductionZoneName = existingProductionZone.getName();
			if (name.equals(existingProductionZoneName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public ProductionZone addProductionZone(String name, Style style, Shape productionZoneShape, Position position, double orientation) {
		if (checkProductionZoneName(name)) {
			ProductionZone productionZone = new ProductionZone(name, style, productionZoneShape, position, orientation);
			productionZones.add(productionZone);
			addComponent(productionZone);
			return productionZone;
		}
		else {
			return null;
		}
	}
	
	public boolean chechPuckName(String name) {
		//may be better to call it productionZoneNameIsUnique
		boolean isUnique=true;
		for (Puck existingPuck : pucks) {
			String existingPuckName = existingPuck.getName();
			if (name.equals(existingPuckName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public Puck addPuck(String name, Style style, Shape puckShape, Position position, double orientation) {
		if (checkProductionZoneName(name)) {
			Puck puck = new Puck(name, style, puckShape, position, orientation);
			pucks.add(puck);
			addComponent(puck);
			return puck;
		}
		else {
			return null;
		}
	}
	
	private boolean checkDoorName(String name) {
		//may be better to call it robotNameIsUnique
		boolean isUnique=true;
		for (Door existingDoor : doors) {
			String existingDoorName = existingDoor.getName();
			if (name.equals(existingDoorName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public Door addDoor(String name, Style style, Shape doorShape, Position position, double orientation) {
		if (checkDoorName(name)) {
			Door door = new Door(name, style, doorShape, position, orientation);
			doors.add(door);
			addComponent(door);
			return door;
		}
		else {
			return null;
		}
	}
	
	private boolean checkMachineName(String name) {
		//may be better to call it machineNameIsUnique
		boolean isUnique=true;
		for (Machine existingMachine : machines) {
			String existingMachineName = existingMachine.getName();
			if (name.equals(existingMachineName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public Machine addMachine(String name, Style style, Shape machineShape, Position position, double orientation) {
		if (checkMachineName(name)) {
			Machine machine = new Machine(name, style, machineShape, position, orientation);
			machines.add(machine);
			addComponent(machine);
			return machine;
		}
		else {
			return null;
		}
	}
	
	
	private boolean checkChargingStationName(String name) {
		//may be better to call it chargingStationNameIsUnique
		boolean isUnique=true;
		for (ChargingStation chargingStation : chargingStations) {
			String chargingStationName = chargingStation.getName();
			if (name.equals(chargingStationName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public ChargingStation addChargingStation(String name, Style style, Shape chargingStationShape, Position position, double orientation) {
		if (checkChargingStationName(name)) {
			ChargingStation chargingStation = new ChargingStation(name, style, chargingStationShape, position,orientation);
			chargingStations.add(chargingStation);
			addComponent(chargingStation);
			return chargingStation;
		}
		else {
			return null;
		}
	}
	

	
	
	
	
	public String getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<Door> getDoors(){
		return doors;
	}
	
	public void setSimulationRunning(boolean simulationRunning) {
		this.simulationRunning = simulationRunning;
		factory.notifyObservers();
	}

	public Collection<Figure> getFigures(){
		return (Collection) components;
	}

	public Factory(String name, String id, Style style, int width, int height, Position position, double orientation) {
		super(name, style, new Rectangle(width, height), position, orientation); //null -> end of the loop (Factory factory; declaration in Component)
		factory = this;
		this.robots = new ArrayList<Robot>();
		this.rooms = new ArrayList<Room>();
		this.productionZones = new ArrayList<ProductionZone>();
		this.pucks = new ArrayList<Puck>();
		this.doors = new ArrayList<Door>();
		this.machines = new ArrayList<Machine>();
		this.chargingStations = new ArrayList<ChargingStation>();
		this.components = new ArrayList<Component>();
		this.id = id + "_" + Long.toString( System.currentTimeMillis() ); //is it enough to assure uniqueness of id ?
		this.width=width;
		this.height=height;
		this.simulationRunning = false;
	}

	@Override
	public String toString() {
		return "Factory [" + super.toString() + "robots=" + robots.toString() + ", " + "rooms=" + rooms.toString() + "]";
	}
	
	@Override
	public void behave() {
		for (Component factoryComponent : components) {
			factoryComponent.behave();
		}
	}
	
	public boolean addObserver(Observer observer) {
		if (observers == null) {	//lazy initialization strategy
			observers = new ArrayList<Observer>();
		}
		return observers.add(observer);
	}
	
	public boolean removeObserver(Observer observer) {
		if (observers == null) {	//lazy initialization strategy
			observers = new ArrayList<Observer>();
		}
		return observers.remove(observer);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.modelChanged();
		}
	}
	
	public void startSimulation() {
		setSimulationRunning(true);
	}
	
	public void stopSimulation() {
		setSimulationRunning(false);
	}
	
	public boolean isSimulationStarted() {
		return simulationRunning;
	}
	
	public boolean isChevauching(BasicVertex vertex) {
		for (Room room : rooms) {
			if (room.overlays(vertex)) {
				for (Door door : getDoors()) {
					if(!door.overlays(vertex) & door.isOpen()) {
						return true;
					}
				}
			
			}
		}
		return false;
	}
}
