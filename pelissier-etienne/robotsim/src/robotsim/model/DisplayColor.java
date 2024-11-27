package robotsim.model;

import fr.tp.inf112.projects.canvas.model.Color;

public class DisplayColor extends DisplayParameter implements Color{
	
	public static final long serialVersionUID = 202405251112L;
	
	private int redComponent;
	
	private int greenComponent;
	
	private int blueComponent;

	public int getRedComponent() {
		return redComponent;
	}

	public int getGreenComponent() {
		return greenComponent;
	}

	public int getBlueComponent() {
		return blueComponent;
	}

	public DisplayColor(int redComponent, int greenComponent, int blueComponent) {
		super();
		this.redComponent = redComponent;
		this.greenComponent = greenComponent;
		this.blueComponent = blueComponent;
	}
	
}
