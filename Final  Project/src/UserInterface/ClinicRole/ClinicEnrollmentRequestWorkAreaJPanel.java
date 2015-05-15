/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EnrollmentRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ClinicEnrollmentRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    public ClinicEnrollmentRequestWorkAreaJPanel(JPanel upc,UserAccount account,Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        populateTable();
    }

     public void populateTable(){
         DefaultTableModel dtm = (DefaultTableModel)clinicEnrollmentRequestjTable.getModel();
         dtm.setRowCount(0);
         
         for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
             Object[] row = new Object[4];
             row[0] = workRequest.getMessage();
             row[1] = workRequest.getSender();
             row[2] = workRequest.getStatus();
             EnrollmentRequest er = (EnrollmentRequest)workRequest;
             row[3] = er.getResult()== null ? "Waiting" : er.getResult();
             dtm.addRow(row);
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clinicEnrollmentRequestjTable = new javax.swing.JTable();
        requestEnrollmentjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        RefreshjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clinicEnrollmentRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(clinicEnrollmentRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 375, 95));

        requestEnrollmentjButton.setText("Request Enrollment >>");
        requestEnrollmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestEnrollmentjButtonActionPerformed(evt);
            }
        });
        add(requestEnrollmentjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 169, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 169, -1, -1));

        jLabel1.setText("CLINIC ENROLLMENT REQUEST WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        RefreshjButton.setText("Refresh");
        RefreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshjButtonActionPerformed(evt);
            }
        });
        add(RefreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 169, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestEnrollmentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestEnrollmentjButtonActionPerformed
        ClinicRequestEnrollmentJPanel crejp = new ClinicRequestEnrollmentJPanel(userProcessContainer, account, enterprise, ecoSystem);
        userProcessContainer.add("ClinicRequestEnrollmentJPanel", crejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestEnrollmentjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void RefreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshjButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_RefreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JTable clinicEnrollmentRequestjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton requestEnrollmentjButton;
    // End of variables declaration//GEN-END:variables
}
