package admin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.StationInfoDAO;
import model.to.StationInfoTO;

public class ViewStationInfo extends javax.swing.JInternalFrame {
 ArrayList<StationInfoTO> allStationData;
 int row;
    JPopupMenu jpopup; 
    public ViewStationInfo() {
        initComponents();
        setSize(650,450);
        row=-1;
        bindTableData();
        jpopup=new JPopupMenu();
        JMenuItem jmiUpdate=new JMenuItem("Update this Record");
        jpopup.add(jmiUpdate);
        JMenuItem jmiDelete=new JMenuItem("Delete this Record");
        jpopup.add(jmiDelete);
        jmiDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                deleteRecord();
            }
        });
        jmiUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              updateRecord();
            }
        });
    }

    private void updateRecord(){
        if(row!=-1){
            StationInfoTO cit=allStationData.get(row);
            if(cit!=null){
                AddStationInfo obj=new AddStationInfo(cit);
                obj.setVisible(true);
                obj.setTitle("Update Station Info");
                JDesktopPane jdp=getDesktopPane();
                jdp.add(obj);
                try{
                    obj.setSelected(true);
                }catch(PropertyVetoException ex){
                    
                }
                dispose();
            }
        }
    }
    private void deleteRecord(){
        if(row!=-1){
            StationInfoTO cit=allStationData.get(row);
            if(cit!=null){
                int result= JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Delete This Record" ,
                        "Message From Admin",JOptionPane.OK_CANCEL_OPTION);
                if(result==JOptionPane.OK_OPTION){
                  StationInfoDAO action=new StationInfoDAO();
                  if(action.deleteRecord(cit.getStationID())){
                      JOptionPane.showMessageDialog(this,"Record is Deleted");
                      bindTableData();
                      row=-1;
                  }else{
                      JOptionPane.showMessageDialog(this,action.getErrorMessage() );
                  }
                }
            }
        }
    
    }
private void bindTableData(){
    allStationData=new StationInfoDAO().getAllRecord();
    if(allStationData!=null && allStationData.size()!=0){
        int totalRows=allStationData.size();
        String[] columnNames={"Station ID" , "Station Name"};
        Object allData[][]=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
           StationInfoTO cit=allStationData.get(i);
           allData[i]=new Object[2];
           allData[i][0]=cit.getStationID();
           allData[i][1]=cit.getStationName();
        }
        DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
        jtStationInfo.setModel(dtm);
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtStationInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Station Info");

        jtStationInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtStationInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtStationInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtStationInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtStationInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStationInfoMouseClicked
       if(evt.getButton()==MouseEvent.BUTTON3){
           int idx=jtStationInfo.rowAtPoint(evt.getPoint());
           jtStationInfo.getSelectionModel().setSelectionInterval(idx,idx);
           row=jtStationInfo.getSelectedRow();
           System.out.println(row);
           jpopup.show(jtStationInfo,evt.getX(),evt.getY());
       }
    }//GEN-LAST:event_jtStationInfoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtStationInfo;
    // End of variables declaration//GEN-END:variables
}
