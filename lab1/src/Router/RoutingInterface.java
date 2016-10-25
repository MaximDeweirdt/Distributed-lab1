package Router;

import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicLong;

public interface RoutingInterface  extends Remote {

	public double processClientRequest(InetAddress inetAddress) throws RemoteException;

	public long registerServer(InetAddress inetAddress) throws RemoteException;
	
}
