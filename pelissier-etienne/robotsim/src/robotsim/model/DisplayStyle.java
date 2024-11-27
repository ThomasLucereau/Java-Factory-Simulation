package robotsim.model;

import fr.tp.inf112.projects.canvas.model.*;

public class DisplayStyle extends DisplayParameter implements Style{
	
	public static final long serialVersionUID = 202405251115L;
	
	private Color backgroundColor;
	
	private Stroke stroke;

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public DisplayStyle(Color backgroundColor, Stroke stroke) {
		super();
		this.backgroundColor = backgroundColor;
		this.stroke = stroke;
	}
	
	public Stroke setStroke(){
		return stroke;
	}
	
}
