package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Server.ServerMain;

public class ServerMethods extends UnicastRemoteObject implements ServerInterface {

	protected ServerMethods() throws RemoteException {
		super();
	}

}
