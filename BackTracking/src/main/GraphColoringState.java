package main;

import java.util.List;

public class GraphColoringState implements State {

	int numNodes;
	int currentNode;
	List<String> colors;
	boolean[][] connections;
	
	/**
	 * Constructor for the initial state based on parameters passed in from main
	 * @param numNodes How many nodes are there to color
	 * @param currentNode Start at 0
	 * @param colors List of colors we can use to color the graph
	 * @param connections 2D array of boolean values used to indicate connections of the nodes
	 */
	public GraphColoringState(int numNodes, List<String> colors, boolean[][] connections) {
		this.numNodes = numNodes;
		this.currentNode = 0;
		this.colors = colors;
		this.connections = connections;
	}
	
	/**
	 * Constructor for a state based on the parent state
	 * @param gcs Parent state
	 */
	public GraphColoringState(GraphColoringState gcs) {
		this.numNodes = gcs.numNodes;
		this.currentNode = gcs.currentNode;
		this.colors = gcs.colors;
		this.connections = gcs.connections;
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
		GraphColoringState child = new GraphColoringState(this);	//Shallow copy
		return null;
	}
	
	/**
	 * TODO THIS
	 * If the move would follow all the rules of not allowing adjacent colors
	 */
	@Override
	public boolean isFeasible() {
		return false;
	}
	
	/**
	 * If the current state is complete
	 */
	@Override
	public boolean isSolved() {
		return numNodes==currentNode;
	}
	
	/**
	 * TODO THIS
	 * Lol fuck if I know
	 */
	@Override
	public int getBound() {
		return -1;
	}
}
