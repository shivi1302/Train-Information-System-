package admin.ui;

import java.beans.PropertyVetoException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.StationInfoDAO;
import model.dao.TrainInfoDAO;
import model.to.StationInfoTO;
import model.to.TrainInfoTO;
import operation.checks;

public class AddTrainInfo extends javax.swing.JInternalFrame {

    public AddTrainInfo() {
        initComponents();
        setSize(750, 650);
        jcbSourceID.removeAllItems();
        jcbSourceID.addItem("Select Source ID");
        jcbDestinationID.removeAllItems();
        jcbDestinationID.addItem("Select Destination ID");
        ArrayList<StationInfoTO> allTrainData = new StationInfoDAO().getAllRecord();
        if (allTrainData != null) {
            for (StationInfoTO cit : allTrainData) {
                jcbSourceID.addItem(cit);
                jcbDestinationID.addItem(cit);
            }
        }
        jcbDepartureTimeHour.removeAllItems();
        jcbDepartureTimeHour.addItem("Select Hour");
        jcbDepartureTimeMinute.removeAllItems();
        jcbDepartureTimeMinute.addItem("Select Minute");
        jcbReachTimeHour.removeAllItems();
        jcbReachTimeHour.addItem("Select Hour");
        jcbReachTimeMinute.removeAllItems();
        jcbReachTimeMinute.addItem("Select Minute");
        for (int hour = 1; hour <= 24; hour++) {
            jcbDepartureTimeHour.addItem(hour);
            jcbReachTimeHour.addItem(hour);
        }
        for (int minute = 1; minute <= 60; minute++) {
            jcbDepartureTimeMinute.addItem(minute);
            jcbReachTimeMinute.addItem(minute);
        }
    }
    TrainInfoTO updateData;
public AddTrainInfo(TrainInfoTO updata){
    this();
    updateData=updata;
    if(updateData!=null){
        jbtnAddTrainInfo.setText("Update Train Info");
        jtfTrainID.setText(updateData.getTrainID());
        jtfTrainName.setText(updateData.getTrainName());
        jtfNumberOfDays.setText(String.valueOf(updateData.getNumberOfDays()));
        jtfDistance.setText(String.valueOf(updateData.getDestinationID()));
        for(int i=1;i<jcbSourceID.getItemCount();i++){
            StationInfoTO cit=(StationInfoTO)jcbSourceID.getItemAt(i);
            if(cit.getStationID().equals(updateData.getSourceID())){
                jcbSourceID.setSelectedIndex(i);
                break;
            }
        }
           for(int i=1;i<jcbDestinationID.getItemCount();i++){
            StationInfoTO cit=(StationInfoTO)jcbDestinationID.getItemAt(i);
            if(cit.getStationID().equals(updateData.getDestinationID())){
                jcbDestinationID.setSelectedIndex(i);
                break;
            }
        }
           String timevalue = updateData.getDepartureTime().toString();
           String[] times = timevalue.split(":");
           int hr = Integer.parseInt(times[0]);
           int min = Integer.parseInt(times[1]);
           for(int i=1;i<jcbDepartureTimeHour.getItemCount();i++){
               int hour = Integer.parseInt(jcbDepartureTimeHour.getItemAt(i).toString());
               if(hour==hr){
                   jcbDepartureTimeHour.setSelectedIndex(i);
                   break;
               }
           }
             String timevalue1 = updateData.getDepartureTime().toString();
           String[] times1 = timevalue.split(":");
           int hr1 = Integer.parseInt(times[0]);
           int min1 = Integer.parseInt(times[1]);
           for(int i=1;i<jcbDepartureTimeMinute.getItemCount();i++){
               int hour = Integer.parseInt(jcbDepartureTimeMinute.getItemAt(i).toString());
               if(hour==hr1){
                   jcbDepartureTimeMinute.setSelectedIndex(i);
                   break;
               }
           }
            String timevalue2 = updateData.getReachTime().toString();
           String[] times2 = timevalue.split(":");
           int hr2 = Integer.parseInt(times[0]);
           int min2 = Integer.parseInt(times[1]);
           for(int i=1;i<jcbReachTimeMinute.getItemCount();i++){
               int hour = Integer.parseInt(jcbReachTimeMinute.getItemAt(i).toString());
               if(hour==hr2){
                   jcbReachTimeMinute.setSelectedIndex(i);
                   break;
               }
           }
             String timevalue3 = updateData.getReachTime().toString();
           String[] times3 = timevalue.split(":");
           int hr3 = Integer.parseInt(times[0]);
           int min3 = Integer.parseInt(times[1]);
           for(int i=1;i<jcbReachTimeHour.getItemCount();i++){
               int hour = Integer.parseInt(jcbReachTimeHour.getItemAt(i).toString());
               if(hour==hr3){
                   jcbReachTimeHour.setSelectedIndex(i);
                   break;
               }
           }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfTrainID = new javax.swing.JTextField();
        jtfDistance = new javax.swing.JTextField();
        jcbSourceID = new javax.swing.JComboBox();
        jcbDestinationID = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jcbDepartureTimeHour = new javax.swing.JComboBox();
        jcbDepartureTimeMinute = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jcbReachTimeHour = new javax.swing.JComboBox();
        jcbReachTimeMinute = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfTrainName = new javax.swing.JTextField();
        jtfNumberOfDays = new javax.swing.JTextField();
        jbtnAddTrainInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add TrainInfo");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Enter Train ID : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 10, 130, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter Train Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Choose Source ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 110, 170, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Departure Time :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 230, 180, 30);
        getContentPane().add(jtfTrainID);
        jtfTrainID.setBounds(270, 10, 290, 30);
        getContentPane().add(jtfDistance);
        jtfDistance.setBounds(270, 400, 290, 30);

        jcbSourceID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbSourceID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSourceIDItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbSourceID);
        jcbSourceID.setBounds(270, 110, 290, 30);

        jcbDestinationID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDestinationID);
        jcbDestinationID.setBounds(270, 170, 290, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Choose Destination ID :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 170, 180, 30);

