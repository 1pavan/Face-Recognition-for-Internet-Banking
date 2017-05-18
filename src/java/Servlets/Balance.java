/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Kapil
 */
public class Balance extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r = request.getParameter("acc_type");
        String accno = request.getParameter("form-username");
        
        System.out.println(r+" "+accno);
        Connection con;
        
        Statement st;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
            st = con.createStatement();
            if(r.equals("s"))
            {
                String sq = "Select balance from savingsaccount where SavAccNo='"+accno+"';";
                ResultSet rs = st.executeQuery(sq);
                if(rs.next()==true)
                {
                    double bal = rs.getDouble("balance");
                    JOptionPane.showMessageDialog(null,"Balance: "+bal);
                    response.sendRedirect("Main.jsp");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Check Account Number");
                    response.sendRedirect("Balance.jsp");
                }
            }
            else if(r.equals("c"))
            {
                String sq = "Select balance from currentaccount where CurAccNo='"+accno+"';";
                ResultSet rs = st.executeQuery(sq);
                if(rs.next()==true)
                {
                    double bal = rs.getDouble("balance");
                    JOptionPane.showMessageDialog(null,"Balance: "+bal);
                    response.sendRedirect("Main.jsp");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Check Account Number");
                    response.sendRedirect("Balance.jsp");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Choose Correct Option");
                response.sendRedirect("Balance.jsp");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
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
