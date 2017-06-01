package web;
import org.apache.jasper.servlet.JspServlet;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SimpleServer {
    
public static void main(String[] args) throws Exception {
        
        // For static files
        ResourceHandler staticFilesHandler = new ResourceHandler();
        String [] welcomeFiles = {"index.html"};
        staticFilesHandler.setWelcomeFiles(welcomeFiles);
        staticFilesHandler.setResourceBase("webroot");
        
        new JettyJasperInitializer();
        
        // SimpleServlet
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(CountServlet.class, "/getValue");
        //servletHandler.addServletWithMapping(SimpleServlet.class,"/code/*");
        //servletHandler.addServletWithMapping(JspServlet.class,"*.jsp");
        
        
                
        // Sessions
        SessionHandler sessionHandler = new SessionHandler();        
        
        // Container of handlers
        HandlerList handlers = new HandlerList();        
        handlers.addHandler(sessionHandler);  
        handlers.addHandler(staticFilesHandler); 
        handlers.addHandler(servletHandler); 
        
        Server server = new Server(80);
        server.setHandler(handlers); 
        
        ServletHolder jspSH = new
                ServletHolder(org.apache.jasper.servlet.JspServlet.class);
                        jspSH.setInitParameter("trimSpaces"    , "true");
                        jspSH.setInitParameter("mappedFile"    , "true");
                        jspSH.setInitParameter("classdebuginfo", "true");
                        jspSH.setInitParameter("keepGenerated" , "true");
                        jspSH.setInitParameter("development"   , "true");
                        jspSH.setInitParameter("scratchDir"    , "./target/scratch");
                        
        
        server.start();

    }

}
