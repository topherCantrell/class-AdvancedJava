import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;


//Create "user=pacman" and show that it goes away when browser restarts
//Create "powerpill=true, 20 seconds and show that it times out
//Create "superuser=true, path=/code/subA" and show "/code/subA", "code/subA/other", and "/code/subB", and "/code"

public class HiLoServer {

	public static void main(String[] args) throws Exception {
		
		// For static files
        ResourceHandler staticFilesHandler = new ResourceHandler();
        String [] welcomeFiles = {"index.html"};
        staticFilesHandler.setWelcomeFiles(welcomeFiles);
        staticFilesHandler.setResourceBase("webroot");
        
        // For Servlets
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(HiLoServlet.class, "/hilo");
        
        // Container of handlers
        HandlerList handlers = new HandlerList();        
        handlers.addHandler(staticFilesHandler); 
        handlers.addHandler(servletHandler);
		
		Server server = new Server(80);
		server.setHandler(handlers);
		server.start();
		
	}

}
