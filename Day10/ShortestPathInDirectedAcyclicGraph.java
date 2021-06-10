package Day10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//class Pair {
//	int v;
//	int weight;
//	public Pair(int v,int weight) {
//		this.v = v;
//		this.weight = weight;
//	}
//	
//	
//}
public class ShortestPathInDirectedAcyclicGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = new Scanner(System.in);
		int numberOfVertices = sc.nextInt();
		ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<ArrayList<Pair>>();
		
		for(int i=0;i<numberOfVertices+1;i++) {
			
			adjacencyList.add(new ArrayList<>());
			
		}
		int numberOfEdges = sc.nextInt();
		for(int i=0;i<numberOfEdges;i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			int weight = sc.nextInt();
			adjacencyList.get(source).add(new Pair(dest, weight));
//			adjacencyList.get(dest).add(new Pair(dest, weight));
		
		}
		 
		shortedtPath(adjacencyList,0);
	}

	private static void shortedtPath(ArrayList<ArrayList<Pair>> adjacencyList, int src) {
	
		int n = adjacencyList.size()-1;
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[n];
		
		for(int i = 0;i<n;i++) {
			if(!visited[i]) {
				topologicalSort(i,adjacencyList,visited,stack);
			}
		}
		
		
		int[] distance = new int[n];
		
		for(int i = 0;i<n;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[src] = 0;
		
		while(!stack.isEmpty()) {
			
			int frontNode = stack.pop();
			
			if(distance[frontNode]!=Integer.MAX_VALUE) {
				
				for(Pair i : adjacencyList.get(frontNode)) {
					if(distance[frontNode] + i.weight < distance[i.v]) {
						distance[i.v] = distance[frontNode] + i.weight;
					}
				}
				
			}
		}
		for(int i = 0;i<n;i++) {
			System.out.print(distance[i]+" ");
		}
		
		
	}

	private static void topologicalSort(int node, ArrayList<ArrayList<Pair>> adjacencyList, boolean[] visited,
			Stack<Integer> stack) {
		
		visited[node] = true;
		for(Pair i :adjacencyList.get(node) ) {
			if(!visited[i.v]) {
				topologicalSort(i.v, adjacencyList, visited, stack);
			}
		}
		stack.push(node);
		
	}
	


}
