package robotsim.model;

import fr.tp.inf112.projects.canvas.model.*;

public class ChargingStation extends MobileComponent {

	public static final long serialVersionUID = 202405251111L;
	
	public ChargingStation(String name, Style style, Shape shape, Position position, double orientation) {
		super(name, style, shape, position, orientation);
	}
	
	@Override
	public String toString() {
		return "ChargingStation [" + super.toString() + "]";
	}
	
}
