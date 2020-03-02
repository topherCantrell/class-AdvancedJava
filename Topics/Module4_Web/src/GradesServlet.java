

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GradesServlet extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,  IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter pw = response.getWriter();
        
        pw.println("<html><head><title>Student Grades</title></head>");
        pw.println("<style>th, tr, td, table {border: 1px solid black;"+
              "border-collapse: collapse;}</style><body>");
        
        pw.println("<h1>"+HortonData.TEACHER+"'s 4th Grade Class</h1>");
        
        pw.println("<table><tr><th>Name</th><th>Grade</th><th>Subject</th></tr>");
        
        for(int i=0;i<HortonData.SAMPLE_DATA.length;++i) {
            pw.println("<tr><td>"+HortonData.SAMPLE_DATA[i][0]+"</td>");
            pw.println("<td>"+HortonData.SAMPLE_DATA[i][1]+"</td>");
            pw.println("<td>"+HortonData.SAMPLE_DATA[i][2]+"</td></tr>");        
        }        
        
        pw.println("</table><p></body></html>");
        
    }
}


