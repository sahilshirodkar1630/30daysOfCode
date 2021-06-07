package Day7;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetectionInUndirectedGraph_DFS {

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
		
		System.out.println(isCycleDFS(adjacencyList));
	}

	private static boolean isCycleDFS(ArrayList<ArrayList<Integer>> adjacencyList) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[adjacencyList.size()];
		
		for(int i=0;i<adjacencyList.size();i++) {
			if(!visited[i]) {
				if(isCycle(i,-1,adjacencyList,visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isCycle(int node,int prev, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
		// TODO Auto-generated method stub
		if(visited[node]) {
			if(node!=prev) {
				return true;
			}
		}
		
		visited[node] = true;
		
		for(Integer i : adjacencyList.get(node)) {
			
				if(i!=prev) {
					if(isCycle(i,node, adjacencyList, visited)) {
						return true;
					}
				}
			
		}
		return false;
	}

}
