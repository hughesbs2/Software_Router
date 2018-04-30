//Brandon Hughes and Elliot Shapiro
//April 23, 2013
//

import java.util.ArrayList;
import java.util.Iterator;

public class RoutingTable
{
	ArrayList<RoutingTableEntry> routingTable;
	int location;
	
	public RoutingTable(int l)
	{
		routingTable = new ArrayList<RoutingTableEntry>();
		location = l;
	}
	
	public int checkTable(Packet packet)
	{
		RoutingTableEntry entry = null;
		for(int x=0;x<routingTable.size();x++)
		{
			if(routingTable.get(x).exists(packet.getSourceAddress(), packet.getDestinationAddress()))
			{
				entry = routingTable.get(x);
				entry.duplicate();
			}
		}
		
		if(entry==null)
		{
			int[] routeInfo = PathAlgorithm.nextNode(location, packet.getDestinationAddress());
			entry = new RoutingTableEntry(packet.getSourceAddress(), packet.getDestinationAddress(), routeInfo[0], routeInfo[1]);
			routingTable.add(entry);
		}
		
		return entry.getNextHop();
	}
	
	public String toString()
	{
		String s = "Routing table for node "+location+":\n";
		
		Iterator itr = routingTable.iterator();
		while(itr.hasNext())
		{
			s += itr.next() + "\n";
		}
		
		return s;
	}
}