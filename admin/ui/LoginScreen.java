package admin.ui;

import javax.swing.JOptionPane;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTO;
import operation.checks;

public class LoginScreen extends javax.swing.JFrame {
int counter;
    public LoginScreen() {
        initComponents();
        setSize(617,417);
        setLocationRelativeTo(null);
        counter=0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfLoginScreenUsername = new javax.swing.JTextField();
        jpfLoginScreenPassword = new javax.swing.JPasswordField();
        jbtnLoginScreen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Screen");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter User Password :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 160, 230, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter User Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 44, 230, 50);
        getContentPane().add(jtfLoginScreenUsername);
        jtfLoginScreenUsername.setBounds(250, 50, 310, 40);
        getContentPane().add(jpfLoginScreenPassword);
        jpfLoginScreenPassword.setBounds(250, 160, 310, 40);

        jbtnLoginScreen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnLoginScreen.setText("Login");
        jbtnLoginScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoginScreenActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnLoginScreen);
        jbtnLoginScreen.setBounds(110, 263, 370, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLoginScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoginScreenActionPerformed
       String message="";
       try{
           counter++;
           if(counter>3){
               message="Try Again!";
               dispose();
           }else{
           String username=jtfLoginScreenUsername.getText().trim();
           String password=new String(jpfLoginScreenPassword.getPassword());
           if(checks.isEmpty(username)|| checks.isEmpty(password)){
               message="Please Fill All Boxes";
           }else{
               LoginInfoTO data=new LoginInfoDAO().checkLogin(username, password);
               if(data!=null){
                   message="Welcome Valid User";
                   if(data.getRoleName().equals("admin")){
                       MainScreen obj=new MainScreen();
                       obj.userName = username;
                       obj.setVisible(true);
                       dispose();
                   }else if(data.getRoleName().equals("user")){
                       user.ui.UserMainScreen obj=new user.ui.UserMainScreen();
                       obj.setVisible(true);
                       dispose();
                   }
               }else{
                   message="Invalid Username or Password";
               }
           }
          }
       }catch(Exception ex){
           message=ex.getMessage();
           ex.printStackTrace();
       }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnLoginScreenActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnLoginScreen;
    private javax.swing.JPasswordField jpfLoginScreenPassword;
    private javax.swing.JTextField jtfLoginScreenUsername;
    // End of variables declaration//GEN-END:variables
}
