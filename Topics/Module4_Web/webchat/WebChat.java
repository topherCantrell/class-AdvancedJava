import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class WebChat {
    
    public static void main(String[] args) throws Exception {
        
        // For static files
        ResourceHandler staticFilesHandler = new ResourceHandler();
        String [] welcomeFiles = {"index.html"};
        staticFilesHandler.setWelcomeFiles(welcomeFiles);
        staticFilesHandler.setResourceBase("webroot");
        
        // HelloServlet
        ServletHandler chatHandler = new ServletHandler();
        chatHandler.addServletWithMapping(ChatServlet.class,"/");
        
        // Container of handlers
        HandlerList handlers = new HandlerList();
            
        handlers.addHandler(staticFilesHandler);
        handlers.addHandler(chatHandler);
        
        Server server = new Server(80);
        server.setHandler(handlers); 
        server.start();

    }

}
