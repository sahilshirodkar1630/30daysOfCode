package Day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort_BFS_KahnAlgorithm {

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
		
		int[] ans = topologicalSortBFS(adjacencyList);
		
		for(int i : ans) {
			System.out.println(i+" ");
		}
		
	}

	private static int[] topologicalSortBFS(ArrayList<ArrayList<Integer>> adjacencyList) {
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
		
		int topo[] = new int[adjacencyList.size()];
		int index=0;
		while(!queue.isEmpty()) {
			Integer frontNode =queue.remove();
			topo[index++] = frontNode;
			
			for(int i: adjacencyList.get(frontNode)) {
				indegree[i]--;
				if(indegree[i]==0) {
					queue.add(i);
				}
			}
		}
		return topo;
	}

}
