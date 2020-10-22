package create_a_graph;

import java.util.*;

public class Graph {
	
	
	static LinkedList<Integer>adj[];
	int V;
	
	public Graph(int v)
	{
		V=v;
		
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s , int d)
	{
		adj[s].add(d);
		adj[d].add(s);
	}
	
	static void printGraph(LinkedList<Integer>adj[])
	{
		 for (int i = 0; i < adj.length; i++) { 
	            System.out.println("\nAdjacency list of vertex" + i); 
	            System.out.print("head"); 
	            for (int j = 0; j < adj[i].size(); j++) { 
	                System.out.print(" -> "+adj[i].get(j)); 
	            } 
	            System.out.println(); 
	        }
	}
	
	
	
	
	public static void main(String[] args)
	{
		int v=5;
		
		Graph g = new Graph(v);
		
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		
		g.printGraph(adj);
		
	}

}
