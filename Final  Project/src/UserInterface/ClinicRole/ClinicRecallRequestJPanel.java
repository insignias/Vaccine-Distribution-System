/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.ManufacturerOrganization;
import Business.Organization.Organization;
import Business.Person.Clinician;
import Business.Person.Person;
import Business.Person.Vaccine;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.RecallRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ClinicRecallRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ClinicEnterprise clinicEnterprise;
    private ClinicOrganization clinicOrganization;
    private EcoSystem ecoSystem;
    public ClinicRecallRequestJPanel(JPanel upc, ClinicEnterprise clinicEnterprise, UserAccount account, ClinicOrganization clinicOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.clinicOrganization = clinicOrganization;
        this.account = account;
        this.clinicEnterprise = clinicEnterprise;
        populatevaccineDistributionTable();
    }

    private void populatevaccineDistributionTable(){
        DefaultTableModel dtm = (DefaultTableModel)recalljTable.getModel();
        dtm.setRowCount(0);
        
//        RecallRequest rr = null;
        for(WorkRequest wr : clinicOrganization.getWorkQueue().getWorkRequestList()){
            if(wr instanceof RecallRequest){
                RecallRequest rr = (RecallRequest)wr;
                Object[] row = new Object[8];
                row[0] = rr;
                row[1] = rr.getLotNumber();
                row[2] = rr.getQuantity();
                row[3] = rr.getMessage();
                row[4] = rr.getSender();
                row[5] = rr.getReceiver() == null ? null : rr.getReceiver().getPerson().getName();
                row[6] = rr.getStatus();
                row[7] = rr.getRecallResult();
                dtm.addRow(row);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recalljTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();
        processjButton = new javax.swing.JButton();
        assignjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC RECALL REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        recalljTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Lot Number", "Quantity", "Recall Reason", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recalljTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 640, 88));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = recalljTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)recalljTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(account);
            System.out.println("receiver: " +request.getReceiver().getPerson().getName());
            request.setStatus("Pending");
            populatevaccineDistributionTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = recalljTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        RecallRequest request = (RecallRequest)recalljTable.getValueAt(selectedRow, 0);
        
        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(account.getPerson().getName())){
                if(!request.getRecallResult().equals("Completed")){
                    request.setStatus("Completed");
                    request.setRecallResult("Completed");
                    populatevaccineDistributionTable();
                        for(Person p : clinicOrganization.getPersonDirectory().getPersonList()){
                            if(p instanceof Clinician){
                                Clinician clinician = (Clinician)p;
                                for(Vaccine v : clinician.getVaccineCatalog().getVaccineCatalog()){
                                    if(v.getLotNumber().equals(request.getLotNumber())){
                                        clinician.getVaccineCatalog().removeVaccine(v);
                                        break;
                                    }
                                }
                            }
                        }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Result already processed ");
                    return;
                }
            }
        }
        if(request.getReceiver() == null){
            JOptionPane.showMessageDialog(null, "Please assign a receiver ");
            return;
        }
//        for(Network n : ecoSystem.getNetworkList()){
//            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
//                if(e instanceof ManufacturerEnterprise){
//                    for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
//                        if(o instanceof ManufacturerOrganization){
//                            for()
//                        }
//                    }
//                }
//            }
//        }
        
        
    }//GEN-LAST:event_processjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populatevaccineDistributionTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processjButton;
    private javax.swing.JTable recalljTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
