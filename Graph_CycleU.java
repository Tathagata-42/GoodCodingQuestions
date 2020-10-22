package cycle_undirectedGraph;

import java.util.*;
class Graph_CycleU {
	
	static LinkedList<Integer>adj[];
	int V;
	Graph_CycleU(int v)
	{
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<>();
	}
	
	
	void addEdge(int s , int d)
	{
		adj[s].add(d);
		adj[d].add(s);
	}
	
	
	public boolean isCycle()
	{
		boolean vis[] = new boolean[V];
		Arrays.fill(vis, false);
		
		
		for(int i=0;i<V;i++)
		{
			if(!vis[i] && isCycleUtil(i,vis))
				return true;
			
		}
		
		return false;
		
		
		
	}
	
	
	
	public boolean isCycleUtil(int s , boolean[]vis)
	{
		int parent[] = new int[V];
		Arrays.fill(parent, -1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		
		while(!q.isEmpty())
		{
			int u = q.poll();
			
			for(int i =0;i<adj[u].size();i++)
			{
				int v =adj[u].get(i);
				if(!vis[v])
				{
					vis[v]=true;
					q.add(v);
					parent[v]=u;
				}
				else if(parent[u]!=v)
					return true;
				
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		
		Graph_CycleU g = new Graph_CycleU(4);
		
		g.addEdge(0	, 1);
		g.addEdge(1	, 2);
		g.addEdge(2	, 0);
		g.addEdge(2, 3);
		
		if(g.isCycle())
			System.out.println("Yes"); 
        else
            System.out.println("No"); 
		
		
		
		// TODO Auto-generated method stub

	}

}
