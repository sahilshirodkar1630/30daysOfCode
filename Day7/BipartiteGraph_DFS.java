package Day7;

import java.util.ArrayList;
import java.util.Scanner;

public class BipartiteGraph_DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int numberOfVertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<numberOfVertices+1;i++) {
			adjacencyList.add(new ArrayList<>());
		}
		int numberOfEdges = sc.nextInt();
		for(int i=0;i<numberOfEdges;i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			
			adjacencyList.get(source).add(dest);
			adjacencyList.get(dest).add(source);
		
		}
		
		System.out.println(isBipartite(adjacencyList));
	}

	private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjacencyList) {
		
		int n = adjacencyList.size();
		int[] color = new int[n];
		
		for(int i = 0;i<n;i++) {
			color[i] = -1;
		}
		
		for(int i = 0;i<n;i++) {
			if(color[i]== -1) {
				boolean ans = isBipartiteDFS(i,adjacencyList,color);
				
				if(!ans) {
					return false;
				}
			}
		}
		
		return true;
	}


	private static boolean isBipartiteDFS(int node, ArrayList<ArrayList<Integer>> adjacencyList, int[] color) {
		// TODO Auto-generated method stub
		
		if(color[node] ==-1) {
			color[node] = 1;
		}
		
		for(int i :adjacencyList.get(node)) {
			if(color[i] == -1) {
				color[i] = 1-color[node];
				if(!isBipartiteDFS(i, adjacencyList, color)) {
					return false;
				}
			}else if(color[i] == color[node]){
				return false;
				
			}
		}
		
		
		return true;
	}
}
