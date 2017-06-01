package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;
    
    private static int count=0;

    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,  IOException
    {
        
        response.setStatus(HttpServletResponse.SC_OK);
        
        count = count + 1;
                
        PrintWriter pw = response.getWriter();                    
        //pw.println(8675309);
        pw.println(count);
        
    }
}