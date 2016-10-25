package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Router.RoutingInterface;
import Router.RoutingServer;

public class ServerMain {
	public ServerInfo serverInfo;
		
	public ServerMain() throws Exception {
		serverInfo = new ServerInfo(LocateRegistry.getRegistry("localhost", 3999));
		serverInfo.setPortnumberWithDispatcher(serverInfo.getDispatcherInterface().addNewServer(serverInfo));
	}

	private void startServer() {
		try {
			Registry registry = LocateRegistry.createRegistry(serverInfo.getPortnumberWithDispatcher());
			ServerInterface serverInt = new ServerMethods(this);
			
			Naming.rebind("//[hostname]/serverInt", serverInt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("system is ready");
	}
	
	public static void main(String[] args) throws Exception {
		if (System.getSecurityManager() == null) {
			 System.setSecurityManager(new SecurityManager());
		}
		
		ServerMain main = new ServerMain();
		main.startServer();
	}
}
