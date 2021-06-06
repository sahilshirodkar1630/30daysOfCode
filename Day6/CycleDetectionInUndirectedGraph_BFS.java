package Day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionInUndirectedGraph_BFS {

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
		
		System.out.println(isCycle(adjacencyList));
		
	}

	private static boolean isCycle(ArrayList<ArrayList<Integer>> adjacencyList) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[adjacencyList.size()];
		
		for(int i=0;i<adjacencyList.size();i++) {
			if(!visited[i]) {
				if(isCycle(i,adjacencyList,visited)) {
					return true;
				}
			}
		}
		return false;
		
	}

	private static boolean isCycle(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Integer frontNode = queue.remove();
			if(visited[frontNode]) {
				return true;
			}
			visited[frontNode] = true;
			
			for(Integer i : adjacencyList.get(frontNode)) {
				
				if(!visited[i]) {
					queue.add(i);
				}
			}
			
		}
		return false;
	}

}
