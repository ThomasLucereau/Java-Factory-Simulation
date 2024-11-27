package robotsim.model;

import java.io.Serializable;

public class Position implements Serializable{
	
	public static final long serialVersionUID = 202405251519L;
	
	private int xCoord;
	
	private int yCoord;

	public Position(int xCoord, int yCoord) {
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
}
