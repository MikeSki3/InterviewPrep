package tutes;

import java.util.Scanner;

import tutes.util.ds.Graph;

public class ShortestDis {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int  q = in.nextInt();
		for(int i = 0; i < q; i++){
			Graph g = new Graph();
			int numNodes = in.nextInt();
			long edges = in.nextLong();
			for(int j = 0; j < edges; j++){
				int parent = in.nextInt();
				int child = in.nextInt();
				g.addEdge(parent, child);
			}
			int startNode = in.nextInt();
			for(int j = 1; j <= numNodes; j++){
				if(j != startNode)
					System.out.print(g.findConnection(startNode, j) + " ");
			}
			System.out.println();
		}
	}

}