        jcbDepartureTimeHour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDepartureTimeHour);
        jcbDepartureTimeHour.setBounds(270, 230, 140, 30);

        jcbDepartureTimeMinute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDepartureTimeMinute);
        jcbDepartureTimeMinute.setBounds(420, 230, 140, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Reach Time :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 290, 180, 30);

        jcbReachTimeHour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbReachTimeHour);
        jcbReachTimeHour.setBounds(270, 290, 140, 30);

        jcbReachTimeMinute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbReachTimeMinute);
        jcbReachTimeMinute.setBounds(420, 290, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Distance :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 400, 130, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Number Of Days :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 350, 130, 17);
        getContentPane().add(jtfTrainName);
        jtfTrainName.setBounds(270, 60, 290, 30);
        getContentPane().add(jtfNumberOfDays);
        jtfNumberOfDays.setBounds(270, 350, 290, 30);

        jbtnAddTrainInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnAddTrainInfo.setForeground(new java.awt.Color(0, 255, 153));
        jbtnAddTrainInfo.setText("Add Train Info");
        jbtnAddTrainInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddTrainInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddTrainInfo);
        jbtnAddTrainInfo.setBounds(120, 460, 340, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddTrainInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddTrainInfoActionPerformed
        String message = "";
        try {
            String TrainID = jtfTrainID.getText().trim();
            String TrainName = jtfTrainName.getText().trim();
            String NumberOfDays = jtfNumberOfDays.getText().trim();
            String Distance = jtfDistance.getText().trim();
            if (checks.isEmpty(TrainID) || checks.isEmpty(TrainName)
                    || checks.isEmpty(NumberOfDays) || checks.isEmpty(Distance)) {
                message = "Please Enter Some Value";
            } else if (checks.isNumeric(NumberOfDays) || checks.isNumeric(Distance)) {
                if (jcbSourceID.getSelectedItem() instanceof StationInfoTO && jcbDestinationID.getSelectedItem() instanceof StationInfoTO) {
                    int DepartureMinute = Integer.parseInt(jcbDepartureTimeMinute.getSelectedItem().toString());
                    int DepartureHour = Integer.parseInt(jcbDepartureTimeHour.getSelectedItem().toString());
                    int ReachMinute = Integer.parseInt(jcbReachTimeMinute.getSelectedItem().toString());
                    int ReachHour = Integer.parseInt(jcbReachTimeHour.getSelectedItem().toString());
                    String DepartureTime = DepartureHour + ":" + DepartureMinute + ":0";
                    String ReachTime = ReachHour + ":" + ReachMinute + ":0";
                    StationInfoTO cit = (StationInfoTO) jcbSourceID.getSelectedItem();
                    StationInfoTO sit = (StationInfoTO) jcbDestinationID.getSelectedItem();
                    TrainInfoTO data = new TrainInfoTO();
                    data.setTrainID(TrainID);
                    data.setTrainName(TrainName);
                    data.setNumberOfDays(Integer.parseInt(NumberOfDays));
                    data.setDistance(Integer.parseInt(Distance));
                    data.setSourceID(cit.getStationID());
                    data.setDestinationID(sit.getStationID());
                    data.setDepartureTime(Time.valueOf(DepartureTime));
                    data.setReachTime(Time.valueOf(ReachTime));
                    TrainInfoDAO action = new TrainInfoDAO();
                    if (jbtnAddTrainInfo.getText().contains("Add")) {
                        if (action.insertRecord(data)) {
                            message = "Train Info Inserted";
                            dispose();
                        } else {
                            message = action.getErrorMessage();
                        }
                    } else if (jbtnAddTrainInfo.getText().contains("Update")) {
                        if (action.updateRecord(data)) {
                            message = "Train Info Updated";
                            JOptionPane.showMessageDialog(this, message);
                            ViewTrainInfo obj = new ViewTrainInfo();
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
                    message = "Please Enter TrainName";
                }
            } else {
                message = "Please Enter Numeric Value In NumberOfDays and Distance Boxes ";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddTrainInfoActionPerformed

    private void jcbSourceIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSourceIDItemStateChanged
        jcbDestinationID.removeAllItems();
        jcbDestinationID.addItem("Select A Destination");
        if (jcbSourceID.getSelectedItem() instanceof StationInfoTO) {
            StationInfoTO sit = (StationInfoTO) jcbSourceID.getSelectedItem();
            ArrayList<StationInfoTO> allTrainData = new StationInfoDAO().getAllRecord(sit.getStationID());
            if (allTrainData != null) {
                for (StationInfoTO cit : allTrainData){
                    jcbDestinationID.addItem(cit);
                }
            }
        }
    }//GEN-LAST:event_jcbSourceIDItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbtnAddTrainInfo;
    private javax.swing.JComboBox jcbDepartureTimeHour;
    private javax.swing.JComboBox jcbDepartureTimeMinute;
    private javax.swing.JComboBox jcbDestinationID;
    private javax.swing.JComboBox jcbReachTimeHour;
    private javax.swing.JComboBox jcbReachTimeMinute;
    private javax.swing.JComboBox jcbSourceID;
    private javax.swing.JTextField jtfDistance;
    private javax.swing.JTextField jtfNumberOfDays;
    private javax.swing.JTextField jtfTrainID;
    private javax.swing.JTextField jtfTrainName;
    // End of variables declaration//GEN-END:variables
}
