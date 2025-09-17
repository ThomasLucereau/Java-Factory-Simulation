package robotsim.model;

import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.*;

public class Door extends MobileComponent {
	
	Boolean open = true;
	
	public static final long serialVersionUID = 202405251116L;
	
	boolean isOpen() {
		return open;
	}

	public Door(String name, Style style, Shape shape, Position position, double orientation) {
		super(name, style, shape, position, orientation);
	}
	
	@Override
	public String toString() {
		return "Door [isOpen()=" + isOpen() + super.toString() + "]";
	}
	
	public void changeOpen() {
		this.open = !open;
	}
	
	@Override
	public ArrayList<Position> getSurfacePoints(){
		ArrayList<Position> surfacePoints = new ArrayList<Position>();
		Rectangle approximateShape = ((DisplayShape) this.getShape()).getApproximateShape();
		if (approximateShape.getWidth()>approximateShape.getHeight()) {
			int xMax = approximateShape.getWidth() + getxCoordinate()-2;
			int yMax = approximateShape.getHeight() + getyCoordinate();

			for (int xIndex = getxCoordinate()+2; xIndex < xMax; xIndex ++) {
				for (int yIndex = getyCoordinate(); yIndex < yMax; yIndex ++) {
				Position position = new Position(xIndex,yIndex);
				surfacePoints.add(position);
				}
			}
			return surfacePoints;
		}
		else {
			int xMax = approximateShape.getWidth() + getxCoordinate();
			int yMax = approximateShape.getHeight() + getyCoordinate()-3;

			for (int xIndex = getxCoordinate(); xIndex < xMax; xIndex ++) {
				for (int yIndex = getyCoordinate()+3; yIndex < yMax; yIndex ++) {
				Position position = new Position(xIndex,yIndex);
				surfacePoints.add(position);
				}
			}
			return surfacePoints;
		}

	}
}
