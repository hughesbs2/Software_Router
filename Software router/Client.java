/*
Brandon Hughes and Elliot Shapiro
April 04, 2013
This class represents the vitual clients of the network.
*/

public class Client extends Node
{
	public Client(int ip)
 	{
 		super(ip);
 	}
 	
 	public Packet sendPacket(String message, int dest)
 	{
 		System.out.println("Sending packet from client "+IP_Address+" to server "+dest+".");
 		Packet packet = new Packet(IP_Address, dest, message);
 		return packet;
 	}
 	
 	public void receivePacket(Packet packet)
 	{
 		System.out.println("Packet received back from server! msg: "+packet.getPayload());
 	}
}

class Webcache extends Client
{
	public Webcache(int ip)
	{
		super(ip);
	}	
}