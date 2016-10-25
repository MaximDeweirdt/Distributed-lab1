package Router;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RoutingServer extends UnicastRemoteObject implements RoutingInterface{

	protected RoutingServer() throws RemoteException {
		super();
	}

	public double processClientRequest(double length, double weight) throws RemoteException {
		
		return 0;
	}
	
}
