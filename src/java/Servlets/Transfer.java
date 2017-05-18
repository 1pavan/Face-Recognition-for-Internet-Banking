
package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author PAVAN VARMA
 */
@WebServlet(name = "Transfer", urlPatterns = {"/Transfer"})
public class Transfer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acctypes = request.getParameter("acc_type1");
	String acctyper = request.getParameter("acc_type2");
	String accnos = request.getParameter("send_account_number");
	String accnor = request.getParameter("recv_account_number");
	String a = request.getParameter("amount");
        
        System.out.println(acctypes + " "+acctyper+" "+accnos+" "+accnor+" "+a );
	double am = Double.parseDouble(a);
        HttpSession session = request.getSession();
        if(session.getAttribute("uname")!=null)
        {
        
	if(accnos.equals(accnor)!=true)
	{
            if(acctypes.equals("s") && acctyper.equals("s"))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
                    String a1 = "Select balance from savingsaccount where SavAccNo='"+accnos+"';";
                    Statement st = con.createStatement();
                    ResultSet rs1 = st.executeQuery(a1);
                    if(rs1.next()==true)
                    {
                        double bal1 = rs1.getDouble("balance");
                        
                        rs1.close();
                        
                        String a2 = "Select balance from savingsaccount where SavAccNo='"+accnor+"';";
                        ResultSet rs2 = st.executeQuery(a2);
                        if(rs2.next()==true)
                        {
                            
                            double bal2 = rs2.getDouble("balance");
                            if(bal1>=am)
                            {
                                double balnew1 = bal1-am;
                                double balnew2 = bal2+am;
                                String b1 = "Update savingsaccount set balance = '"+balnew1+"' where SavAccNo='"+accnos+"';";
                                st.executeUpdate(b1);
                                String b2 = "Update savingsaccount set balance = '"+balnew2+"' where SavAccNo='"+accnor+"';";
                                st.executeUpdate(b2);								
                                JOptionPane.showMessageDialog(null,"Money Transfered\nYour Updated Balance:- \t"+balnew1);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Insufficient Money");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Reciever's Account Number Does Not Exist");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Sender's Account Number Does not Exist");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(acctypes.equals("s") && acctyper.equals("c"))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
                    String a1 = "Select balance from savingsaccount where SavAccNo='"+accnos+"';";
                    Statement st = con.createStatement();
                    ResultSet rs1 = st.executeQuery(a1);
                    if(rs1.next()==true)
                    {
                          double bal1 = rs1.getDouble("balance");
                          rs1.close();
                        String a2 = "Select balance from currentaccount where CurAccNo='"+accnor+"';";
                        ResultSet rs2 = st.executeQuery(a2);
                        if(rs2.next()==true)
                        {
                          
                            double bal2 = rs2.getDouble("balance");
                            if(bal1>=am)
                            {
                                double balnew1 = bal1-am;
                                double balnew2 = bal2+am;
                                String b1 = "Update savingsaccount set balance = '"+balnew1+"' where SavAccNo='"+accnos+"';";
                                st.executeUpdate(b1);
                                String b2 = "Update currentaccount set balance = '"+balnew2+"' where CurAccNo='"+accnor+"';";
                                st.executeUpdate(b2);					
                                JOptionPane.showMessageDialog(null,"Money Transfered\nYour Updated Balance:- \t"+balnew1);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Insufficient Money");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Reciever's Account Number Does Not Exist");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Sender's Account Number Does not Exist");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(acctypes.equals("c") && acctyper.equals("s"))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
                    String a1 = "Select balance from currentaccount where CurAccNo='"+accnos+"';";
                    Statement st = con.createStatement();
                    ResultSet rs1 = st.executeQuery(a1);
                    if(rs1.next()==true)
                    {
                        double bal1 = rs1.getDouble("balance");
                        rs1.close();    
                        String a2 = "Select balance from savingsaccount where SavAccNo='"+accnor+"';";
                        ResultSet rs2 = st.executeQuery(a2);
			if(rs2.next()==true)
			{
                            double bal2 = rs2.getDouble("balance");
                            if(bal1>=am)
                            {
                                double balnew1 = bal1-am;
				double balnew2 = bal2+am;
                                String b1 = "Update currentaccount set balance = '"+balnew1+"' where CurAccNo='"+accnos+"';";
                                st.executeUpdate(b1);
                                String b2 = "Update savingsaccount set balance = '"+balnew2+"' where SavAccNo='"+accnor+"';";
                                st.executeUpdate(b2);
				JOptionPane.showMessageDialog(null,"Money Transfered\nYour Updated Balance:- \t"+balnew1);
                            }
                            else
                            {
				JOptionPane.showMessageDialog(null,"Insufficient Money");
                            }
			}
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Reciever's Account Number Does Not Exist");
			}
                    }
                    else
                    {
			JOptionPane.showMessageDialog(null,"Sender's Account Number Does not Exist");
                    }
		}
                catch(Exception e)
                {
                    System.out.println("Exception Occured: "+e);
                }
            }
            else if(acctypes.equals("c") && acctyper.equals("c"))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","");
                    String a1 = "Select balance from currentaccount where CurAccNo='"+accnos+"';";
                    Statement st = con.createStatement();
                    ResultSet rs1 = st.executeQuery(a1);
                    if(rs1.next()==true)
                    {
                        String a2 = "Select balance from currentaccount where CurAccNo='"+accnor+"';";
                        ResultSet rs2 = st.executeQuery(a2);
			double bal1 = rs1.getDouble("balance");
                            
                        rs1.close();
                        if(rs2.next()==true)
			{
                            double bal2 = rs2.getDouble("balance");
                            if(bal1>=am)
                            {
                                double balnew1 = bal1-am;
				double balnew2 = bal2+am;
                                String b1 = "Update currentaccount set balance = '"+balnew1+"' where CurAccNo='"+accnos+"';";
                                st.executeUpdate(b1);
                                String b2 = "Update currentaccount set balance = '"+balnew2+"' where CurAccNo='"+accnor+"';";
                                st.executeUpdate(b2);
				JOptionPane.showMessageDialog(null,"Money Transfered\nYour Updated Balance:- \t"+balnew1);
                            }
                            else
                            {
				JOptionPane.showMessageDialog(null,"Insufficient Money");
                            }
			}
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Reciever's Account Number Does Not Exist");
			}
                    }
                    else
                    {
			JOptionPane.showMessageDialog(null,"Sender's Account Number Does not Exist");
                    }
		}
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        } 
    }
    else
    {
        JOptionPane.showMessageDialog(null,"Please Login to Proceed Further");
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
