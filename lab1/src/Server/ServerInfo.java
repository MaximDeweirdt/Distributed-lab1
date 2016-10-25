package Server;
import java.io.Serializable;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import Router.RoutingInterface;


public class ServerInfo implements Serializable {
	private Registry serverRegistry;
	private RoutingInterface dispatcherInterface;
	private int portnumberWithDispatcher;
	private int portnumberWithServers;
	private int offset;
	private List<ServerInfo> serversList;
	
	
	public ServerInfo(){}
	
	public ServerInfo(Registry serverRegistry) throws Exception {
		serversList = new ArrayList<>();
		this.serverRegistry = serverRegistry;
		this.dispatcherInterface = (RoutingInterface)serverRegistry.lookup("dispatchermethodes");
	}

	public Registry getServerRegistry() {
		return serverRegistry;
	}
	public void setServerRegistry(Registry serverRegistry) {
		this.serverRegistry = serverRegistry;
	}
	public RoutingInterface getDispatcherInterface() {
		return dispatcherInterface;
	}
	public void setDispatcherInterface(RoutingInterface dispatcherInterface) {
		this.dispatcherInterface = dispatcherInterface;
	}
	public int getPortnumberWithDispatcher() {
		return portnumberWithDispatcher;
	}
	public void setPortnumberWithDispatcher(int portnumber) {
		this.portnumberWithDispatcher = portnumber;
	}
	
}
