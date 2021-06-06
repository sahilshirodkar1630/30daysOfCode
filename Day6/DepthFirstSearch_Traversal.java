package Day6;

import java.util.ArrayList;
import java.util.Scanner;

public class DepthFirstSearch_Traversal {

	public static void main(String[] args) {

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
		DFS(adjacencyList);
		
	}
	
	
	public static void DFS(ArrayList<ArrayList<Integer>> adjacencyList) {
		
	 boolean visited[] = new boolean[adjacencyList.size()];
	 
	 for(int i = 1;i< adjacencyList.size();i++) {
		 if(!visited[i]) {
			 dfsTraversal(i,adjacencyList,visited);
		 }
	 }
	 
	}


	private static void dfsTraversal(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
		// TODO Auto-generated method stub
		
		System.out.print(node+" ");
		visited[node] = true;
		
		for(Integer i : adjacencyList.get(node)) {
			if(!visited[i]) {
				dfsTraversal(i, adjacencyList, visited);
			}
		}
		
	}

}
