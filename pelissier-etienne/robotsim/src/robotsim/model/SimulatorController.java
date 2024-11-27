package robotsim.model;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;

public class SimulatorController implements CanvasViewerController {
	
	Canvas canvasModel;
	
	transient CanvasPersistenceManager persistenceManager;
	
	Factory factoryModel;
	
	public SimulatorController(Factory factoryModel, CanvasPersistenceManager persistenceManager) {
		super();
		this.canvasModel = factoryModel;
		this.persistenceManager = persistenceManager;
		this.factoryModel = factoryModel;
	}

	public boolean addObserver(Observer observer) {
		return factoryModel.addObserver(observer);
	}
	
	public boolean removeObserver(Observer observer) {
		return factoryModel.removeObserver(observer);
	}
	
	public Canvas getCanvas() {
		return canvasModel;
	}
	
	public CanvasPersistenceManager getPersistenceManager() {
		return persistenceManager;
	}
	
	public void setCanvas(Canvas canvasModel) {
		this.canvasModel = canvasModel;
	}
	
	public void startAnimation() {
		factoryModel.startSimulation();
		
		while (factoryModel.isSimulationStarted()) {
		 factoryModel.behave();
		 try {
		 Thread.sleep( 600 );
		 }
		 catch (InterruptedException ex) {
		 ex.printStackTrace();
		 }
		}

	}
	
	public void stopAnimation() {
		factoryModel.stopSimulation();
	}
	
	public boolean isAnimationRunning() {
		return factoryModel.isSimulationStarted();
	}
	
}
