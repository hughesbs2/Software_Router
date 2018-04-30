/*VirtualNetworkSimulation.java
 *Author: Elliot Shapiro & Brandon Hughes
 *Project:Software Router Sim
 *Class: CMSC 506 Networks and Communication
 *Created: 4/11/2013
 *Last edits: 4/24/2013
             4/30/2018
 */
 
 import java.util.HashMap;
 
 public class VirtualNetworkSimulation
 {
 	static int[][] adjMatrix = new int[9][9];
 	
 	static Node[] nodes = new Node[11];
 	
 	private static void makeLinks()
	{
		//edit these to add or remove links
 		adjMatrix[0][2]=adjMatrix[2][0]=1;
 		adjMatrix[1][3]=adjMatrix[3][1]=1;
 		adjMatrix[2][3]=adjMatrix[3][2]=1;
 		adjMatrix[2][4]=adjMatrix[4][2]=1;
 		adjMatrix[3][4]=adjMatrix[4][3]=1;
 		adjMatrix[4][5]=adjMatrix[5][4]=1;
 		adjMatrix[4][6]=adjMatrix[6][4]=1;
 		adjMatrix[5][7]=adjMatrix[7][5]=1;
 		adjMatrix[6][8]=adjMatrix[8][6]=1;
 		
 		PathAlgorithm.makeLinks(adjMatrix);
	}
	
	public static void makeNodes()
	{
		nodes[0] = new Client(0);
		nodes[1] = new Client(1);
		nodes[2] = new Router(2);
		nodes[3] = new Router(3);
		nodes[4] = new Router(4);
		nodes[5] = new Router(5);
		nodes[6] = new Router(6);
		
		HashMap<String,String> a = new HashMap<String,String>();
		a.put("hello","how are you?");
		a.put("talk to me in italian","bonjourno");
		nodes[7] = new Server(7,a);
		
		HashMap<String,String> b = new HashMap<String,String>();
		b.put("howdy","goodday");
		b.put("hola","como estas?");
		nodes[8] = new Server(8,b);
		
	}
	
	public static void sendPacket(int source, int destination, String message)
	{
		Packet packet = ((Client)nodes[source]).sendPacket(message, destination);
 		
 		int packetLocation = source;
 		while(true)
 		{
 			packetLocation = nodes[packetLocation].forwardPacket(packet);
 			if(packetLocation==packet.getDestinationAddress())
 			{
 				if(nodes[packetLocation] instanceof Server)
 				{
 					packet = ((Server)nodes[packetLocation]).processPacket(packet);	
 				}
 				if(nodes[packetLocation] instanceof Client)
 				{
 					((Client)nodes[packetLocation]).receivePacket(packet);
 					break;
 				}
 			}
 		}
	}
	
	public static void printRoutingTables()
	{
		for(int x=0;x<nodes.length;x++)
			if(nodes[x] != null)
				System.out.print(nodes[x].printRoutingTable());
	}
 	
 	public static void main(String[]args)
 	{
 		makeLinks();
 		makeNodes();
 		
		sendPacket(0,7,"hello");
		//sendPacket(1,8,"howdy");
		//sendPacket(0,8,"hola");
		//sendPacket(0,7,"talk to me in italian");
 		
 		printRoutingTables();
 	}
 }