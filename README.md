# Project Java INF112 Thomas Lucereau 

<h1>Robot Simulator – Java Project</h1>

<p>
This project implements a <b>factory simulation</b> where robots move between rooms, machines, and charging stations. 
It is based on the <code>fr.tp.inf112.projects.canvas</code> framework, which provides a model–view–controller (MVC) architecture 
to define graphical elements, manage persistence, and animate the simulation.
</p>

<h2>Overview</h2>
<ul>
  <li>Create a virtual <b>factory</b> with rooms, production zones, machines, charging stations, and doors.</li>
  <li>Add a <b>robot</b> capable of navigating the factory using a <code>BasicPathFinder</code>.</li>
  <li>Simulate the robot’s tasks: visiting machines, charging stations, and production zones.</li>
  <li>Visualize the simulation in a graphical window with styles (colors, strokes, patterns).</li>
</ul>

<h2>Key Features</h2>
<ul>
  <li><b>Factory initialization</b>: sets up the layout with a defined size, name, and style.</li>
  <li><b>Rooms</b>: rectangular areas representing different factory sections.</li>
  <li><b>Production zones</b>: marked areas where items can be processed.</li>
  <li><b>Machines</b>: equipment that robots must visit in sequence.</li>
  <li><b>Charging station</b>: a place where robots recharge their energy.</li>
  <li><b>Doors</b>: connections between rooms and zones.</li>
  <li><b>Robot</b>: small oval-shaped agent with energy and pathfinding capabilities.</li>
  <li><b>Persistence</b>: save/load factory layouts using <code>CanvasPersistenceManager</code>.</li>
  <li><b>Animation</b>: the controller runs the simulation in a graphical viewer.</li>
</ul>

<h2>Execution Flow</h2>
<ol>
  <li>Define colors, strokes, and display styles for all graphical components.</li>
  <li>Create the factory and add rooms, zones, machines, charging stations, and doors.</li>
  <li>Add a robot with a <code>BasicPathFinder</code>.</li>
  <li>Assign tasks to the robot (visit machines, then charging station).</li>
  <li>Start the simulation using a <code>CanvasViewerController</code>, which launches the animation in a window.</li>
</ol>

<h2>Build & Run</h2>
<p>
Compile and run the <code>SimulatorApplication</code> class:
</p>
<pre>
javac -d bin src/robotsim/app/SimulatorApplication.java
java -cp bin robotsim.app.SimulatorApplication
</pre>

<h2>Logging</h2>
<p>
The application uses <code>java.util.logging.Logger</code> to log startup information and simulation parameters.
</p>

<h2>Next Steps</h2>
<ul>
  <li>Implement advanced pathfinding algorithms.</li>
  <li>Allow multiple robots with different tasks.</li>
  <li>Enhance the GUI with interactive controls to add/remove components dynamically.</li>
</ul>
