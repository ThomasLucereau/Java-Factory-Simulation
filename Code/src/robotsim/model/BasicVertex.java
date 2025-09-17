package robotsim.model;

public class BasicVertex {
	
	Position position;

	public BasicVertex(int xCoord, int yCoord) {
		super();
		this.position = new Position(xCoord,yCoord);
	}

	public Position getPosition() {
		return position;
	}
	
}
