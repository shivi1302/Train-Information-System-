package admin.ui;

import java.beans.PropertyVetoException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.StationInfoDAO;
import model.dao.TrainInfoDAO;
import model.dao.TrainRouteInfoDAO;
import model.to.StationInfoTO;
import model.to.TrainInfoTO;
import model.to.TrainRouteInfoTO;

public class AddTrainRouteInfo extends javax.swing.JInternalFrame {

    public AddTrainRouteInfo() {
        initComponents();
        setSize(650, 450);
        jcbTrainRouteInfoTrainID.removeAllItems();
        jcbTrainRouteInfoTrainID.addItem("Select Any Train ID");
        jcbTrainRouteInfoStationID.removeAllItems();
        jcbTrainRouteInfoStationID.addItem("Select Any Station ID");
        jcbTrainRouteDEPThr.removeAllItems();
        jcbTrainRouteDEPThr.addItem("Select Any Hr");
        jcbTrainRouteDEPTmin.removeAllItems();
        jcbTrainRouteDEPTmin.addItem("Select Any Minute");
        jcbTrainRouteRThr.removeAllItems();
        jcbTrainRouteRThr.addItem("Select Any Hr");
        jcbTrainRouteRTmin.removeAllItems();
        jcbTrainRouteRTmin.addItem("Select Any Minute");
        ArrayList<TrainInfoTO> allTrainRouteData = new TrainInfoDAO().getAllRecord();
        if (allTrainRouteData != null) {
            for (TrainInfoTO cit : allTrainRouteData) {
                jcbTrainRouteInfoTrainID.addItem(cit);
            }
        }
        ArrayList<StationInfoTO> allTrainRouteMeta = new StationInfoDAO().getAllRecord();
        if (allTrainRouteMeta != null) {
            for (StationInfoTO sit : allTrainRouteMeta) {
                jcbTrainRouteInfoStationID.addItem(sit);
            }
        }
        for (int minute = 1; minute <= 60; minute++) {
            jcbTrainRouteDEPTmin.addItem(minute);
            jcbTrainRouteRTmin.addItem(minute);
        }
        for (int hour = 1; hour <= 24; hour++) {
            jcbTrainRouteDEPThr.addItem(hour);
            jcbTrainRouteRThr.addItem(hour);
        }
    }
    TrainRouteInfoTO updateData;

    public AddTrainRouteInfo(TrainRouteInfoTO updata) {
        this();
        updateData = updata;
        if (updateData != null) {
            jbtnAddTrainRouteInfo.setText("Update Train Route Info");

            String timevalue = updateData.getDepartureTime().toString();
            String[] times = timevalue.split(":");
            int hr = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            for (int i = 1; i < jcbTrainRouteDEPThr.getItemCount(); i++) {
                int hour = Integer.parseInt(jcbTrainRouteDEPThr.getItemAt(i).toString());
                if (hour == hr) {
                    jcbTrainRouteDEPThr.setSelectedIndex(i);
                    break;
                }
            }
            String timevalue1 = updateData.getDepartureTime().toString();
            String[] times1 = timevalue.split(":");
            int hr1 = Integer.parseInt(times[0]);
            int min1 = Integer.parseInt(times[1]);
            for (int i = 1; i < jcbTrainRouteDEPTmin.getItemCount(); i++) {
                int hour = Integer.parseInt(jcbTrainRouteDEPTmin.getItemAt(i).toString());
                if (hour == hr1) {
                    jcbTrainRouteDEPTmin.setSelectedIndex(i);
                    break;
                }
            }
            String timevalue2 = updateData.getReachTime().toString();
            String[] times2 = timevalue.split(":");
            int hr2 = Integer.parseInt(times[0]);
            int min2 = Integer.parseInt(times[1]);
            for (int i = 1; i < jcbTrainRouteRThr.getItemCount(); i++) {
                int hour = Integer.parseInt(jcbTrainRouteRThr.getItemAt(i).toString());
                if (hour == hr2) {
                    jcbTrainRouteRThr.setSelectedIndex(i);
                    break;
                }
            }
            String timevalue3 = updateData.getReachTime().toString();
            String[] times3 = timevalue.split(":");
            int hr3 = Integer.parseInt(times[0]);
            int min3 = Integer.parseInt(times[1]);
            for (int i = 1; i < jcbTrainRouteRTmin.getItemCount(); i++) {
                int hour = Integer.parseInt(jcbTrainRouteRTmin.getItemAt(i).toString());
                if (hour == hr3) {
                    jcbTrainRouteRTmin.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbTrainRouteInfoTrainID = new javax.swing.JComboBox();
        jcbTrainRouteInfoStationID = new javax.swing.JComboBox();
        jbtnAddTrainRouteInfo = new javax.swing.JButton();
        jcbTrainRouteDEPThr = new javax.swing.JComboBox();
        jcbTrainRouteDEPTmin = new javax.swing.JComboBox();
        jcbTrainRouteRThr = new javax.swing.JComboBox();
        jcbTrainRouteRTmin = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Train Route Info");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Reach Time :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 250, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Train ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 40, 200, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Station ID :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 110, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Departure Time :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 180, 200, 30);

        jcbTrainRouteInfoTrainID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainRouteInfoTrainID);
        jcbTrainRouteInfoTrainID.setBounds(280, 40, 320, 30);

        jcbTrainRouteInfoStationID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainRouteInfoStationID);
        jcbTrainRouteInfoStationID.setBounds(280, 110, 320, 30);

        jbtnAddTrainRouteInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnAddTrainRouteInfo.setText("Add Train Route Info");
        jbtnAddTrainRouteInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddTrainRouteInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddTrainRouteInfo);
        jbtnAddTrainRouteInfo.setBounds(160, 330, 350, 70);

        jcbTrainRouteDEPThr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainRouteDEPThr);
        jcbTrainRouteDEPThr.setBounds(280, 180, 140, 30);

