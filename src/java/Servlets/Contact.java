package Servlets;
//Imports
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Message.RecipientType;
//Begin Class Contact
public class Contact extends HttpServlet{
    
    String sender;
    String host;
    String msg;
    
    Contact(String sender, String host, String msg){    
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
                  
      String to = "ourEmail@gmail.com"; //collective team email      
      String from = sender;
 
      // Get system properties
      Properties properties = System.getProperties();      
      properties.setProperty("mail.smtp.host", host);
       
      Session session = Session.getDefaultInstance(properties);
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      try {
         
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));                 
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         

         // Send HTML message
         message.setContent(msg, "text/html" );                  
         Transport.send(message);
         String title = "Contact Us";
         String res = "Sent message successfully!";
         String docType =
         "<!DOCTYPE html>";
         
         out.println(docType +
            "<html>\n" +
               "<head><title>" + title + "</title></head>\n" +
               "<body bgcolor = \"#f0f0f0\">\n" +
                  "<h1 align = \"center\">" + title + "</h1>\n" +
                  "<p align = \"center\">" + res + "</p>\n" +
               "</body></html>"
         );
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
} 
 //End Subclass Contact