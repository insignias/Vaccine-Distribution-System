/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManufacturerRole;

import Business.EcoSystem;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.ManufacturerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReactionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManageCDCVaccineRecallRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private ManufacturerOrganization manOrg;
    private UserAccount ua;
    private ManufacturerEnterprise manEnt;
    public ManageCDCVaccineRecallRequestJPanel(JPanel upc, ManufacturerEnterprise manEnt, UserAccount ua, ManufacturerOrganization manOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.ua = ua;
        this.manOrg = manOrg;
        this.manEnt = manEnt;
        populateRecallRequestTable();
    }

    private void populateRecallRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)recallrequestjTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest workRequest : manOrg.getWorkQueue().getWorkRequestList()){
            if(workRequest instanceof ReactionRequest){
                ReactionRequest rr = (ReactionRequest)workRequest;
                Object[] row = new Object[7];
                row[0] = rr;
                row[1] = rr.getMessage();
                row[2] = rr.getLotNumber();
                row[3] = rr.getManufacturer();
                row[4] = rr.getSender();
                row[5] = rr.getReceiver();
                row[6] = rr.getStatus();
                dtm.addRow(row);
                
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        recallrequestjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        acknowledgejButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        assignjButton = new javax.swing.JButton();

        recallrequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Message", "LOT Number", "Manufacturer", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(recallrequestjTable);

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANUFACTURER MANAGE VACCINE RECALL REQUEST");

        acknowledgejButton.setText("Acknowledge");
        acknowledgejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acknowledgejButtonActionPerformed(evt);
            }
        });

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton1)
                        .addGap(102, 102, 102)
                        .addComponent(assignjButton)
                        .addGap(72, 72, 72)
                        .addComponent(acknowledgejButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acknowledgejButton)
                    .addComponent(backJButton1)
                    .addComponent(assignjButton))
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void acknowledgejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acknowledgejButtonActionPerformed
        int selectedRow = recallrequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        
        ReactionRequest rr = (ReactionRequest)recallrequestjTable.getValueAt(selectedRow, 0);
        if(rr.getReceiver() != null){
            if(!rr.getStatus().equals("Recalled")){
                rr.setStatus("Recalled");
                populateRecallRequestTable();
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Request already completed"); 
            }
        }
        if(rr.getReceiver() == null){
            JOptionPane.showMessageDialog(null, "Please assign a receiver ");
            //return;
        }
    }//GEN-LAST:event_acknowledgejButtonActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = recallrequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        ReactionRequest request = (ReactionRequest)recallrequestjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(ua);
            request.setStatus("Pending");
            populateRecallRequestTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
//            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acknowledgejButton;
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recallrequestjTable;
    // End of variables declaration//GEN-END:variables
}