        jcbTrainRouteDEPTmin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainRouteDEPTmin);
        jcbTrainRouteDEPTmin.setBounds(460, 180, 140, 30);

        jcbTrainRouteRThr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainRouteRThr);
        jcbTrainRouteRThr.setBounds(280, 250, 140, 30);

        jcbTrainRouteRTmin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTrainRouteRTmin);
        jcbTrainRouteRTmin.setBounds(460, 250, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddTrainRouteInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddTrainRouteInfoActionPerformed
        String message = "";
        try {
            if (jcbTrainRouteInfoTrainID.getSelectedItem() instanceof TrainInfoTO
                    && jcbTrainRouteInfoStationID.getSelectedItem() instanceof StationInfoTO) {
                int DepartureHour = Integer.parseInt(jcbTrainRouteDEPThr.getSelectedItem().toString());
                int DepartureMinute = Integer.parseInt(jcbTrainRouteDEPTmin.getSelectedItem().toString());
                int ReachHour = Integer.parseInt(jcbTrainRouteRThr.getSelectedItem().toString());
                int ReachMinute = Integer.parseInt(jcbTrainRouteRTmin.getSelectedItem().toString());
                String DepartureTime = DepartureHour + ":" + DepartureMinute + ":0";
                String ReachTime = ReachHour + ":" + ReachMinute + ":0";
                TrainInfoTO tit = (TrainInfoTO) jcbTrainRouteInfoTrainID.getSelectedItem();
                StationInfoTO sit = (StationInfoTO) jcbTrainRouteInfoStationID.getSelectedItem();
                TrainRouteInfoTO data = new TrainRouteInfoTO();
                data.setTrainID(tit.getTrainID());
                data.setStationID(sit.getStationID());
                data.setDepartureTime(Time.valueOf(DepartureTime));
                data.setReachTime(Time.valueOf(ReachTime));
                TrainRouteInfoDAO action = new TrainRouteInfoDAO();
                if (jbtnAddTrainRouteInfo.getText().contains("Add")) {
                    if (action.insertRecord(data)) {
                        message = "Record Inserted";
                        dispose();
                    } else {
                        message = action.getErrorMessage();
                    }
                } else if (jbtnAddTrainRouteInfo.getText().contains("Update")) {
                    if (action.updateRecord(data)) {
                        message = "Record Updated";
                        JOptionPane.showMessageDialog(this, message);
                        ViewTrainRouteInfo obj = new ViewTrainRouteInfo();
                        obj.setVisible(true);
                        JDesktopPane jdp = getDesktopPane();
                        jdp.add(obj);
                        try {
                            obj.setSelected(true);
                        } catch (PropertyVetoException ex) {
                        }
                        dispose();
                    } else {
                        message = action.getErrorMessage();
                    }
                }
            } else {
                message = "Please Choose Some Values";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddTrainRouteInfoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtnAddTrainRouteInfo;
    private javax.swing.JComboBox jcbTrainRouteDEPThr;
    private javax.swing.JComboBox jcbTrainRouteDEPTmin;
    private javax.swing.JComboBox jcbTrainRouteInfoStationID;
    private javax.swing.JComboBox jcbTrainRouteInfoTrainID;
    private javax.swing.JComboBox jcbTrainRouteRThr;
    private javax.swing.JComboBox jcbTrainRouteRTmin;
    // End of variables declaration//GEN-END:variables
}
