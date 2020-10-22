package bfs;

import java.util.*;

public class Graph_BFS {
	
	static LinkedList<Integer>adj[];
	
	int V;
	public Graph_BFS(int v)
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
	
	
	public void BFS(int s)
	{
		boolean vis[] = new boolean[adj.length];
		Queue<Integer>q = new LinkedList<Integer>();
		 q.add(s);
		 
		 vis[s]=true;
		 while(!q.isEmpty())
		 {
			 int cur =q.poll();
			 for(int n : adj[cur])
			 {
				 if(!vis[n])
				 {
					 vis[n]=true;
					 q.add(n);
					 System.out.println(n+" ");
				 }
			 }
		 }
		 
	}
	

	public static void main(String[] args) {
		
		int v=5;
		Graph_BFS g = new Graph_BFS(v);
		
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		
		g.BFS(0);
		
		// TODO Auto-generated method stub

	}

}
