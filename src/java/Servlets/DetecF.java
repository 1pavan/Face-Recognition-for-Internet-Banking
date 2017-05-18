/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import facerecnew1.SignUp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author PAVAN VARMA
 */
@WebServlet(name = "DetecF", urlPatterns = {"/DetecF"})
public class DetecF extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //Scanface
        facegui.DetectFace f;
        String name  = request.getParameter("form-name");
        String email = request.getParameter("form-email");
        String address = request.getParameter("form-address");
        String acctype = request.getParameter("type");
        String pin = request.getParameter("form-password");
        String date = request.getParameter("form-date");
        String gender = request.getParameter("gender");
        String contactno = request.getParameter("form-mobileno");
        double balance =0.0;
        int prid=0;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
            Statement st=con.createStatement();
            String query = "SELECT CusID FROM `customer` ORDER BY CusID DESC LIMIT 1";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())  
            {     
                prid = rs.getInt("CusID");
            }
            else
            {
                prid=0;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        StringBuilder uname1 = new StringBuilder(); 
        uname1.append(name); 
        int temp = prid+1; 
        uname1.append(Integer.toString(temp)); 
        String uname = uname1.toString();
        try 
        {
            f=new facegui.DetectFace(uname);
            f.start();
        } 
        catch(Exception ex) 
        {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Submit
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
            Statement st=con.createStatement();
            st.executeUpdate("INSERT INTO customer(CusId,Name,MailID,Username,PIN,Address,DOB,Phone,Sex,URL) VALUES('"+temp+"','"+name+"','"+email+"','"+uname+"','"+pin+"','"+address+"','"+date+"','"+contactno+"','"+gender+"','faceDb1/"+uname+"/');");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(acctype.equals("s"))
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
                Statement st=con.createStatement();
                String a = name.substring(0,3);
		char[] c = new char[name.length()];
		c = name.toCharArray();
		String b = " ";
		for(int i=0;i<name.length();i++)
		{
                    if(c[i]==' ')
                    {
			b = name.substring(i+1,i+4);
			break;
                    }
		}
                String accno = a+b+"@"+temp;
                st.executeUpdate("INSERT INTO savingsaccount(SavAccNo,balance) VALUES('"+accno+"','"+balance+"');");
                JOptionPane.showMessageDialog(null,"Savings Account Created\n Number: "+accno+"\nUsername :"+uname+" Balance: "+balance);
                response.sendRedirect("Login.jsp");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(acctype.equals("c"))
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
                Statement st=con.createStatement();
                String a = name.substring(0,3);
                char[] c = new char[name.length()];
		c = name.toCharArray();
		String b = " ";
		for(int i=0;i<name.length();i++)
		{
                    if(c[i]==' ')
                    {
			b = name.substring(i+1,i+4);
                        break;
                    }
		}
		String accno = b+a+"$"+temp;
                st.executeUpdate("INSERT INTO currentaccount(CurAccNo,balance) VALUES('"+accno+"','"+balance+"');");
                JOptionPane.showMessageDialog(null,"Current Account Created\n Number: "+accno+"\nUsername :"+uname+" Balance: "+balance);
                response.sendRedirect("Login.jsp");
            }
            catch(Exception e)
            {
                System.out.println(e);
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

