package Router;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class RoutingServer extends UnicastRemoteObject implements RoutingInterface{

	public static AtomicLong serverID = new AtomicLong(0);
	public static AtomicLong clientID = new AtomicLong(0);
	public static List<Long> serverList = new ArrayList<>();
	public static Map<Long, InetAddress> ipMap = new HashMap<>();
	
	protected RoutingServer() throws RemoteException {
		super();
	}
	
	@Override
	public long registerServer(InetAddress inetAddress) throws RemoteException {
		serverList.add(serverID.get());
		ipMap.put(serverID.get(), inetAddress);
		return serverID.getAndIncrement();
	}

	@Override
	public double processClientRequest(InetAddress inetAddress) throws RemoteException {
		
		return 0;
	}
	
}
