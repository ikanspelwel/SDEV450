/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.BaseDBFunctions;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ikanspelwel
 */
public class DatabasePullExample extends HttpServlet {

    protected String host = "jdbc:mysql://sdev450.gmavt.net:3306";
    protected String username = "demo1";
    protected String password = "DirectSellDbAccess1234";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DatabasePullExample</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatabasePullExample at " + request.getContextPath() + "</h1>");
            out.println("<pre>");

            // Vars for SQL stuff
            boolean flag;
            ResultSet rs;

            String select = "select * from demo1.USERS";
            BaseDBFunctions dbTest = new BaseDBFunctions();
            flag = dbTest.connect(this.host, this.username, this.password);
            if (flag) {
                out.println("Connected successfully! ");
            } else {
                out.println("Connection failed!");
            }
            flag = dbTest.executeSQL(select, false);
            if (flag) {
                out.println("Result set selected!");
                rs = dbTest.getResults();
                try {
                    while (rs.next()) {
                        out.printf("%d %s %s %s %s %d %s %s \n", rs.getInt("UID"), rs.getString("EMAIL"),
                                rs.getString("FULL_NAME"), rs.getString("PASSWORD"),
                                rs.getString("SALT"), rs.getInt("ZIP"), rs.getString("RECOVERY_KEY"),
                                rs.getDate("DATE_JOINED"));
                    }
                } catch (SQLException err) {
                    out.println(err.getMessage());
                }
            } else {
                out.println("Select failed!");
            }

            out.println("<pre>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
