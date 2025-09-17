package robotsim.model;

import java.io.Serializable;
import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.*;

public abstract class Component implements Figure, Serializable {

	public static final long serialVersionUID = 202405251109L;

	final private String name;
	
	private Style style;
	
	final private Shape shape;
	
	static Factory factory;

	public Component(String name, Style style, Shape shape) {
		super();
		this.name = name;
		this.style = style;
		this.shape = shape;
	}
	
	public String getName() {
		return name;
	}
	
	public Style getStyle() {
		return style;
	}
	
	public void setColor(Color color) {
		this.style = new DisplayStyle(color,style.getStroke()); 
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public Position getPosition() {	//might be preferable to declare Position getPosition() in Figure (see TP 8 where Position needs to be defined)
		return null;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", style=" + style.toString() + ", shape=" + shape.toString() + ", ";
	}
	
	public void behave() {
		
	}
	
	public ArrayList<Position> getSurfacePoints(){
		
		return null;
	}
	
	public Boolean overlays(BasicVertex vertex) {
		Position vertexPosition = vertex.getPosition();
		for (Position position : getSurfacePoints()) {
			if (position.getxCoord() == vertexPosition.getxCoord() && position.getyCoord() == vertexPosition.getyCoord() ) {
				return true;
			}
		}
		return false;
	}
	
	
}
