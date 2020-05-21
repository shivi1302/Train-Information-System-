package admin.ui;

import java.beans.PropertyVetoException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.BookingTableDAO;
import model.dao.LoginInfoDAO;
import model.dao.StationInfoDAO;
import model.dao.TrainInfoDAO;
import model.to.BookingTableTO;
import model.to.LoginInfoTO;
import model.to.StationInfoTO;
import model.to.TrainInfoTO;
import operation.checks;

public class AddBookingTableInfo extends javax.swing.JInternalFrame {

    public String userName;

    public AddBookingTableInfo() {
        initComponents();
        setSize(680, 520);
        jcbJourneyDateYr.removeAllItems();
        jcbJourneyDateYr.addItem("Year");
        jcbJourneyDateMonth.removeAllItems();
        jcbJourneyDateMonth.addItem("Month");
        jcbBookingJourneyDateDate.removeAllItems();
        jcbBookingJourneyDateDate.addItem("Date");
        jcbBookingTrainID.removeAllItems();
        jcbBookingTrainID.addItem("Select Any Train ID");
        jcbBookingStartID.removeAllItems();
        jcbBookingStartID.addItem("Select Any Start ID");
        jcbBookingEndID.removeAllItems();
        jcbBookingEndID.addItem("Select Any End ID");
        jcbTotalTickets.removeAllItems();
        jcbTotalTickets.addItem("Select  No. Of Tickets");
        for (int i = 0; i <= 10; i++) {
            jcbTotalTickets.addItem(i);
        }

        ArrayList<TrainInfoTO> allBookingData = new TrainInfoDAO().getAllRecord();
        if (allBookingData != null) {
            for (TrainInfoTO tit : allBookingData) {
                jcbBookingTrainID.addItem(tit);
            }
        }
        ArrayList<StationInfoTO> allBookingMeta = new StationInfoDAO().getAllRecord();
        if (allBookingMeta != null) {
            for (StationInfoTO sit : allBookingMeta) {
                jcbBookingStartID.addItem(sit);
                jcbBookingEndID.addItem(sit);
            }
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        jcbJourneyDateYr.addItem(year);
        int month = cal.get(Calendar.MONTH) + 1;
        System.out.println(month);
        if (month + 4 > 12) {
            jcbJourneyDateYr.addItem(year + 1);
        }

    }
    BookingTableTO updateData;

    public AddBookingTableInfo(BookingTableTO updata) {
        this();
        updateData = updata;
        if (updateData != null) {
            jbtnAddBookingTableInfo.setText("Update Booking Info");
            for (int i = 1; i < jcbBookingStartID.getItemCount(); i++) {
                StationInfoTO cit = (StationInfoTO) jcbBookingStartID.getItemAt(i);
                if (cit.getStationID().equals(updateData.getStartID())) {
                    jcbBookingStartID.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbBookingEndID.getItemCount(); i++) {
                StationInfoTO cit = (StationInfoTO) jcbBookingEndID.getItemAt(i);
                if (cit.getStationID().equals(updateData.getEndID())) {
                    jcbBookingEndID.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbBookingTrainID.getItemCount(); i++) {
                TrainInfoTO cit = (TrainInfoTO) jcbBookingTrainID.getItemAt(i);
                if (cit.getTrainID().equals(updateData.getTrainID())) {
                    jcbBookingTrainID.setSelectedIndex(i);
                    break;
                }
            }
            for(int i=1;i<jcbTotalTickets.getItemCount();i++){
                int total = Integer.parseInt(jcbTotalTickets.getItemAt(i).toString());
                if(total==updateData.getTotalTickets()){
                    jcbTotalTickets.setSelectedIndex(i);
                }
            }
            String Date = updateData.getJourneyDate().toString();
            System.out.println(Date);
            String[] alldates = Date.split("-");
            int year = Integer.parseInt(alldates[0]);
            int month = Integer.parseInt(alldates[1]);
            int date = Integer.parseInt(alldates[2]);
            System.out.println(year);
            System.out.println(month);
            System.out.println(date);
            for (int i = 1; i < jcbJourneyDateYr.getItemCount(); i++) {
                int yn = Integer.parseInt(jcbJourneyDateYr.getItemAt(i).toString());
                if (year == yn) {
                    jcbJourneyDateYr.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 1; i < jcbJourneyDateMonth.getItemCount(); i++) {
                MonthNames mn = MonthNames.valueOf(jcbJourneyDateMonth.getItemAt(i).toString());
                if (month == mn.ordinal() + 1) {
                    jcbJourneyDateMonth.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbBookingJourneyDateDate.getItemCount(); i++) {
                int n = Integer.parseInt(jcbBookingJourneyDateDate.getItemAt(i).toString());
                if (date == n) {
                    jcbBookingJourneyDateDate.setSelectedIndex(i);
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
        jLabel5 = new javax.swing.JLabel();
        jcbBookingTrainID = new javax.swing.JComboBox();
        jcbBookingStartID = new javax.swing.JComboBox();
        jcbBookingEndID = new javax.swing.JComboBox();
        jbtnAddBookingTableInfo = new javax.swing.JButton();
        jcbJourneyDateYr = new javax.swing.JComboBox();
        jcbJourneyDateMonth = new javax.swing.JComboBox();
        jcbBookingJourneyDateDate = new javax.swing.JComboBox();
        jcbTotalTickets = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Booking Info");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Journey Date :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 230, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Train ID :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Start ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 20, 200, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("End ID :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 70, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Tickets :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 170, 200, 30);

        jcbBookingTrainID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbBookingTrainID);
        jcbBookingTrainID.setBounds(230, 120, 330, 30);

        jcbBookingStartID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbBookingStartID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBookingStartIDItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbBookingStartID);
        jcbBookingStartID.setBounds(230, 20, 330, 30);

        jcbBookingEndID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbBookingEndID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBookingEndIDItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbBookingEndID);
        jcbBookingEndID.setBounds(230, 70, 330, 30);

        jbtnAddBookingTableInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtnAddBookingTableInfo.setText("Add Booking Info");
        jbtnAddBookingTableInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddBookingTableInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddBookingTableInfo);
        jbtnAddBookingTableInfo.setBounds(150, 320, 340, 70);

        jcbJourneyDateYr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbJourneyDateYr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbJourneyDateYrItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbJourneyDateYr);
        jcbJourneyDateYr.setBounds(230, 230, 100, 30);

        jcbJourneyDateMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbJourneyDateMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbJourneyDateMonthItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbJourneyDateMonth);
        jcbJourneyDateMonth.setBounds(340, 230, 100, 30);

        jcbBookingJourneyDateDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbBookingJourneyDateDate);
        jcbBookingJourneyDateDate.setBounds(450, 230, 110, 30);

        jcbTotalTickets.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTotalTickets);
        jcbTotalTickets.setBounds(230, 170, 330, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbJourneyDateMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbJourneyDateMonthItemStateChanged
        try {
            jcbBookingJourneyDateDate.removeAllItems();
            jcbBookingJourneyDateDate.addItem("Date");
            MonthNames selectedMonth = MonthNames.valueOf(jcbJourneyDateMonth.getSelectedItem().toString());
            int dateRange = 31;
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            switch (selectedMonth) {
                case April:
                case June:
                case September:
                case November:
                    dateRange = 30;
                    break;
                case February:
                    GregorianCalendar gcal = new GregorianCalendar();
                    int specialMonth = Integer.parseInt(jcbJourneyDateMonth.getSelectedItem().toString());
                    dateRange = gcal.isLeapYear(specialMonth) ? 29 : 28;
                    break;
            }

            for (int i = 1; i <= dateRange; i++) {
                jcbBookingJourneyDateDate.addItem(i);
            }
            int month = cal.get(Calendar.MONTH);

        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jcbJourneyDateMonthItemStateChanged

    private void jbtnAddBookingTableInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddBookingTableInfoActionPerformed
        String message = "";
        try {
            String TotalTickets = jcbTotalTickets.getSelectedItem().toString();
            if (checks.isEmpty(TotalTickets)) {
                message = "Please Enter Some Value";
            } else if (checks.isNumeric(TotalTickets)) {
                if (jcbBookingTrainID.getSelectedItem() instanceof TrainInfoTO
                        && jcbBookingStartID.getSelectedItem() instanceof StationInfoTO
                        && jcbBookingEndID.getSelectedItem() instanceof StationInfoTO) {
                    MonthNames selectedMonth = MonthNames.valueOf(jcbJourneyDateMonth.getSelectedItem().toString());
                    int selectedDate = Integer.parseInt(jcbBookingJourneyDateDate.getSelectedItem().toString());
                    int selectedYear = Integer.parseInt(jcbJourneyDateYr.getSelectedItem().toString());
                    String JourneyDate = selectedYear + "-" + (selectedMonth.ordinal() + 1) + "-" + selectedDate;

                    StationInfoTO sit = (StationInfoTO) jcbBookingStartID.getSelectedItem();
                    StationInfoTO eit = (StationInfoTO) jcbBookingEndID.getSelectedItem();
                    TrainInfoTO tit = (TrainInfoTO) jcbBookingTrainID.getSelectedItem();


                    BookingTableTO data = new BookingTableTO();
                    data.setJourneyDate(java.sql.Date.valueOf(JourneyDate));
                    data.setTrainID(tit.getTrainID());

                    data.setStartID(sit.getStationID());
                    data.setEndID(eit.getStationID());
                    data.setUserName(userName);

                    data.setTotalTickets(Integer.parseInt(TotalTickets));
                    BookingTableDAO action = new BookingTableDAO();
                    if (jbtnAddBookingTableInfo.getText().contains("Add")) {
                        int id = action.insertRecord(data);
                        if (id != 0) {
                            message = "Record Inserted";
                            AddPassengerInfo obj = new AddPassengerInfo();
                            obj.BookID = id;
                            obj.setVisible(true);
                            JDesktopPane jdp = getDesktopPane();
                            jdp.add(obj);
                            dispose();

                        } else {
                            message = action.getErrorMessage();
                        }
                    } else if (jbtnAddBookingTableInfo.getText().contains("Update")) {
                        if (action.updateRecord(data)) {
                            message = "Record Updated";
                            JOptionPane.showMessageDialog(this, message);
                            ViewBookingTableInfo obj = new ViewBookingTableInfo();
                            obj.setSelected(true);
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
                    message = "Please Enter Numeric Value In TotalTickets";
                }
            } else {
                message = "Please Enter Numeric Value In TotalTickets";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
            ex.printStackTrace();

        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jbtnAddBookingTableInfoActionPerformed

    private void jcbBookingStartIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBookingStartIDItemStateChanged
        jcbBookingEndID.removeAllItems();
        jcbBookingEndID.addItem("Select A Destination");
        if (jcbBookingStartID.getSelectedItem() instanceof StationInfoTO) {
            StationInfoTO sit = (StationInfoTO) jcbBookingStartID.getSelectedItem();
            ArrayList<StationInfoTO> allTrainData = new StationInfoDAO().getAllRecord(sit.getStationID());
            if (allTrainData != null) {
                for (StationInfoTO cit : allTrainData) {
                    jcbBookingEndID.addItem(cit);
                }
            }
        }
    }//GEN-LAST:event_jcbBookingStartIDItemStateChanged

    private void jcbBookingEndIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBookingEndIDItemStateChanged
        jcbBookingTrainID.removeAllItems();
        jcbBookingTrainID.addItem("Select Any TrainID");
        if (jcbBookingEndID.getSelectedItem() instanceof StationInfoTO && jcbBookingStartID.getSelectedItem() instanceof StationInfoTO) {
            StationInfoTO st1 = (StationInfoTO) jcbBookingStartID.getSelectedItem();
            StationInfoTO st2 = (StationInfoTO) jcbBookingEndID.getSelectedItem();
            ArrayList<TrainInfoTO> allTrains = new TrainInfoDAO().getAllRecord(st1.getStationID(), st2.getStationID());
            if (allTrains != null) {
                for (TrainInfoTO tt : allTrains) {
                    jcbBookingTrainID.addItem(tt);
                }
            }
        }
    }//GEN-LAST:event_jcbBookingEndIDItemStateChanged

    private void jcbJourneyDateYrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbJourneyDateYrItemStateChanged
        try {
            jcbJourneyDateMonth.removeAllItems();
            jcbJourneyDateMonth.addItem("Month");
            int yr = Integer.parseInt(jcbJourneyDateYr.getSelectedItem().toString());
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            MonthNames[] allMonths = MonthNames.values();
            if (yr == year) {

                for (int i = month - 1; i < allMonths.length; i++) {
                    jcbJourneyDateMonth.addItem(allMonths[i]);
                }
            } else {
                int val = month - 12;
                for (int i = 0; i < val; i++) {
                    jcbJourneyDateMonth.addItem(allMonths[i]);
                }
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jcbJourneyDateYrItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtnAddBookingTableInfo;
    private javax.swing.JComboBox jcbBookingEndID;
    private javax.swing.JComboBox jcbBookingJourneyDateDate;
    private javax.swing.JComboBox jcbBookingStartID;
    private javax.swing.JComboBox jcbBookingTrainID;
    private javax.swing.JComboBox jcbJourneyDateMonth;
    private javax.swing.JComboBox jcbJourneyDateYr;
    private javax.swing.JComboBox jcbTotalTickets;
    // End of variables declaration//GEN-END:variables
}
