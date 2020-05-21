package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class MainScreen extends javax.swing.JFrame {

    public String userName;
    public MainScreen() {
        setIconImage(new ImageIcon(getClass().getResource("/admin/ui/trn.png")).getImage());
        initComponents();
        setSize(800, 700);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new admin.ui.MyDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiAddLoginInfo = new javax.swing.JMenuItem();
        jmiViewLoginInfo = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmiAddStationInfo = new javax.swing.JMenuItem();
        jmiViewStationInfo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAddTypeInfo = new javax.swing.JMenuItem();
        jmiViewTypeInfo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiAddCoachInfo = new javax.swing.JMenuItem();
        jmiViewCoachInfo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiAddTrainInfo = new javax.swing.JMenuItem();
        jmiViewTrainInfo = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiAddTrainCoachInfo = new javax.swing.JMenuItem();
        jmiViewTrainCoachInfo = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmiAddTrainRouteInfo = new javax.swing.JMenuItem();
        jmiViewTrainRouteInfo = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jmiAddBookingTable = new javax.swing.JMenuItem();
        jmiViewBookingInfo = new javax.swing.JMenuItem();
        jmiSearchBookingInfo = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jmiViewPassengerInfo = new javax.swing.JMenuItem();
        jmiSearchPassengerInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(DesktopPane, java.awt.BorderLayout.CENTER);

        jMenu3.setText("LoginInfo");

        jmiAddLoginInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmiAddLoginInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/login.png"))); // NOI18N
        jmiAddLoginInfo.setText("Add LoginInfo");
        jmiAddLoginInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddLoginInfoActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAddLoginInfo);

        jmiViewLoginInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jmiViewLoginInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewinfo.png"))); // NOI18N
        jmiViewLoginInfo.setText("View LoginInfo");
        jmiViewLoginInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewLoginInfoActionPerformed(evt);
            }
        });
        jMenu3.add(jmiViewLoginInfo);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("StationInfo");

        jmiAddStationInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiAddStationInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/addstninfo.png"))); // NOI18N
        jmiAddStationInfo.setText("Add StationInfo");
        jmiAddStationInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddStationInfoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiAddStationInfo);

        jmiViewStationInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jmiViewStationInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewstninfo.png"))); // NOI18N
        jmiViewStationInfo.setText("View StationInfo");
        jmiViewStationInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewStationInfoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiViewStationInfo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("TrainType");

        jmiAddTypeInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jmiAddTypeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/addtypeinfo.png"))); // NOI18N
        jmiAddTypeInfo.setText("Add TypeInfo");
        jmiAddTypeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTypeInfoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAddTypeInfo);

        jmiViewTypeInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jmiViewTypeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewtypeinfo.png"))); // NOI18N
        jmiViewTypeInfo.setText("View TypeInfo");
        jmiViewTypeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTypeInfoActionPerformed(evt);
            }
        });
        jMenu2.add(jmiViewTypeInfo);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("CoachInfo");

        jmiAddCoachInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiAddCoachInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/addcoach.png"))); // NOI18N
        jmiAddCoachInfo.setText("Add CoachInfo");
        jmiAddCoachInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddCoachInfoActionPerformed(evt);
            }
        });
        jMenu4.add(jmiAddCoachInfo);

        jmiViewCoachInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiViewCoachInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewcoach.png"))); // NOI18N
        jmiViewCoachInfo.setText("View CoachInfo");
        jmiViewCoachInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewCoachInfoActionPerformed(evt);
            }
        });
        jMenu4.add(jmiViewCoachInfo);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("TrainInfo");

        jmiAddTrainInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmiAddTrainInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/addtraininfo.png"))); // NOI18N
        jmiAddTrainInfo.setText("Add TrainInfo");
        jmiAddTrainInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTrainInfoActionPerformed(evt);
            }
        });
        jMenu5.add(jmiAddTrainInfo);

        jmiViewTrainInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        jmiViewTrainInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewtraininfo.png"))); // NOI18N
        jmiViewTrainInfo.setText("View TrainInfo");
        jmiViewTrainInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTrainInfoActionPerformed(evt);
            }
        });
        jMenu5.add(jmiViewTrainInfo);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("TrainCoachInfo");

        jmiAddTrainCoachInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
        jmiAddTrainCoachInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/addcoachinfo.png"))); // NOI18N
        jmiAddTrainCoachInfo.setText("Add TrainCoachInfo");
        jmiAddTrainCoachInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTrainCoachInfoActionPerformed(evt);
            }
        });
        jMenu6.add(jmiAddTrainCoachInfo);

        jmiViewTrainCoachInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        jmiViewTrainCoachInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewcoachinfo.png"))); // NOI18N
        jmiViewTrainCoachInfo.setText("View TrainCoachInfo");
        jmiViewTrainCoachInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTrainCoachInfoActionPerformed(evt);
            }
        });
        jMenu6.add(jmiViewTrainCoachInfo);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("TrainRouteInfo");

        jmiAddTrainRouteInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmiAddTrainRouteInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/addroute.png"))); // NOI18N
        jmiAddTrainRouteInfo.setText("Add TrainRouteInfo");
        jmiAddTrainRouteInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTrainRouteInfoActionPerformed(evt);
            }
        });
        jMenu7.add(jmiAddTrainRouteInfo);

        jmiViewTrainRouteInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jmiViewTrainRouteInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewroute.png"))); // NOI18N
        jmiViewTrainRouteInfo.setText("View TrainRouteInfo");
        jmiViewTrainRouteInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTrainRouteInfoActionPerformed(evt);
            }
        });
        jMenu7.add(jmiViewTrainRouteInfo);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("BookingTable");

        jmiAddBookingTable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jmiAddBookingTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/Addbooking.png"))); // NOI18N
        jmiAddBookingTable.setText("Add BookingInfo");
        jmiAddBookingTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddBookingTableActionPerformed(evt);
            }
        });
        jMenu8.add(jmiAddBookingTable);

        jmiViewBookingInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        jmiViewBookingInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewbooking.png"))); // NOI18N
        jmiViewBookingInfo.setText("View BookingInfo");
        jmiViewBookingInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewBookingInfoActionPerformed(evt);
            }
        });
        jMenu8.add(jmiViewBookingInfo);

        jmiSearchBookingInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, java.awt.event.InputEvent.ALT_MASK));
        jmiSearchBookingInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/Search.png"))); // NOI18N
        jmiSearchBookingInfo.setText("Search BookingInfo");
        jmiSearchBookingInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchBookingInfoActionPerformed(evt);
            }
        });
        jMenu8.add(jmiSearchBookingInfo);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("PassengerInfo");

        jmiViewPassengerInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        jmiViewPassengerInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/viewpassengerinfo.png"))); // NOI18N
        jmiViewPassengerInfo.setText("View PassengerInfo");
        jmiViewPassengerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewPassengerInfoActionPerformed(evt);
            }
        });
        jMenu9.add(jmiViewPassengerInfo);

        jmiSearchPassengerInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jmiSearchPassengerInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/Search.png"))); // NOI18N
        jmiSearchPassengerInfo.setText("Search PassengerInfo");
        jmiSearchPassengerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchPassengerInfoActionPerformed(evt);
            }
        });
        jMenu9.add(jmiSearchPassengerInfo);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAddLoginInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddLoginInfoActionPerformed
        AddLoginInfo obj = new AddLoginInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiAddLoginInfoActionPerformed

    private void jmiViewLoginInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewLoginInfoActionPerformed
        ViewLoginInfo obj = new ViewLoginInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewLoginInfoActionPerformed

    private void jmiAddStationInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddStationInfoActionPerformed
        AddStationInfo obj = new AddStationInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiAddStationInfoActionPerformed

    private void jmiAddTrainInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTrainInfoActionPerformed
        AddTrainInfo obj = new AddTrainInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiAddTrainInfoActionPerformed

    private void jmiViewStationInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewStationInfoActionPerformed
        ViewStationInfo obj = new ViewStationInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewStationInfoActionPerformed

    private void jmiAddTypeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTypeInfoActionPerformed
        AddTrainType obj = new AddTrainType();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiAddTypeInfoActionPerformed

    private void jmiViewTypeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTypeInfoActionPerformed
        ViewTrainType obj = new ViewTrainType();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewTypeInfoActionPerformed

    private void jmiAddCoachInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddCoachInfoActionPerformed
        AddCoachInfo obj = new AddCoachInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiAddCoachInfoActionPerformed

    private void jmiViewCoachInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewCoachInfoActionPerformed
        ViewCoachInfo obj = new ViewCoachInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewCoachInfoActionPerformed

    private void jmiViewTrainInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTrainInfoActionPerformed
        ViewTrainInfo obj = new ViewTrainInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try {
            obj.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }//GEN-LAST:event_jmiViewTrainInfoActionPerformed

    private void jmiAddTrainCoachInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTrainCoachInfoActionPerformed
        AddTrainCoachInfo obj=new AddTrainCoachInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiAddTrainCoachInfoActionPerformed

    private void jmiViewTrainCoachInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTrainCoachInfoActionPerformed
         ViewTrainCoachInfo obj=new ViewTrainCoachInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiViewTrainCoachInfoActionPerformed

    private void jmiAddTrainRouteInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTrainRouteInfoActionPerformed
         AddTrainRouteInfo obj=new AddTrainRouteInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiAddTrainRouteInfoActionPerformed

    private void jmiViewTrainRouteInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTrainRouteInfoActionPerformed
        ViewTrainRouteInfo obj=new ViewTrainRouteInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiViewTrainRouteInfoActionPerformed

    private void jmiAddBookingTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddBookingTableActionPerformed
         AddBookingTableInfo obj=new AddBookingTableInfo();
         obj.userName = userName;
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiAddBookingTableActionPerformed

    private void jmiViewBookingInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewBookingInfoActionPerformed
        ViewBookingTableInfo obj=new ViewBookingTableInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiViewBookingInfoActionPerformed

    private void jmiViewPassengerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewPassengerInfoActionPerformed
         ViewPassengerInfo obj=new ViewPassengerInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiViewPassengerInfoActionPerformed

    private void jmiSearchBookingInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSearchBookingInfoActionPerformed
        SearchBookingInfo obj=new SearchBookingInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiSearchBookingInfoActionPerformed

    private void jmiSearchPassengerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSearchPassengerInfoActionPerformed
        SearchPassengerInfo obj=new SearchPassengerInfo();
        obj.setVisible(true);
        DesktopPane.add(obj);
        try{
           obj.setSelected(true);
        }catch(PropertyVetoException ex){            
        }
    }//GEN-LAST:event_jmiSearchPassengerInfoActionPerformed

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private admin.ui.MyDesktopPane DesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiAddBookingTable;
    private javax.swing.JMenuItem jmiAddCoachInfo;
    private javax.swing.JMenuItem jmiAddLoginInfo;
    private javax.swing.JMenuItem jmiAddStationInfo;
    private javax.swing.JMenuItem jmiAddTrainCoachInfo;
    private javax.swing.JMenuItem jmiAddTrainInfo;
    private javax.swing.JMenuItem jmiAddTrainRouteInfo;
    private javax.swing.JMenuItem jmiAddTypeInfo;
    private javax.swing.JMenuItem jmiSearchBookingInfo;
    private javax.swing.JMenuItem jmiSearchPassengerInfo;
    private javax.swing.JMenuItem jmiViewBookingInfo;
    private javax.swing.JMenuItem jmiViewCoachInfo;
    private javax.swing.JMenuItem jmiViewLoginInfo;
    private javax.swing.JMenuItem jmiViewPassengerInfo;
    private javax.swing.JMenuItem jmiViewStationInfo;
    private javax.swing.JMenuItem jmiViewTrainCoachInfo;
    private javax.swing.JMenuItem jmiViewTrainInfo;
    private javax.swing.JMenuItem jmiViewTrainRouteInfo;
    private javax.swing.JMenuItem jmiViewTypeInfo;
    // End of variables declaration//GEN-END:variables
}
