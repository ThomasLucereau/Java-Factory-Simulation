package robotsim.model;

import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.*;

public class StaticComponent extends Component {
	
	public static final long serialVersionUID = 202405251521L;
	
	final private Position position; //position of the top-left corner of the component
	
	final private double orientation; //in radians, counterclockwise, 0 means aiming to the right of the screen

	public StaticComponent(String name, Style style, Shape shape, Position position, double orientation) {
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

	public double getOrientation() {
		return orientation;
	}

	@Override
	public Position getPosition() {
		return position;
	}
	
	@Override
	public String toString() {
		return super.toString() + "xCoord=" + this.getxCoordinate() + ", yCoord=" + this.getyCoordinate() + ", orientation=" + orientation + ", ";
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
