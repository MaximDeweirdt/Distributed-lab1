package Router;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Router {

	public Router() { 
		super();
	}
	
	private void startRouter() {

		try {
			Registry registry = LocateRegistry.createRegistry(3999);
			
			RoutingInterface routInt = new RoutingServer();
			
			registry.rebind("//localhost/routInt", routInt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dispatcher is ready on port 3999");
	}
	public static void main(String[] args){
		
//		if (System.getSecurityManager() == null) {
//			 System.setSecurityManager(new SecurityManager());
//		}
		
		Router main = new Router();
		main.startRouter();
	}
 
}
