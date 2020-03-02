
import java.io.File;

import org.apache.tomcat.InstanceManager;
import org.apache.tomcat.SimpleInstanceManager;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JspServer {

    public static void main(String[] args) throws Exception {
        
        Server server = new Server(80);
        
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");         // URLs for this context start here 
        context.setResourceBase("webroot");  // Files for this context start here
        
        // Needed by Jasper JSP engine
        context.setAttribute(InstanceManager.class.getName(), new SimpleInstanceManager());
        context.setAttribute("javax.servlet.context.tempdir", new File("tmp"));
        
        context.setAttribute("keepgenerated", "true");

                     
        context.addServlet(HelloServlet.class, "/hello");
        
        context.addServlet(GradesServlet.class, "/grades");
        
        // Link the server to the context
        server.setHandler(context);        
        
        // Needed by Jasper JSP engine
        new JettyJasperInitializer();

        // Start the server thread
        server.start();        

    }

}
