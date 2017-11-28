package main;

import java.util.ArrayList;
import java.util.List;

public class GraphColoringState implements State {

	int numNodes;
	int currentNode;
	List<String> colors;
	List<String> currentState;
	boolean[][] connections;
	
	/**
	 * Constructor for the initial state based on parameters passed in from main
	 * @param numNodes How many nodes are there to color
	 * @param currentNode Start at 0
	 * @param colors List of colors we can use to color the graph
	 * @param connections 2D array of boolean values used to indicate connections of the nodes
	 */
	public GraphColoringState(int numNodes, List<String> colors, boolean[][] connections, List<String> currentState) {
		this.numNodes = numNodes;
		this.currentNode = 0;
		this.colors = colors;
		this.connections = connections;
		this.currentState = currentState;
	}
	
	/**
	 * Constructor for a state based on the parent state
	 * @param gcs Parent state
	 */
	public GraphColoringState(GraphColoringState gcs) {
		//Shallow copy
		this.numNodes = gcs.numNodes;
		this.currentNode = gcs.currentNode;
		this.colors = gcs.colors;
		this.connections = gcs.connections;
		//Deep copy
		this.currentState = new ArrayList<String>(connections.length);
		for(String color : gcs.currentState) {
			this.currentState.add(color);
		}
	}
	
	/**
	 * Whether or not the current state has more children
	 */
	@Override
	public boolean hasMoreChildren() {
		return currentNode < numNodes;
	}
	
	/**
	 * TODO THIS
	 * Creates the next child state
	 */
	@Override
	public State nextChild() {
		GraphColoringState child = new GraphColoringState(this);	//Copy the parent
		child.currentNode = this.currentNode + 1;					//Update the node we are manipulating
//		child.currentState.get(child.currentNode) = 				//Cycle the color to the next option
		return child;
	}
	
	/**
	 * If the move would follow all the rules of not allowing adjacent colors
	 */
	@Override
	public boolean isFeasible() {
		boolean feasible = true;
		String currentColor = this.currentState.get(currentNode);
		boolean[] nodeConnections = this.connections[this.currentNode];	//Grab the connections for our node
		for (int i = 0; i<nodeConnections.length; i++) {
			if(nodeConnections[i]) {
				if(currentState.get(i).equals(currentColor)) {			//If a node we have a connection to has the same color as our own, it will not work
					feasible = false;
				}
			}
		}
		return feasible;
	}
	
	/**
	 * If the current state is complete
	 */
	@Override
	public boolean isSolved() {
		return numNodes==currentNode;
	}
	
	/**
	 * 
	 */
	@Override
	public int getBound() {
		return -1;
	}
}
