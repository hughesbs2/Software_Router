/*
Brandon Hughes and Elliot Shapiro
April 04, 2013
This class enables the representation of a network logically, 
*/

public class Node
{
	int IP_Address;
	RoutingTable routingTable;
	
	public Node(int IP)
	{
		IP_Address = IP;
		routingTable = new RoutingTable(IP);
	}
	
	public int forwardPacket(Packet packet)
	{
		int nextHop = routingTable.checkTable(packet);
		System.out.println("Node "+IP_Address+" forwarding packet to node "+nextHop+".");
		return nextHop;
	}
	
	public String printRoutingTable()
	{
		return routingTable.toString();
	}
}