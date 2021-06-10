package Day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionInDirectedGraph_BFS_KahnsAlgorithm {

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
		
		System.out.println(isCycleDirectedBFS(adjacencyList));
	}
	
	private static boolean isCycleDirectedBFS(ArrayList<ArrayList<Integer>> adjacencyList) {
		// TODO Auto-generated method stub
		int[] indegree = new int[adjacencyList.size()];
		
		for(int i = 0;i<adjacencyList.size();i++) {
			for(int j : adjacencyList.get(i)) {
				indegree[j]++;
			}
		}
		
		Queue<Integer> queue= new LinkedList<Integer>();
		for(int i =0;i<adjacencyList.size();i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		int count=0;
		while(!queue.isEmpty()) {
			Integer frontNode = queue.poll();
			count++;
			for(int i : adjacencyList.get(frontNode)) {
				indegree[i]--;
				if(indegree[i]==0) {
					queue.add(i);
				}
			}
		}
		if(count == adjacencyList.size()) return false;
		return true;
	}

}
