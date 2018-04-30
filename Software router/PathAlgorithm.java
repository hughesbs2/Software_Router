/*PathAlgorithm.java
 *Author: Elliot Shapiro & Brandon Hughes
 *Project:Software Router Sim
 *Class: CMSC 506 Networks and Communication
 *Created: 4/23/2013
 *Last edit: 4/23/2013
 */

import java.util.ArrayList;

public class PathAlgorithm
{	
	public static int[][]links;
	
	public static void makeLinks(int[][] l)
	{
		links = new int[l.length][l[0].length];
		for(int x=0;x<l.length;x++)
			for(int y=0;y<l[0].length;y++)
				links[x][y] = l[x][y];
	}
	
	public static int[] nextNode(int location, int destination)
	{
		ArrayList<Integer> path = pathAlgorithm(location, destination, new ArrayList<Integer>());
		int[] returnArray = new int[2];
		returnArray[0] = path.get(1);
		returnArray[1] = path.size()-1; 
		return returnArray;
	}
	
	public static ArrayList<Integer> pathAlgorithm(int location, int destination, ArrayList<Integer> path)
	{
		path.add(location);
		if(location==destination)
		{
			return path;
		}
		else
		{
			ArrayList<Integer>[] branches = new ArrayList[links.length];
			int shortestPath = -1;
			int shortestPathLength = -1;
			for(int x=0;x<branches.length;x++)
			{
				if(!path.contains(x) && links[location][x]==1)
				{
					branches[x] = pathAlgorithm(x, destination, new ArrayList<Integer>(path));
					if(branches[x]!=null && (branches[x].size()<shortestPathLength || shortestPathLength==-1))
					{
						shortestPath = x;
						shortestPathLength = branches[x].size();
					}
				}
			}
			
			/*System.out.println("Possible paths from node "+location);
			for(int x=0;x<branches.length;x++)
				if(branches[x]!=null)
					System.out.println(branches[x]);*/
			
			if(shortestPath!=-1)
				return branches[shortestPath];
			else
				return null;
		}		
	}
	
	public static void main(String[]args)
	{
		int[][] links = new int[9][9];
		
		links[0][2]=links[2][0]=1;
 		links[1][3]=links[3][1]=1;
 		links[2][3]=links[3][2]=1;
 		links[2][4]=links[4][2]=1;
 		links[3][4]=links[4][3]=1;
 		links[4][5]=links[5][4]=1;
 		links[4][6]=links[6][4]=1;
 		links[5][7]=links[7][5]=1;
 		links[6][8]=links[8][6]=1;
 		
 		makeLinks(links);
 		
 		System.out.println(PathAlgorithm.pathAlgorithm(2,6,new ArrayList<Integer>()));
	}
}