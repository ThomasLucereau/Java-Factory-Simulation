package robotsim.model;

import fr.tp.inf112.projects.canvas.model.*;

public class Rectangle extends DisplayShape implements RectangleShape{
	
	public static final long serialVersionUID = 202405251131L;
	
	private int width;
	
	private int height;

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public Rectangle getApproximateShape() {	//returns the object Shape that refers to a rectangle that circumbscribes this shape
		return new Rectangle(this.getWidth(),this.getHeight());
	}
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
}
