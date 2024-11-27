package robotsim.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.*;
import org.jgrapht.alg.shortestpath.*;
import org.jgrapht.graph.*;


public class BasicPathFinder implements FactoryPathFinder {

	Factory factory;
	
	BasicVertex[][] listPosToVertex;
	
	Graph<BasicVertex, DefaultEdge> graphRepresentation;	//Graph representation of the factory

	public BasicPathFinder(Factory factory) {

		super();
		this.factory = factory;
		this.listPosToVertex = new BasicVertex[factory.getWidth()][factory.getHeight()];
		this.graphRepresentation = new DefaultUndirectedGraph<BasicVertex, DefaultEdge>(DefaultEdge.class);
		
		int xMax = factory.getWidth()-1;
		int yMax = factory.getHeight()-1;
		
		for (int x = 0; x <= xMax ; x++) {
			for (int y = 0; y <= yMax; y++) {
				BasicVertex vertex = new BasicVertex(x,y);
				listPosToVertex[x][y] = vertex;
				graphRepresentation.addVertex(vertex);
			}
		}
		
		for (int x = 1; x <= xMax - 1 ; x++) {	//top line without the corners
			int y = 0;
			BasicVertex vertex = listPosToVertex[x][y];
			if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[x-1][y]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x+1][y]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x][y+1]);
			}

		}

		for (int x = 1; x <= xMax - 1 ; x++) {	//bottom line without the corners
			int y = yMax;
			BasicVertex vertex = listPosToVertex[x][y];
			if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[x-1][y]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x+1][y]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x][y-1]);
			}

		}

		for (int y = 1; y <= yMax - 1 ; y++) {	//left side without the corners
			int x = 0;
			BasicVertex vertex = listPosToVertex[x][y];
			if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[x][y-1]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x][y+1]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x+1][y]);
			}

		}
		
		for (int y = 1; y <= yMax -1 ; y++) {	//right side without the corners
			int x = xMax;
			BasicVertex vertex = listPosToVertex[x][y];
			if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[x][y-1]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x][y+1]);
				graphRepresentation.addEdge(vertex, listPosToVertex[x-1][y]);
			}
			
		}
		
		for (int x = 1; x <= xMax - 1 ; x++) {	//every inside corners
			for (int y = 1; y <= xMax - 1 ; y++) {
				BasicVertex vertex = listPosToVertex[x][y];
				if (!factory.isChevauching(vertex)){
					graphRepresentation.addEdge(vertex, listPosToVertex[x][y-1]);
					graphRepresentation.addEdge(vertex, listPosToVertex[x+1][y]);
					graphRepresentation.addEdge(vertex, listPosToVertex[x][y+1]);
					graphRepresentation.addEdge(vertex, listPosToVertex[x-1][y]);
				}

			}
		}
		
		BasicVertex vertex = listPosToVertex[0][0];	//top-left corner
		if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[1][0]);
				graphRepresentation.addEdge(vertex, listPosToVertex[0][1]);
		}


		
		vertex = listPosToVertex[xMax][0];	//top-right corner
		if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[xMax-1][0]);
				graphRepresentation.addEdge(vertex, listPosToVertex[xMax][1]);
		}

		
		vertex = listPosToVertex[xMax][yMax];	//bottom-right corner
		if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[xMax][yMax-1]);
				graphRepresentation.addEdge(vertex, listPosToVertex[xMax-1][yMax]);
		}


		vertex = listPosToVertex[0][yMax];	//bottom-left corner
		if (!factory.isChevauching(vertex)){
				graphRepresentation.addEdge(vertex, listPosToVertex[0][yMax-1]);
				graphRepresentation.addEdge(vertex, listPosToVertex[1][yMax]);
		}

		
		System.out.println(graphRepresentation);
	}

	public List<Position> findPath(Component sourceComponent, Component targetComponent) {
		
		BasicVertex vertexSourceComponent = listPosToVertex[sourceComponent.getxCoordinate()][sourceComponent.getyCoordinate()];
		BasicVertex vertexTargetComponent = listPosToVertex[targetComponent.getxCoordinate()][targetComponent.getyCoordinate()];

		DijkstraShortestPath<BasicVertex, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<BasicVertex, DefaultEdge>(graphRepresentation);
        SingleSourcePaths<BasicVertex, DefaultEdge> sourcePaths = dijkstraAlg.getPaths(vertexSourceComponent);
        GraphPath<BasicVertex, DefaultEdge> graphPath = sourcePaths.getPath(vertexTargetComponent);
        
        if (graphPath == null) {
        	return null;
        }
        else {
    		List<Position> positionPath = new ArrayList<Position>();
    		
    		List<BasicVertex> vertexList = graphPath.getVertexList();
    		

    		for (BasicVertex vertex : vertexList) {
    			positionPath.add(vertex.getPosition());
    		}
    		
    		return positionPath;
        }

		


	}

}
