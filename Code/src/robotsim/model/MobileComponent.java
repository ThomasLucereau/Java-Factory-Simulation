package robotsim.model;

import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.*;

public abstract class MobileComponent extends Component {
	
	public static final long serialVersionUID = 202405251520L;
	
	private Position position; //position of the top-left corner of the component
	
	private double orientation; //in radians, counterclockwise, 0 means aiming to the right of the screen

	public MobileComponent(String name, Style style, Shape shape, Position position, double orientation) {
		super(name, style, shape);
		this.position = position;
		this.orientation = orientation;
	}
	
	public int getxCoordinate() {
		return position.getxCoord();
	}

	public int getyCoordinate() {
		return position.getyCoord();
	}

	@Override
	public Position getPosition() {
		return position;
	}

	public double getOrientation() {
		return orientation;
	}
	
	public void setPosition(Position position) {
		this.position = position;
		factory.notifyObservers();
	}
	
	public void setxCoord(int xCoord) { //set the xCoord attribute of the Position attribute of this to xCoord
		this.position.setxCoord(xCoord);
		factory.notifyObservers();
	}

	public void setyCoord(int yCoord) {
		this.position.setyCoord(yCoord);
		factory.notifyObservers();
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
		factory.notifyObservers();
	}

	@Override
	public String toString() {
		return super.toString() + "xCoord=" + position.getxCoord() + ", yCoord=" + position.getyCoord() + ", orientation=" + orientation + ", ";
	}
	
	public void increasexCoordinate(int deltaX) { //is public visibility good enough ?
		setxCoord(this.getxCoordinate() + deltaX);
	}
	
	public void increaseyCoordinate(int deltaY) { //is public visibility good enough ?
		setyCoord(this.getyCoordinate() + deltaY);
	}
	
	public void increaseOrientation(double deltaTheta) { //is public visibility good enough ?
		setOrientation(this.orientation + deltaTheta);
	}
	
	@Override
	public ArrayList<Position> getSurfacePoints(){
		ArrayList<Position> surfacePoints = new ArrayList<Position>();
		Rectangle approximateShape = ((DisplayShape) this.getShape()).getApproximateShape();
		int xMax = approximateShape.getWidth() + getxCoordinate();
		int yMax = approximateShape.getHeight() + getyCoordinate();

		for (int xIndex = getxCoordinate(); xIndex <= xMax; xIndex ++) {
			for (int yIndex = getyCoordinate(); yIndex <= yMax; yIndex ++) {
				Position position = new Position(xIndex,yIndex);
				surfacePoints.add(position);
			}
		}
		return surfacePoints;
	}
}
