package robotsim.model;

import fr.tp.inf112.projects.canvas.model.*;

public class DisplayStroke extends DisplayParameter implements Stroke {
	
	public static final long serialVersionUID = 202405251113L;
	
	private Color color;
	
	private float thickness;
	
	private float[] dashPattern;

	public Color getColor() {
		return color;
	}

	public float getThickness() {
		return thickness;
	}

	public float[] getDashPattern() {
		return dashPattern;
	}

	public DisplayStroke(Color color, float thickness, float[] dashPattern) {
		super();
		this.color = color;
		this.thickness = thickness;
		this.dashPattern = dashPattern;
	}
	
}
