package Day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparator<Pair> {
	int v;
	int weight;
	public Pair(int v,int weight) {
		this.v = v;
		this.weight = weight;
	}
	Pair(){
		
	}
	
	@Override
	public int compare(Pair p1, Pair p2) {
		// TODO Auto-generated method stub
		if(p1.weight < p2.weight) {
			return -1;
		}if(p1.weight > p2.weight) {
			return 1;
		}
		return 0;
	}
	
}
public class Dijkstras_Algorithm_ShortestPathInUndirectedGraphs {

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
			adjacencyList.get(dest).add(new Pair(dest, weight));
		
		}
		 
		dijkstraAlgorithm(adjacencyList,1);
	}

	private static void dijkstraAlgorithm(ArrayList<ArrayList<Pair>> adjacencyList,int src) {

		int n = adjacencyList.size();
		int dist[] = new int[n];
		dist[src]=0;
		
		for(int i = 0;i<n;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src]=0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n,new Pair());
		pq.add(new Pair(src,0));
		
		while(!pq.isEmpty()){
			Pair frontNode = pq.poll();
			
			for(Pair i : adjacencyList.get(frontNode.v)) {
				if(dist[frontNode.v]+ i.weight< dist[i.v]) {
					dist[i.v] = dist[frontNode.v] +i.weight;
					pq.add(new Pair(i.v,dist[i.v]));
				}
			}
			
		}
		
		for(int i = 0;i<n;i++) {
			System.out.print(dist[i]+" ");
		}
		
		
		
		
		
		
		
	}

}
