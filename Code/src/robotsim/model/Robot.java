package robotsim.model;

import java.util.ArrayList;
import java.util.List;

import fr.tp.inf112.projects.canvas.model.*;

public class Robot extends MobileComponent{
	
	public static final long serialVersionUID = 202405251558L;
	
	private int speed; //pixel by unit of time
	
	private double battery;
	
	private Puck puck;
	
	private List<Component> toBeVisited;
	
	private int numberOfComponentsVisited;
	
	private FactoryPathFinder factoryPathFinder;
	
	private List<Position> path = new  ArrayList<Position>();	//useful for persistence compared to passing it as a function argument ?
	
	private int pathIndex;

	public Robot(String name, Style style, Shape shape, Position position, double orientation, int speed,
			double battery, FactoryPathFinder factoryPathFinder) {
		super(name, style, shape, position, orientation);
		this.speed = speed;
		this.battery = battery;
		this.puck = null;
		this.toBeVisited = new ArrayList<Component>();
		this.numberOfComponentsVisited = 0;
		this.factoryPathFinder = factoryPathFinder;
		this.pathIndex = 0;
	}
	
	public double getSpeed() {
		return speed;
	}

	public double getBattery() {
		return battery;
	}

	@Override
	public String toString() {
		return "Robot [" + super.toString() + "speed=" + speed + ", battery=" + battery + "]";
	}
	
	public void addComponentToBeVisited(Component component) {
		toBeVisited.add(component); //preferably use a setter therefore modelChanged ?
	}
	
	private int getNumberOfComponentsToVisit() {
		return toBeVisited.size();
	}
	
	private void move() {
		int pathIndexIncrement = Math.min(speed, path.size() - pathIndex - 1);
		this.pathIndex += pathIndexIncrement; //notifyObservers ?
		this.setPosition(path.get(pathIndex));
	}
	
	@Override
	public void behave() {
		
		if ( numberOfComponentsVisited != getNumberOfComponentsToVisit() ) {

			if ( pathIndex == 0 ) {
				Component nextComponent = toBeVisited.get(numberOfComponentsVisited);
				path = factoryPathFinder.findPath(this,nextComponent);
				


			}
			
			if (path == null) {
				Color trappedColor = new DisplayColor(255,0,0);
				setColor(trappedColor);
				factory.stopSimulation();
					
				/*mettre une erreur*/
				
			}
			
			boolean isArrived = ( pathIndex + 1 == path.size() );	//suppose that the path always start with the beginning position of the robot
			
			if (isArrived) {
				numberOfComponentsVisited += 1;
				pathIndex = 0;	//suppose that the path always starts with the beginning position of the robot
			}
			
			else {
				move();
			}

		}
	}

}
