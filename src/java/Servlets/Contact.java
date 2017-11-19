package Database;

/** 
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Ari
 * @Assignment Name: Database
 * @Date: Nov 9, 2017
 * @Subclass Contact Description: 
 */
//Imports
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;

//Begin Subclass Contact
public class Contact extends HttpServlet{
    
    String sender;
    String host;
    String msg;
    
    Contact(String sender, String host, String msg){    
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String from = request.getParameter("inputEmail");
            String subj = request.getParameter("inputSubject");
            String msg = request.getParameter("inputComment");
            if (from != null && subj != null && msg != null){
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp." + 
                        from.substring(from.lastIndexOf("@") + 1)); //finds mail server
                
                try {

                    Session session = Session.getDefaultInstance(properties);
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress("ourEmail@outlook.net"));
                    message.setSubject(subj);
                    message.setText(msg);                    
                    Transport.send(message);
                    out.println("Your email has been sent.");

                } catch (MessagingException e) {
                    
                }
                        
                
            }
        } catch (Error e) {
            //Show error message
        }                
    }
}