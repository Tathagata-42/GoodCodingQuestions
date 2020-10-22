package dfs;

import java.util.*;

public class Graph_DFS {
	
	static LinkedList<Integer>adj[];
	int V;
	Graph_DFS(int v)
	{
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]= new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s , int d)
	{
		adj[s].add(d);
		adj[d].add(s);
	}
	
	public void DFS(int v)
	{
		boolean vis[] = new boolean[adj.length];
		Arrays.fill(vis, false);
		
		vis[v]=true;
		
		DFSUTIL(v,vis);
	}
	
	
	public void DFSUTIL(int v , boolean vis[])
	{
		
		
		if(vis[v]==true)
			System.out.println(v+" ");
		
		for(int n : adj[v])
		{
			if(vis[n]==false)
			{
				vis[n]=true;
				
				DFSUTIL(n,vis);
				
			}
		}
	}

	public static void main(String[] args) {
		
		int v=4;
		
		Graph_DFS g = new Graph_DFS(v);
		
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        
        g.DFS(2);
		// TODO Auto-generated method stub

	}

}
