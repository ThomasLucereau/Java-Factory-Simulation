package robotsim.model;

import fr.tp.inf112.projects.canvas.model.*;

public class Puck extends MobileComponent {

	public static final long serialVersionUID = 202405251130L;
	
	Robot robot;
	
	public Puck(String name, Style style, Shape shape, Position position, double orientation) {
		super(name, style, shape, position, orientation);
	}

	@Override
	public String toString() {
		return "Puck [" + super.toString() + "]";
	}
	
	private boolean moveWithRobot() {
		this.setxCoord(robot.getxCoordinate());
		this.setyCoord(robot.getyCoordinate());
		return true;
	}
	
	public void behave() {
		if (!(robot==null)) {
			moveWithRobot();
		}
	}
	
}
