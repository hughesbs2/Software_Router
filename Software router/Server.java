/*
Brandon Hughes and Elliot Shapiro
April 04, 2013
This class represents the vitual servers of the network.
*/

import java.util.HashMap;

public class Server extends Node
{
	HashMap<String,String> functions;
	
	public Server(int ip, HashMap<String,String> f)
 	{
 		super(ip);
 		functions = f;
 	}
 
	public Packet processPacket(Packet packet)
	{
		System.out.println("Packet received at server "+IP_Address+". msg: "+packet.getPayload());
		System.out.println("Sending packet back to client "+packet.getSourceAddress()+".");
		return new Packet(IP_Address, packet.getSourceAddress(), functions.get(packet.getPayload()));
	}
}