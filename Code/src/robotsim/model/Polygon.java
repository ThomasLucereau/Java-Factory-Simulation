package robotsim.model;

import java.util.Set;

import fr.tp.inf112.projects.canvas.model.*;

public class Polygon extends DisplayShape implements PolygonShape{
	
	public static final long serialVersionUID = 202405251120L;
	
	private Set<Vertex> Vertices;

	public Set<Vertex> getVertices() {
		return Vertices;
	}

	private int getThickness() {
		int maxDistance = 0;
		for (Vertex vertex1 : Vertices) {
			for (Vertex vertex2 : Vertices) {
				maxDistance = Math.max(maxDistance, (int) ( Math.sqrt( Math.pow(vertex1.getxCoordinate()-vertex2.getxCoordinate(),2) + Math.pow(vertex1.getyCoordinate()-vertex2.getyCoordinate(),2) ) ) + 1 );
			}
		}
		return maxDistance;
	}
	
	@Override
	public Rectangle getApproximateShape() {	//returns the object Shape that refers to a rectangle that circumbscribes this shape
		return new Rectangle(this.getThickness(),this.getThickness());
	}
	
}

