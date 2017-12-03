package Servlets;

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
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Contact")
public class Contact extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String from = request.getParameter("email");
            String subj = request.getParameter("subject");
            String msg = request.getParameter("message");
            if (from != null && subj != null && msg != null) {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp."
                        + from.substring(from.lastIndexOf("@") + 1)); //finds mail server
                properties.put("mail.smtp.starttls.enable", "true");
                properties.setProperty("mail.smtp.auth", "true");

                try {

                    Session session = Session.getDefaultInstance(properties,
                            new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    "sdev450directsell@gmail.com", "sdev4502017pw");// Specify the Username and the PassWord
                        }
                    });
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("sdev450directsell@gmail.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress("sdev450directsell@gmail.com"));
                    message.setSubject("New Support Message: " + subj);
                    message.setText(msg);
                    Transport.send(message);

                    //Sends copy of email to user                    
                    message.setFrom(new InternetAddress("sdev450directsell@gmail.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(from));
                    message.setSubject("Thank You for Your Inquiry");
                    message.setText("Hello there,\n\nThank you for contacting Direct Sell. "
                            + "We have received the following message from you:\n\n\""
                            +msg
                            + "\"\n\nOur Customer Service team will be in touch as soon as possible.\n"
                            + "\nHave wonderful day!\n\n\nSincerely,\n\n"                           
                            + "Direct Sell Customer Service\n"                            
                            + "sdev450directsell@gmail.com");
                    Transport.send(message);
                    out.println("Your email has been sent.");
                    response.sendRedirect("/DirectSell450/contactSent.jsp");

                } catch (MessagingException e) {
                    out.println("Messaging Error:");
                    out.println(e);
                    e.printStackTrace();

                }

            }
        } catch (Error e) {
            out.println("Other Error:");
            out.println(e);
            e.printStackTrace();

        }
    }
}
