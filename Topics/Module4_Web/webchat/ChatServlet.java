import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cork.CorkBoard;
import cork.CorkBoardImpl;
import cork.Message;

public class ChatServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private static CorkBoard board = new CorkBoardImpl();
    
    // GET /
    //      ?names=a,b,c
    //      ?clear
    //      ?sender=d&message=blahblah
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                
        String names = request.getParameter("names"); 
        String clear = request.getParameter("clear");
        String sender = request.getParameter("sender");
        String message = request.getParameter("message");
        
        //System.out.println(":"+names+":"+clear+":"+sender+":"+message+":");
        
        if(clear!=null) {
            board.clearBoard();
        }
        
        if(sender!=null && message!=null) {
            Message m = new Message(sender, message);
            board.postMessage(m);
        }
        
        // Filter based on names
        List<Message> mes = board.getMessages();
        if(names!=null) {
            String [] nms = names.split(",");
            List<String> nmsList = Arrays.asList(nms);
            List<Message> use = new ArrayList<Message>();            
            for(Message m : mes) {
                if(nmsList.contains(m.getSender())) {
                    use.add(m);
                }
            }
            mes = use;
        }       
        
        // Generate return
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.println(mes);        
        
    }
    
}
