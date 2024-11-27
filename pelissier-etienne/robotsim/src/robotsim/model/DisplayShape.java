package robotsim.model;

import java.util.HashSet;
import java.util.Set;

import fr.tp.inf112.projects.canvas.model.*;

public abstract class DisplayShape extends DisplayParameter implements Shape {
	
	public static final long serialVersionUID = 202405261557L;
	
	public Rectangle getApproximateShape() {	//returns the object Shape that refers to a rectangle that circumbscribes this shape
		return null;
	}
	
	public Set<Position> getRelativeApproximateOccupiedPositions() {
		Rectangle approximateShape = this.getApproximateShape();
		int width = approximateShape.getWidth();
		int height = approximateShape.getHeight();
		Set<Position> relativeOccupiedPositions = new HashSet<Position>();
		for (int x=0 ; x <= width ; x++) {
			for (int y=0 ; y <= height ; y++) {
				relativeOccupiedPositions.add(new Position(x,y));
			}
		}
		
		return relativeOccupiedPositions;
	}
}
