package Day9;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetectionInDirectedGraph_DFS {

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
			
		
		}
		
		System.out.println(isCycleDirectedDFS(adjacencyList));
	}

	private static boolean isCycleDirectedDFS(ArrayList<ArrayList<Integer>> adjacencyList) {
		// TODO Auto-generated method stub
		int n = adjacencyList.size();
		boolean visited[] = new boolean[n];
		
		boolean dfsVisited[] = new boolean[n];
		
		for(int i = 0;i < n; i++) {
			if(!visited[i]) {			
				if(isCycleDirectedDFS(i,adjacencyList,visited,dfsVisited)) {
					return true;
				}
			}
			
		}
		
		return false;
	}

	private static boolean isCycleDirectedDFS(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited,
			boolean[] dfsVisited) {
		
		visited[node] = true;
		dfsVisited[node] = true;
		
		for(int i : adjacencyList.get(node) ) {
			if(!visited[i]) {
				if(isCycleDirectedDFS(i, adjacencyList, visited, dfsVisited)) {
					return true;
				}
			}else if(dfsVisited[i]) {
				return true;
				
			}
			
		}
		dfsVisited[node] = false;
		
		return false;
	}

}
