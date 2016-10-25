package Router;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoutingInterface  extends Remote {

	public double processClientRequest(double length, double weight) throws RemoteException;
	
}
