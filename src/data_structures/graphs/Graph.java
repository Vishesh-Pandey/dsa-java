package data_structures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
	
	static class Edge{
		int src; 
		int dest;
		int wt;
		
		public Edge(int src , int dest , int wt) {
			this.src = src ; 
			this.dest = dest ; 
			this.wt = wt ;
		}
		
		public String toString() {
			return "{" + this.src + "," + this.dest + "}" ;
		}
	}
	
	public static void dfs(ArrayList<Edge> graph[] , int current, boolean[] vis) {
		
		System.out.print(current + "  ");
		
		vis[current] = true ; 
		
		for ( int i = 0  ; i < graph[current].size(); i++ ) {
			Edge e = graph[current].get(i);
			if ( vis[e.dest]== false) {
				dfs(graph , e.dest , vis);
			}
		}
		
	}
	
	public static void bfs(ArrayList<Edge> graph[]) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		boolean[] vis = new boolean[graph.length];
		
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if (vis[current] == false) {
				System.out.print(current + "  ");
				vis[current] = true ; 
				
				for ( int i = 0 ; i < graph[current].size(); i++ ) {
					Edge e = graph[current].get(i);
					queue.add(e.dest);
				}
			}
		}	
	}
	
	static class Pair implements Comparable<Pair>{
		int n;
		int d;
		
		public Pair(int n , int d) {
			this.n = n ; 
			this.d = d ;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}
	
	public static void dijkstra(ArrayList<Edge> graph[]) {
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		boolean[] vis = new boolean[graph.length];
		
		int[] dis = new int[graph.length]; 
		
		for (int i = 0 ; i < graph.length ; i++ ) {
			dis[i] = Integer.MAX_VALUE;
		}
		
		dis[0] = 0 ; 
		
		pq.add(new Pair(0,0));
		
		while(!pq.isEmpty()) {
			Pair current = pq.poll();
			if ( vis[current.n] == false ) {
				for ( int i = 0 ; i < graph[current.n].size();i++) {
					Edge e = graph[current.n].get(i);
					int u = e.src;
					int v = e.dest;
					if ( dis[u] + e.wt < dis[v]) {
						dis[v] = dis[u] + e.wt ; 
						pq.add(new Pair(v , dis[v]));
					}
				}
			}
			// otherwise it is already visited 
		}
		
		for (int i = 0 ; i < dis.length ; i++ ) {
			System.out.print(dis[i] + "  ");
		}
		
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for ( int i =0 ; i < graph.length ; i++ ) {
			graph[i] = new ArrayList();
		}
		
		graph[0].add(new Edge(0,1,1));
		graph[0].add(new Edge(0,2,3));
		
		graph[1].add(new Edge(1,2,1));
		graph[1].add(new Edge(1,3,5));

		graph[2].add(new Edge(2,4,2));
		
		graph[3].add(new Edge(3,5,3));
		
		graph[4].add(new Edge(4,3,2));
		graph[4].add(new Edge(4,5,5));
		
	}
	
	public static void neighbours(ArrayList<Edge> graph[]) {
		for ( int i = 0 ; i < graph.length ; i++ ) {
			System.out.print("Neigbours of " + i + " : " );
			for ( int j = 0 ; j < graph[i].size(); j++ ) {
				Edge e = graph[i].get(j);
				System.out.print(e.dest + " ,");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		int v = 6 ; 
		ArrayList<Edge>[] graph = new ArrayList[v];
		createGraph(graph);
		
		System.out.println("Graph Edges : ");
		for ( int i = 0 ; i < graph.length ; i++ ) {			
			System.out.println(graph[i]);
		}
		
		System.out.println("\nNeigbours : ");
		neighbours(graph);
		
		System.out.print("\nDFS : ");
		boolean[] vis = new boolean[v] ; 	
		dfs(graph , 0 , vis);
		
		System.out.print("\nBFS : ");
		bfs(graph);
		
		System.out.println("\nShortest path - Dijkstra : ");
		dijkstra(graph);
	
	}

}
