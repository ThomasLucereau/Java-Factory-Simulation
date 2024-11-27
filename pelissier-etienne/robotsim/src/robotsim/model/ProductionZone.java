package robotsim.model;

import java.util.ArrayList;
import java.util.List;
import fr.tp.inf112.projects.canvas.model.*;

public class ProductionZone extends StaticComponent {
	
	public static final long serialVersionUID = 202405251121L;
	
	private List<Machine> machines;

	private boolean checkMachineName(String name) {
		//may be better to call it machineNameIsUnique
		boolean isUnique=true;
		for (Machine existingMachine : machines) {
			String existingMachineName = existingMachine.getName();
			if (name.equals(existingMachineName)) {
				isUnique=false;
			}
		}
		return isUnique;
	}
	
	public Machine addMachine(String name, Style style, Shape machineShape, Position position, double orientation) {
		if (checkMachineName(name)) {
			Machine machine = new Machine(name, style, machineShape, position, orientation);
			machines.add(machine);
			return machine;
		}
		else {
			return null;
		}
	}
	
	public ProductionZone(String name, Style style, Shape shape, Position position, double orientation) {
		super(name, style, shape, position, orientation);
		this.machines = new ArrayList<Machine>();
	}

	@Override
	public String toString() {
		return "ProductionZone [" + super.toString() + "machines=" + machines.toString() + "]";
	}
	
}
