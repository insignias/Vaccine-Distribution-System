/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.PatientRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ClinicOrderRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ClinicEnterprise clinicenterprise;
    private ClinicOrganization clinicOrganization;
    private EcoSystem ecoSystem;
    public ClinicOrderRequestWorkAreaJPanel(JPanel upc,UserAccount account,ClinicEnterprise clinicenterprise, ClinicOrganization clinicOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.clinicenterprise = clinicenterprise;
        this.clinicOrganization = clinicOrganization;
        this.ecoSystem = ecoSystem;
        populateTable();
    }

    private void populateTable(){
         DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
         dtm.setRowCount(0);
         
         for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
             if(workRequest instanceof PatientRequest){
             PatientRequest pr = (PatientRequest)workRequest;
             Object[] row = new Object[8];
             row[0] = pr;
             row[1] = pr.getRequestID();
             row[2] = pr.getInsuranceInfo();
             row[3] = pr.getVaccineName();
             row[4] = pr.getQuantity();
             row[5] = pr.getTotalPrice();
             row[6] = pr.getSender();
             row[7] = pr.getStatus();
             dtm.addRow(row);
             }
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderRequestjTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backjButton = new javax.swing.JButton();
        RequestOrderjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        paymentStatusjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Request ID", "Insurance Info", "Vaccine Name", "Quantity", "Total Price", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 670, 89));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC ORDER REQUEST WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        RequestOrderjButton.setText("Request Order");
        RequestOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestOrderjButtonActionPerformed(evt);
            }
        });
        add(RequestOrderjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        paymentStatusjButton.setText("Payment Status");
        paymentStatusjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentStatusjButtonActionPerformed(evt);
            }
        });
        add(paymentStatusjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void RequestOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestOrderjButtonActionPerformed
        ClinicPatientOrderRequestJPanel cporjp = new ClinicPatientOrderRequestJPanel(userProcessContainer, account, clinicenterprise, clinicOrganization, ecoSystem);
        userProcessContainer.add("ClinicPatientOrderRequestJPanel", cporjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_RequestOrderjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void paymentStatusjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentStatusjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        PatientRequest request = (PatientRequest)orderRequestjTable.getValueAt(selectedRow, 0);
        ClinicPaymentStatusJPanel cpsjp = new ClinicPaymentStatusJPanel(userProcessContainer, request, clinicOrganization);
        userProcessContainer.add("ClinicPaymentStatusJPanel", cpsjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
    }//GEN-LAST:event_paymentStatusjButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RequestOrderjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JButton paymentStatusjButton;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
