package Day9;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort_DFS {

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
		
		int[] ans = topologicalSortDFS(adjacencyList);
		
		for(int i : ans) {
			System.out.println(i+" ");
		}
		
	}

	private static int[] topologicalSortDFS(ArrayList<ArrayList<Integer>> adjacencyList) {
		int n = adjacencyList.size()-1;
		Stack<Integer> stack = new Stack<Integer>();
		
		boolean visited[] = new boolean[n];
		
		for(int i = 0;i<n;i++) {
			if(!visited[i]) {
				topologicalSortDFS(i,adjacencyList,stack,visited);
			}
		}
		int output[] = new int[n];
		int i = 0;
		while(!stack.isEmpty()) {
			output[i++] = stack.pop();
			
		}
		return output;
	}

	private static void topologicalSortDFS(int node, ArrayList<ArrayList<Integer>> adjacencyList, Stack<Integer> stack,
			boolean[] visited) {


		visited[node] = true;
		for(int i:adjacencyList.get(node)) {
			if(!visited[i]) {
				topologicalSortDFS(i, adjacencyList, stack, visited);
			}
		}
		stack.push(node);
	}

}
