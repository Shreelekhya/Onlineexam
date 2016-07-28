/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sindhu
 */
@WebServlet(urlPatterns = {"/gmailinbox"})
public class gmailinbox extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String ts=request.getParameter("e");
            //out.println(te);
            String url="jdbc:mysql://localhost:3306/mynewdatabase";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,"Shreelu","gampa");
                //String q1="select u from gmailsu";
                //out.println("connected");
                Statement st=conn.createStatement();
               ResultSet rs= st.executeQuery("select *from gmailmsg2 where t='"+ts+"' ");
               while(rs.next())
               {
                   //out.println("yah");
                   String f2=rs.getString("f");
                   String sub2=rs.getString("sub");
                   String content2=rs.getString("content");
                   //response.sendRedirect("gmailinbox2.html");
                   //out.println("Hi user,you got a msg from "+f2+"\n....."+"sub:"+sub2+"\n...."+"content:"+content2);
                   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gmailinbox</title>");            
            out.println("</head>");
            out.println("<body bgcolor='lavender'>");
            out.println("<br>");
            out.println("<h2>" +"You got a msg from"+" "+f2+ "</h2>");
            //out.println("<br>");
            out.println("<h4>"+"subject:"+sub2+"</h4>");
            //out.println("<br>");
            out.println("<h4>"+"content:"+content2+"</h4>");
            out.println("</body>");
            out.println("</html>");
               }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(gmailinbox.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(gmailinbox.class.getName()).log(Level.SEVERE, null, ex);
        }
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
