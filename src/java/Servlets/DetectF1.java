

package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facegui.DetectFace1;
import facegui.ExistUser;
import facerecnew1.EyeRecognition;
import facerecnew1.FaceRecognition;
import facerecnew1.Login;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;


/**
 *
 * @author PAVAN VARMA
 */
@WebServlet(name = "DetectF1", urlPatterns = {"/DetectF1"})
public class DetectF1 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //User Details
        String name = request.getParameter("form-cusid");
        String pin = request.getParameter("form-pin");
        
        String g="";
        
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
            Statement st=con.createStatement();
            String query = "SELECT * FROM customer WHERE Username = '"+name+"' and Pin ='"+pin+"'";
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                g = "Valid User";
                System.out.println("Pavan");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
            }         
 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(g.equals("Valid User"))
        {
            try { 
                FileUtils.cleanDirectory(new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\data"));
                FileUtils.cleanDirectory(new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\alterdata"));
            } 
            catch(IOException ex) 
            {
                Logger.getLogger(ExistUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String name = v1.getText();
            StringBuilder sb_charsim = new StringBuilder();
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root", "");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from customer order by CusID");
                while(rs.next())
                {
                    int id = rs.getInt(1);
                    int tempid=1;
                 
                    String recopath = "C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+rs.getString(4)+"\\face\\";
                    System.out.println(recopath);
                    File folder = new File(recopath);
                    File[] listOfFiles = folder.listFiles();
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                        System.out.println("File " + listOfFiles[i].getName());
                        sb_charsim.append(id + " " + rs.getString(4) + " " + recopath + listOfFiles[i].getName());
                        System.out.println("Kapil");
                        sb_charsim.append(System.getProperty("line.separator"));
                        }
                        else if (listOfFiles[i].isDirectory()) {
                            System.out.println("Directory " + listOfFiles[i].getName());
                        }
                    }
                }
                BufferedWriter bwr_charsim = new BufferedWriter(new FileWriter(new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\data\\ftrain.txt")));
                 bwr_charsim.write(sb_charsim.toString());
                bwr_charsim.flush();
                bwr_charsim.close();
                System.out.println("Success");
                ExistUser d = new ExistUser();
                d.eyeclass();
            } 
            catch(Exception ex) 
            {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        //Preprocess ENDSSDSDSD
        
        
        
        //Face Recognition Begins
        
        
        DetectFace1 det;
        try {
          //  FacePainterExample1 f = new FacePainterExample1();
           det=new DetectFace1();
          det.start();
          //new DetectFace();
          
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        response.sendRedirect("a.jsp");
        
        
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


