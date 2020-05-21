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
import model.dao.TrainTypeDAO;
import model.to.TrainTypeTO;

public class ViewTrainType extends javax.swing.JInternalFrame {
 ArrayList<TrainTypeTO> allTrainTypeData;
 int row;   
 JPopupMenu jpopup;
    public ViewTrainType() {
        initComponents();
        setSize(650,450);
        row=-1;
        bindTableData();
        jpopup=new JPopupMenu();
        JMenuItem jmiUpdate=new JMenuItem("Update This Record");
        jpopup.add(jmiUpdate);
        JMenuItem jmiDelete=new JMenuItem("Delete This Record");
        jpopup.add(jmiDelete);
        jmiDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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
    private void deleteRecord(){
        if(row!=-1){
            TrainTypeTO cit=allTrainTypeData.get(row);
            if(cit!=null){
                int result= JOptionPane.showConfirmDialog(this,"Are You Sure You "
           + "Want To Delete This Record ","Message From Admin",JOptionPane.OK_CANCEL_OPTION);
                if(result==JOptionPane.OK_OPTION){
                    TrainTypeDAO action=new TrainTypeDAO();
                    if(action.deleteRecord(cit.getTypeID())){
                        JOptionPane.showMessageDialog(this,"Record Is Deleted");
                        bindTableData();
                        row=-1;
                    }else{
                        JOptionPane.showMessageDialog(this,action.getErrorMessage());
                    }
                }
            }
        }
    }
    private void updateRecord(){
        if(row!=-1){
            TrainTypeTO cit=allTrainTypeData.get(row);
            if(cit!=null){
                AddTrainType obj=new AddTrainType(cit);
                obj.setVisible(true);
                obj.setTitle("Update Train Type");
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
private void bindTableData(){
    allTrainTypeData=new TrainTypeDAO().getAllRecord();
    if(allTrainTypeData!=null && allTrainTypeData.size()!=0){
        int totalRows=allTrainTypeData.size();
        String[] columnNames={"TypeName","TypeID","ExtraCharge"};
        Object allData[] []=new Object[totalRows][columnNames.length];
        for(int i=0;i<totalRows;i++){
            TrainTypeTO cit=allTrainTypeData.get(i);
            allData[i]=new Object[columnNames.length];
            allData[i][0]=cit.getTypeName();
            allData[i][1]=cit.getTypeID();
            allData[i][2]=cit.getExtraCharge();
        }
         DefaultTableModel dtm=new DefaultTableModel(allData,columnNames);
         jtViewTrainType.setModel(dtm);
    }
    
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtViewTrainType = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Train Type");

        jtViewTrainType.setModel(new javax.swing.table.DefaultTableModel(
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
        jtViewTrainType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtViewTrainTypeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtViewTrainType);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtViewTrainTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtViewTrainTypeMouseClicked
        if(evt.getButton()== MouseEvent.BUTTON3){
            int idx=jtViewTrainType.rowAtPoint(evt.getPoint());
            jtViewTrainType.getSelectionModel().setSelectionInterval(idx, idx);
            row=jtViewTrainType.getSelectedRow();
            System.out.println(row);
            jpopup.show(jtViewTrainType,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_jtViewTrainTypeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtViewTrainType;
    // End of variables declaration//GEN-END:variables
}
