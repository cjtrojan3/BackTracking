package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		BacktrackerIterative bt = new BacktrackerIterative();
//		State s = new NQueensState(4);
//		State result = bt.backtrack(s);
//		System.out.println(result);
		
		
		List<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		
		boolean[][] graph = 
			{{false, true, false, false, false, true},
			 {true, false, true, false, false, true},
			 {false, true, false, true, true, false},
			 {false, false, true, false, true, false},
			 {false, false, true, true, false, true},
			 {true, true, false, false, true, false}};
		
		State s = new GraphColoringState(6, colors, graph);
		State result = bt.backtrack(s);
		
	}

}
