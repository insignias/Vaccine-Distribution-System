/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManufacturerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Network.Network;
import Business.Organization.HospitalOrganization;
import Business.Organization.ManufacturerOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.RecallRequest;
import Business.WorkQueue.ShippingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManageVaccineAdverseEventJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ManufacturerOrganization manOrg;
    private UserAccount ua;
    private ManufacturerEnterprise manEnt;
    public ManageVaccineAdverseEventJPanel(JPanel upc, ManufacturerEnterprise manEnt, UserAccount ua, ManufacturerOrganization manOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.ua = ua;
        this.manOrg = manOrg;
        this.manEnt = manEnt;
        populaterecallTable();
        
    }

//    private void populatevaccineDistributionTable(ShippingRequest sr){
//        DefaultTableModel dtm = (DefaultTableModel)vaccineDistributionLocationjTable.getModel();
//        dtm.setRowCount(0);
//        
//        Object[] row = new Object[6];
//        row[0] = sr;
//        row[1] = sr.getLotNumber();
//        row[2] = sr.getQuantity();
//        row[3] = sr.getEnterpriseType();
//        row[4] = sr.getEnterpriseName();
//        row[5] = sr.getLocation();
//        dtm.addRow(row);
//        
//    }
    
    private void populaterecallTable(){
        DefaultTableModel dtm = (DefaultTableModel)recalljTable.getModel();
        dtm.setRowCount(0);
//        RecallRequest rr = null;
        for(WorkRequest wr : ua.getWorkQueue().getWorkRequestList()){
            if(wr instanceof RecallRequest){
                RecallRequest rr = (RecallRequest)wr;
                
                Object[] row = new Object[7];
                row[0] = rr;
                row[1] = rr.getLotNumber();
                row[2] = rr.getQuantity();
                row[3] = rr.getMessage();
                row[4] = rr.getSender();
                row[5] = rr.getStatus();
                row[6] = rr.getRecallResult();
                dtm.addRow(row);
           }
    }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lotNumberjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineDistributionLocationjTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        submitjButton = new javax.swing.JButton();
        recalljButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        recallReasonjTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        recalljTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();

        jLabel1.setText("LOT number to be recalled:");

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("MANUFACTURER MANAGE ADVERSE EVENT");

        vaccineDistributionLocationjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "LOT Number", "Quantity", "Enterprise Type", "Enterprise Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineDistributionLocationjTable);

        jLabel3.setText("Hospitals/Pharmacies where the LOT was distributed:");

        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });

        recalljButton.setText("Recall");
        recalljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recalljButtonActionPerformed(evt);
            }
        });

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Recall Reason:");

        recalljTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Lot Number", "Quantity", "Recall Reason", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(recalljTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(recallReasonjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(recalljButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton1)
                                .addGap(29, 29, 29)
                                .addComponent(refreshjButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lotNumberjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(submitjButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lotNumberjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitjButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(recallReasonjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recalljButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(refreshjButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)vaccineDistributionLocationjTable.getModel();
        dtm.setRowCount(0);
        String lotNumber;
        try
        {
        lotNumber = lotNumberjTextField.getText();
        if ((lotNumberjTextField.getText().startsWith(" ")) || (lotNumberjTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        boolean flag = false;
        for(WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof ShippingRequest){
                ShippingRequest sr = (ShippingRequest)workRequest;
                for(WorkRequest wr : manOrg.getWorkQueue().getWorkRequestList()){
                    if(wr instanceof OrderRequest){
                       OrderRequest or = (OrderRequest)wr;
                       if(sr.getRequestID() == or.getRequestID()){
                           if(sr.getLotNumber().equalsIgnoreCase(lotNumber)){
                               Object[] row = new Object[6];
                                row[0] = sr;
                                row[1] = sr.getLotNumber();
                                row[2] = sr.getQuantity();
                                row[3] = sr.getEnterpriseType();
                                row[4] = sr.getEnterpriseName();
                                row[5] = sr.getLocation();
                                dtm.addRow(row);
//                               populatevaccineDistributionTable(sr);
                               flag = true;
                               break;
                           }
                           
                       }
                    }
                }
            }
        }
        if(flag == false)
                           {
                               JOptionPane.showMessageDialog(null, "LOT number not found");
                               return;
                           }
    }//GEN-LAST:event_submitjButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void recalljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recalljButtonActionPerformed
        String recallReason = recallReasonjTextField.getText();
        int selectedRow = vaccineDistributionLocationjTable.getSelectedRow();

        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row from the Table");
            return;
        }
        
        ShippingRequest sr = (ShippingRequest)vaccineDistributionLocationjTable.getValueAt(selectedRow, 0);
        
        RecallRequest recallRequest = new RecallRequest();
        recallRequest.setMessage(recallReason);
        recallRequest.setRequestID(sr.getRequestID());
        recallRequest.setVaccineName(sr.getVaccineName());
        recallRequest.setEnterpriseType(sr.getEnterpriseType());
        recallRequest.setEnterpriseName(sr.getEnterpriseName());
        recallRequest.setLocation(sr.getLocation());
        recallRequest.setLotNumber(sr.getLotNumber());
        recallRequest.setQuantity(sr.getQuantity());
        recallRequest.setSender(ua);
        recallRequest.setStatus("Sent");
        recallRequest.setRecallResult("Waiting");
        
        
         Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
//                System.out.println("enterprise: " +e);
                if(recallRequest.getLocation().equals(e.getLocation())){
                    //System.out.println("hospitalEnterprise.getLocation(): " +hospitalEnterprise.getLocation());
                    System.out.println("e.getLocation(): " +e.getLocation());
                    System.out.println("beforeif enterpriseType: " +e.getEnterpriseType().getValue());
                    if(e.getEnterpriseType().getValue().equals(recallRequest.getEnterpriseType())){
                        if(e.getName().equals(recallRequest.getEnterpriseName())){
                        System.out.println("enterpriseType: " +e.getEnterpriseType().getValue());
                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                            System.out.println("organization: " +o.getName());
                            if(o instanceof HospitalOrganization){
                            System.out.println("instance of Hospital Organization");
                            org = o;
                            flag = true;
                            break;
                        }
                            if(o instanceof PharmaceuticalOrganization){
                            System.out.println("instance of Pharmaceutical Organization");
                            org = o;
                            flag = true;
                            break;
                        }
                    }
                }
             }
            }
                if(flag==true)
                {
                    break;
                }
        }
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(recallRequest);
                ua.getWorkQueue().getWorkRequestList().add(recallRequest);
                System.out.println("recall request added to Hospital org");
                populaterecallTable();
        }
        } 
    }//GEN-LAST:event_recalljButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populaterecallTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lotNumberjTextField;
    private javax.swing.JTextField recallReasonjTextField;
    private javax.swing.JButton recalljButton;
    private javax.swing.JTable recalljTable;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JButton submitjButton;
    private javax.swing.JTable vaccineDistributionLocationjTable;
    // End of variables declaration//GEN-END:variables
}
