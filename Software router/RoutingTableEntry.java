//Brandon Hughes and Elliot Shapiro
//April 23, 2013
//

public class RoutingTableEntry
{
	private int sourceAddress, destinationAddress, nextHopAddress, hops_to_dest, num_of_requests;
	
	public RoutingTableEntry(int s, int d, int n, int dist)
	{
		 sourceAddress = s;
		 destinationAddress = d;
		 nextHopAddress = n;
		 hops_to_dest = dist;
		 num_of_requests = 1;
	}

	public int getSourceAddress()
	{
		return sourceAddress;
	}
	
	public int getDestinationAddress()
	{
		return destinationAddress;
	}

	public int getNextHop()
	{
		return nextHopAddress;
	}
	
	public int getDistance()
	{
		return hops_to_dest;
	}
	
	public int getQuantity()
	{
		return num_of_requests;
	}
	
	public void duplicate()
	{
		num_of_requests++;
	}
	
	public boolean exists(int source, int dest)
	{
		return (source==sourceAddress && dest==destinationAddress);
	}
	
	public String toString()
	{
		return "source IP: "+sourceAddress+" dest IP: "+destinationAddress+" next hop: "+nextHopAddress+" dist: "+hops_to_dest+" num of requests: "+num_of_requests;
	}
} 