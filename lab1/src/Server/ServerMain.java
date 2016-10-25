package Server;

import java.net.Inet4Address;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.atomic.AtomicLong;

import Router.RoutingInterface;
import Router.RoutingServer;

public class ServerMain {
		
	public long serverID;
	public int load = 0;
	public ServerMain() throws Exception {
		
	}

	private void startServer() {
		try {
			Registry routerRegistry = LocateRegistry.getRegistry("localhost", 3999);
			RoutingInterface router = (RoutingInterface) routerRegistry.lookup("//localhost/routInt");
			
			serverID = router.registerServer(Inet4Address.getLocalHost());
			System.out.println(serverID);
			Registry registry = LocateRegistry.createRegistry(4000);
			ServerInterface serverInt = new ServerMethods();
			
			registry.rebind("//[hostname]/serverInt" + serverID, serverInt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("system is ready");
	}
	
	public static void main(String[] args) throws Exception {
//		if (System.getSecurityManager() == null) {
//			 System.setSecurityManager(new SecurityManager());
//		}
		
		ServerMain main = new ServerMain();
		main.startServer();
	}
}
