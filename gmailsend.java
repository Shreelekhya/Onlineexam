/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/gmailsend"})
public class gmailsend extends HttpServlet {

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
            String f=request.getParameter("t1");
            String t=request.getParameter("t2");
            String sub=request.getParameter("t3");
            String content=request.getParameter("t4");
            String url="jdbc:mysql://localhost:3306/mynewdatabase";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(url,"Shreelu","gampa");
                //String q1="select u from gmailsu";
                //out.println("connected");
                //out.println(to);
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select userid from gmailsu");
                String u2 = null;
                while(rs.next())
                {
                    u2=rs.getString("userid");
                   // p2=rs.getString("p");
                    //out.println(u2+p2);
                   if(u2.equals(t))
                    {
                        //out.println(u2);
                        PreparedStatement ps=conn.prepareStatement("insert into gmailmsg2 values(?,?,?,?)");
                        ps.setString(1,f);
                        ps.setString(2,t);
                       ps.setString(3,sub);
                        ps.setString(4,content);
                        int i=ps.executeUpdate();
                        if(i>0)
                        out.println("sent successfully!!");
                       break;
                    } 
                }
                if(!u2.equals(t))
                    out.println("incorrect email details!!");
                
        
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
            Logger.getLogger(gmailsend.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(gmailsend.class.getName()).log(Level.SEVERE, null, ex);
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
