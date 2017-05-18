


package facegui;

import facerecnew1.EyeRecognition;
import facerecnew1.FacePainterExample1;
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
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Manikandan
 */
public class ExistUser extends javax.swing.JFrame {
   String name="facematch";
    public ExistUser() {
        initComponents();
    }
     DetectFace1 det;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        v1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Face Recognition");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Preprocess");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("First Name");

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Result");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(v1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(87, 87, 87)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(v1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
           det=new DetectFace1();
          det.start();
          
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(FaceRecognition.anslogic)
            {
                //JOptionPane.showMessageDialog(rootPane,"Found");
            }
            else
            {
               //  JOptionPane.showMessageDialog(rootPane," Not Found");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try { 
            FileUtils.cleanDirectory(new File("Facerec/data"));
             FileUtils.cleanDirectory(new File("Facerec/alterdata"));
        } catch (IOException ex) {
            Logger.getLogger(ExistUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name = v1.getText();
        StringBuilder sb_charsim = new StringBuilder();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/face", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from newuser order by id");
            while(rs.next())
            {
            int id = rs.getInt(1);
            int tempid=1;
            String name1 = rs.getString(2);
            String recopath = rs.getString(6)+"/face/";
            File folder = new File(recopath);
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                    sb_charsim.append(id + " " + name1 + " " + recopath + listOfFiles[i].getName());

                    sb_charsim.append(System.getProperty("line.separator"));
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            }
             BufferedWriter bwr_charsim = new BufferedWriter(new FileWriter(new File("data/ftrain.txt")));
//                output.close();
                bwr_charsim.write(sb_charsim.toString());
            bwr_charsim.flush();
            bwr_charsim.close();
            
           System.out.println("Success");
           eyeclass();

        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      try{
          det.stop();
        File folder1 = new File("Facerec/data");
            File[] listOfFiles1 = folder1.listFiles();
        if(listOfFiles1[0].isFile())
        {
             StringBuilder sb_charsim = new StringBuilder();
            //***********************************
            File folder = new File("Facerec/data");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                    sb_charsim.append("1 " + name + " Facerec/data/" + listOfFiles[i].getName());

                    sb_charsim.append(System.getProperty("line.separator"));
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
             BufferedWriter bwr_charsim = new BufferedWriter(new FileWriter(new File("data/frec.txt")));
//                output.close();
                bwr_charsim.write(sb_charsim.toString());
            bwr_charsim.flush();
            bwr_charsim.close();
            
            //************************************************************************
            String train="faceDb/"+name+"/ftrain.txt";
            String match="Facerec/data/";
            
            FaceRecognition.match(train, match);
           
        }
        else{
            
        }
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
        try {
             eyerecc();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/face", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from newuser where FirstName='"+v1.getText()+"'");
            rs.next();
       if(FaceRecognition.nearnew==rs.getInt(1)){
        if(!FaceRecognition.answernew.equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, FaceRecognition.answernew);
        }
        else  if(!EyeRecognition.answernew.equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, EyeRecognition.answernew);
        }
        else
        {
         JOptionPane.showMessageDialog(rootPane,"Failed");    
        }
       }
       else
       {
           JOptionPane.showMessageDialog(rootPane,"Failed");
       }
         } catch (Exception e) {
             System.out.println(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public  void eyeclass()
    {
        try { 
           // FileUtils.cleanDirectory(new File("Facerec/data"));
            // FileUtils.cleanDirectory(new File("Facerec/alterdata"));
        } catch (Exception ex) {
            Logger.getLogger(ExistUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name = v1.getText();
        StringBuilder sb_charsim = new StringBuilder();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer order by CusID");
            while(rs.next())
            {
            int id = rs.getInt(1);
            int tempid=1;
            
            String recopath = "C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+rs.getString(4)+"\\eye\\";
            File folder = new File(recopath);
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                    sb_charsim.append(id + " " + rs.getString(4)+ " " + recopath + listOfFiles[i].getName());

                    sb_charsim.append(System.getProperty("line.separator"));
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            }
             BufferedWriter bwr_charsim = new BufferedWriter(new FileWriter(new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\dataeye\\etrain.txt")));
//                output.close();
                bwr_charsim.write(sb_charsim.toString());
            bwr_charsim.flush();
            bwr_charsim.close();
            
           System.out.println("Success");

        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eyerecc()
    {
        try{
         StringBuilder sb_charsim = new StringBuilder();
            //***********************************
            File folder = new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\alterdata");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                    sb_charsim.append("1 " + name + " C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\alterdata\\" + listOfFiles[i].getName());

                    sb_charsim.append(System.getProperty("line.separator"));
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
             BufferedWriter bwr_charsim = new BufferedWriter(new FileWriter(new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\dataeye\\erec.txt")));
//                output.close();
                bwr_charsim.write(sb_charsim.toString());
            bwr_charsim.flush();
            bwr_charsim.close();
            
            //************************************************************************
            String train="C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+name+"\\ftrain.txt";
            String match="C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\Facerec\\alterdata\\";
            EyeRecognition.match(train, match);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExistUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExistUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExistUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExistUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExistUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField v1;
    // End of variables declaration//GEN-END:variables
}
