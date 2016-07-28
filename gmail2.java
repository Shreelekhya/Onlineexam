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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sindhu
 */
@WebServlet(urlPatterns = {"/gmail2"})
public class gmail2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           //out.print("<html><body><script src="form_validation.js"></script> "
            String u1=request.getParameter("t1");
            String p1=request.getParameter("t2");
            String b1=request.getParameter("b1");
            //out.print(b1);
            
               if(u1=="" && p1=="")
                    response.sendRedirect("http://localhost:8080/gmail/gmail.html");
                    /*   out.println("<html><body><script>");
                    out.println(" var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; ");
                    out.println(" if(!u1.value.match(mailformat)) { ");
                    
                    response.sendRedirect("http://localhost:8080/gmail/invalidd.html");
                    out.println(" }</script></body></html>"); */
                  String url="jdbc:mysql://localhost:3306/mynewdatabase";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,"Shreelu","gampa");
                String q1="select u,p from gmailsu";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select userid,p from gmailsu");
                String u2 = null,p2=null;
                while(rs.next())
                {
                    u2=rs.getString("userid");
                    p2=rs.getString("p");
                    out.println(u2+p2);
                    RequestDispatcher rd=request.getRequestDispatcher("/gmailnxt.html");
                    if(p2.equals(p1) && u2.equals(u1))
                    {
                        //response.sendRedirect("http://localhost:8080/gmail/gmailnxt.html");
                        
                        rd.forward(request,response);
                        
                        
                        break;
                    }
                    else
                        rd.include(request,response);
                    
                    
                }   
                if(!u1.equals(u2) && !p1.equals(p2))
                    
                    response.sendRedirect("http://localhost:8080/gmail/invalidd.jsp");
                /*ResultSet rs2=st.executeQuery("select *from gmailsu");
                while(rs2.next())
                {
                    out.println("\n"+rs2.getString("ph"));
                }*/
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
            Logger.getLogger(gmail2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(gmail2.class.getName()).log(Level.SEVERE, null, ex);
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
