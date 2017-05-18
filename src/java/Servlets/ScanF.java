/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import facegui.ExistUser;
import facerecnew1.EyeRecognition;
import facerecnew1.FaceRecognition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PAVAN VARMA
 */
@WebServlet(name = "ScanF", urlPatterns = {"/ScanF"})
public class ScanF extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String name=request.getParameter("cusid");
        try
        {
            File folder1 = new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\data");
            File[] listOfFiles1 = folder1.listFiles();
            if(listOfFiles1[0].isFile())
            {
                StringBuilder sb_charsim1 = new StringBuilder();
                File folder = new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\data");
                File[] listOfFiles = folder.listFiles();
                for (int i = 0; i < listOfFiles.length; i++) 
                {  System.out.println("Hi");
                    if (listOfFiles[i].isFile()) {
                        System.out.println("File " + listOfFiles[i].getName());
                        sb_charsim1.append("1 " + name + " C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\data\\" + listOfFiles[i].getName());
                        sb_charsim1.append(System.getProperty("line.separator"));
                    } 
                    else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            BufferedWriter bwr_charsim = new BufferedWriter(new FileWriter(new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\data\\frec.txt")));
            bwr_charsim.write(sb_charsim1.toString());
            bwr_charsim.flush();
            bwr_charsim.close();
            String train="faceDb/"+name+"/ftrain.txt";
            String match="C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\data";
            FaceRecognition.match(train, match);
        }
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
        try {
            ExistUser e = new ExistUser();
            e.eyerecc();
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
        
        
        
        
        //RESULT STARTSSSSSSSSSSSSSSSSS
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select CusID from customer where Username='"+name+"'");           
            if(rs.next())
            {   
                if(FaceRecognition.nearest==rs.getInt("CusID") || EyeRecognition.nearest==rs.getInt("CusID"))
                {
                    JOptionPane.showMessageDialog(null,"Welcome"+name); 
                    session.setAttribute("uname",name);
                    response.sendRedirect("Main.jsp");
                }
                else 
                { 
                    JOptionPane.showMessageDialog(null,"Failed"); 
                }
            }
        } 
        catch(Exception e) 
        {
            System.out.println(e);
        }
         
        //RESULT ENDS 
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