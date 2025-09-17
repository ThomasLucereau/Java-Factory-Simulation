package robotsim.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collection;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;

public class SimulatorPersistenceManager extends AbstractCanvasPersistenceManager {
	
	public SimulatorPersistenceManager(CanvasChooser canvasChooser) {
		super(canvasChooser);
	}
	
	public Canvas read(String canvasId) throws IOException { 
		FileInputStream fileStream = new FileInputStream("Joe_Bleau.bin");
		ObjectInputStream objStream = new ObjectInputStream(fileStream);
		Factory factory;
		try {
			factory = (Factory) objStream.readObject();
			objStream.close();
			return factory;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			objStream.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			objStream.close();
			return null;
		}
	}
	
	public void persist(Canvas canvasModel) throws IOException {
		Collection<Figure> components = canvasModel.getFigures();
		OutputStream fileOutStream = new FileOutputStream("Joe_Bleau.bin");
		OutputStream bufOutStream = new BufferedOutputStream(fileOutStream);
		ObjectOutputStream objOutStream = new ObjectOutputStream(bufOutStream);
		for (Figure component : components) {
			objOutStream.writeObject(component);
		}
		objOutStream.close();
	}
	
	public boolean delete(Canvas canvasModel) {
		File file = new File("Joe_Bleau.bin");
		file.delete();
		return true;
	}
}
