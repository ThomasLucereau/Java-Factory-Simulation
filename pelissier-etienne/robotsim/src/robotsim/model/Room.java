package robotsim.model;

import java.util.ArrayList;
import java.util.List;
import fr.tp.inf112.projects.canvas.model.*;

public class Room extends StaticComponent{
	
	public static final long serialVersionUID = 202405251133L;
	
	private List<Robot> robots;
	
	private ArrayList<Door> doors;
	
	private List<ProductionZone> productionZones;
	
	private List<ChargingStation> chargingStations;

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
			return door;
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
			return productionZone;
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
			ChargingStation chargingStation = new ChargingStation(name, style, chargingStationShape, position, orientation);
			chargingStations.add(chargingStation);
			return chargingStation;
		}
		else {
			return null;
		}
	}
	
	public Room(String name, Style style, Shape shape, Position position, double orientation) {
		super(name, style, shape, position, orientation);
		this.robots = new ArrayList<Robot>();
		this.doors = new ArrayList<Door>();
		this.productionZones = new ArrayList<ProductionZone>();
		this.chargingStations = new ArrayList<ChargingStation>();
	}
	
	@Override
	public String toString() {
		return "Room [" + super.toString() + ", robots=" + robots.toString() + ", doors=" + doors.toString()  + ", productionZones=" + productionZones.toString() + ", chargingStations=" + chargingStations.toString() + "]";
	}
	
	public ArrayList<Position> getEdgePoints(){
		ArrayList<Position> edgePoints = new ArrayList<Position>();
		Rectangle approximateShape = ((DisplayShape) this.getShape()).getApproximateShape();
		int xMax = approximateShape.getWidth() + getxCoordinate();
		int yMax = approximateShape.getHeight() + getyCoordinate();
		for (int xIndex = getxCoordinate(); xIndex <= xMax; xIndex++) {
			Position position = new Position(xIndex,getyCoordinate());
			edgePoints.add(position);
			createAvoidanceZone(edgePoints,position);
			
			
		}
		for (int xIndex = getxCoordinate(); xIndex <= xMax; xIndex++) {
			Position position = new Position(xIndex,yMax);
			edgePoints.add(position);
			createAvoidanceZone(edgePoints,position);

		}
		for (int yIndex = getyCoordinate(); yIndex <= xMax; yIndex++) {
			Position position = new Position(getxCoordinate(),yIndex);
			edgePoints.add(position);
			createAvoidanceZone(edgePoints,position);

		}
		
		for (int yIndex = getyCoordinate(); yIndex <= xMax; yIndex++) {
			Position position = new Position(xMax,yIndex);
			edgePoints.add(position);
			createAvoidanceZone(edgePoints,position);

		}
		
		return edgePoints;
	}
	
	public void createAvoidanceZone(ArrayList<Position> list, Position position) {
		int xCoord = position.getxCoord();
		int yCoord = position.getyCoord();
		for (int x = 1; x<1;x++) {
			list.add(new Position(xCoord + x,yCoord));
			list.add(new Position(xCoord - x,yCoord));
		}

		for (int y = 1; y<1;y++) {
			list.add(new Position(xCoord,yCoord + y));
			list.add(new Position(xCoord,yCoord - y));
		}

	}
	
	public ArrayList<Door> getDoors(){
		return doors;
	}
	
	@Override
	public Boolean overlays(BasicVertex vertex) {
		Position vertexPosition = vertex.getPosition();
		for (Position position : getEdgePoints()) {
			if (position.getxCoord() == vertexPosition.getxCoord() && position.getyCoord() == vertexPosition.getyCoord() ) {
				return true;
			}
		}
		return false;
	}
	
}
