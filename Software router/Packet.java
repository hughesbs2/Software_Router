/*
Brandon Hughes and Elliot Shapiro
April 23, 2013
This class represents a packet being sent through the network.
*/

public class Packet
{
	private int sourceAddress;
	private int destinationAddress;
	private String payload;

	public Packet(int s, int d, String msg)
	{
		sourceAddress = s;
		destinationAddress = d;
		payload = msg;
	}
	
	public int getSourceAddress()
	{
		return sourceAddress;
	}
	
	public int getDestinationAddress()
	{
		return destinationAddress;
	}
	
	public String getPayload()
	{
		return payload;
	}
}