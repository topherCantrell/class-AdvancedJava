package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SimpleServlet extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,  IOException
    {
        
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");
        
        PrintWriter pw = response.getWriter();
        
        /*
        Cookie [] cs = request.getCookies();
        pw.println("Cookies:<br>");
        if(cs!=null) {
            for(Cookie c : cs) {
                pw.println(":"+c.getName()+":"+c.getValue()+":"+c.getMaxAge()+":<br>");
            }
        }
        
        String cname = request.getParameter("name");
        String cvalue = request.getParameter("value");
        String cage = request.getParameter("age");
        String cpath = request.getParameter("path");
        String ccom = request.getParameter("comment");
        String cdomain = request.getParameter("domain");
        String cversion = request.getParameter("version");
        
        if(cname!=null && cvalue!=null) {
            pw.println("<p>Setting cookie :"+cname+":"+cvalue+":");
            Cookie c = new Cookie(cname, cvalue);
            if(cpath!=null) c.setPath(cpath);
            // age in seconds. negative means when browser exits. 0 means delete cookie.
            if(cage!=null) c.setMaxAge(Integer.parseInt(cage));           
            if(ccom!=null) c.setComment(ccom);
            if(cdomain!=null) c.setDomain(cdomain);
            if(cversion!=null) c.setVersion(Integer.parseInt(cversion));                      
            response.addCookie(c);
        }*/
                
        String uname = request.getParameter("name");
        String pass = request.getParameter("pass");
        String command = request.getParameter("command");
        
        if(command!=null && command.equals("login")) {
            if(!pass.equals("1234")) {
                pw.println("Bad login");
                return;
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("username", uname);
            pw.println("You logged in.");
            return;
        }
        
        HttpSession session = request.getSession(false);
        if(session==null) {
            pw.println("You must login.");
            return;
        }
        
        if(command!=null && command.equals("logout")) {
            session.invalidate();
            pw.println("You are logged out.");
            return;
        }
        
        pw.println("Welcome "+session.getAttribute("username")+" how may I serve you?");        
        
    }
}