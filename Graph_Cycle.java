package cycle_directedGraph;

import java.util.*;

public class Graph_Cycle {
	
	static LinkedList<Integer>adj[];
	int V;
	Graph_Cycle(int v)
	{
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
			adj[i]=new LinkedList<>();
	}
	
	
	void addEdge(int s , int d)
	{
		adj[s].add(d);
	}
	
	
	public boolean isCyclic()
	{
		boolean vis[] = new boolean[adj.length];
		boolean recstack[] = new boolean[adj.length];
		
		Arrays.fill(vis, false);
		Arrays.fill(recstack, false);
		
		for(int i=0;i<V;i++)
		{
			if(isCyclicUtil(i,vis,recstack))
				return true;
		}
		
		return false;
	}
	
	
	public boolean isCyclicUtil(int i , boolean vis[] , boolean recstack[])
	{
		if(recstack[i])
			return true;
		if(vis[i])
			return false;
		
		recstack[i]=true;
		vis[i]=true;
		
		List<Integer>children = adj[i];
		
		for(int n : children)
		{
			if(isCyclicUtil(n,vis,recstack))
				return true;
		}
		
		recstack[i]=false;
		return false;
		
	}

	public static void main(String[] args) {
		
		Graph_Cycle graph = new Graph_Cycle(4);
		graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3);
        
        if(graph.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
		// TODO Auto-generated method stub

	}

}
