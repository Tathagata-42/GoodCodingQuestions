package knight_steps;

import java.util.*;

public class Knight {
	
	static class cell
	{
		int x , y,dis;
		public cell(int x , int y , int dis)
		{
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
	}
	
	
	static boolean isInside(int x , int y , int N)
	{
		
		return(x>=1 && x<=N && y>=1 && y<=N);
		
	}
	
	public static int misStep(int knightPos[] , int targetPos[] , int N)
	{
		int dx[] = {-2,-1,1,2,-2,-1,1,2};
		int dy[] = {-1,-2,-2,-1,1,2,2,1};
		
		Vector<cell> q = new Vector<cell>();
		q.add(new cell(knightPos[0],knightPos[1],0));
		
		cell  t;
		int x ,  y;
		
		boolean vis[][] = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=N;j++)
			{
				vis[i][j]=false;
			}
		}
		
		vis[knightPos[0]][knightPos[1]]=true;
		
		while(!q.isEmpty())
		{
			t=q.firstElement();
			q.remove(0);
			if(t.x==targetPos[0] && t.y==targetPos[1])
				return t.dis;
			
			for(int i=0;i<8;i++)
			{
				x=t.x+dx[i];
				y=t.y+dy[i];
				
				if(isInside(x,y,N) && !vis[x][y])
				{
					vis[x][y]=true;
					q.add(new cell(x,y,t.dis+1));
					
				}
			}
			
		}
		
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		

        int N = 30; 
        int knightPos[] = { 1, 1 }; 
        int targetPos[] = { 30, 30 };
        
        System.out.print(misStep(knightPos,targetPos,N));
		// TODO Auto-generated method stub

	}

}
