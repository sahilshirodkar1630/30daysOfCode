package Day6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class BreadthFirstSearch_Traversal {

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
		
		BFS(adjacencyList);
		
		
		
	}
	
	public static void BFS(ArrayList<ArrayList<Integer>> adjacencyList ) {
		
		boolean[] visited = new boolean[adjacencyList.size()];
		
		for(int i = 1;i<adjacencyList.size();i++) {
			
			if(!visited[i]) {
				
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(i);
				visited[i] = true;
				
			
				while(!queue.isEmpty()) {
					
					Integer frontnode = queue.remove();
					System.out.print(frontnode+" ");
					
					for(int j = 0;j<adjacencyList.get(frontnode).size();j++) {
						Integer val = adjacencyList.get(frontnode).get(j);
						
						if(!visited[val]) {
							queue.add(val);
							visited[val] = true;
						}
						
					}
				}
			}
			
			
		}
		
		
		
	}

}
