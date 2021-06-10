package Day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInUndirectedGraphwithUnitWeights {

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
		
		shortedtPath(adjacencyList,0);
	}

	private static void shortedtPath(ArrayList<ArrayList<Integer>> adjacencyList, int src) {
		
		int n = adjacencyList.size();
		int[] distance = new int[n-1];
		
		for(int i = 0;i<n-1;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		distance[src] = 0;
		queue.add(src);
		
		
		while(!queue.isEmpty()) {
			Integer frontNode = queue.remove();
			for(int i : adjacencyList.get(frontNode)) {
				
				if(distance[frontNode]+1<distance[i]) {
					distance[i] = distance[frontNode]+1;
					queue.add(i);
				}
			}
		}
		
		for(int i =0;i<n-1;i++) {
			System.out.println(i+" "+distance[i]);
		}
		
	}

}
