/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.HospitalRole;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
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
public class EnrollmentRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private HospitalEnterprise hospitalEnterprise;
    private EcoSystem ecoSystem;
    public EnrollmentRequestWorkAreaJPanel(JPanel upc, UserAccount ua, HospitalEnterprise hospitalEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.hospitalEnterprise = hospitalEnterprise;
        this.ua = ua;
        this.ecoSystem = ecoSystem;
        populateTable();
        
    }

    public void populateTable(){
         DefaultTableModel dtm = (DefaultTableModel)providerEnrollmentRequestjTable.getModel();
         dtm.setRowCount(0);
         
         for(WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()){
             if(workRequest instanceof EnrollmentRequest){
             Object[] row = new Object[4];
             row[0] = workRequest.getMessage();
             row[1] = workRequest.getSender();
             row[2] = workRequest.getStatus();
             EnrollmentRequest er = (EnrollmentRequest)workRequest;
             row[3] = er.getResult()== null ? "Waiting" : er.getResult();
             dtm.addRow(row);
             }
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RefreshjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        requestEnrollmentjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        providerEnrollmentRequestjTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RefreshjButton.setText("Refresh");
        RefreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshjButtonActionPerformed(evt);
            }
        });
        add(RefreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 169, -1, -1));

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 169, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("HOSPITAL ENROLLMENT REQUEST WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        requestEnrollmentjButton.setText("Request Enrollment >>");
        requestEnrollmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestEnrollmentjButtonActionPerformed(evt);
            }
        });
        add(requestEnrollmentjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        providerEnrollmentRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(providerEnrollmentRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 375, 95));
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshjButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_RefreshjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void requestEnrollmentjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestEnrollmentjButtonActionPerformed
        RequestHospitalEnrollmentJPanel rhejp = new RequestHospitalEnrollmentJPanel(userProcessContainer, ua, hospitalEnterprise, ecoSystem);
        userProcessContainer.add("RequestHospitalEnrollmentJPanel", rhejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestEnrollmentjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable providerEnrollmentRequestjTable;
    private javax.swing.JButton requestEnrollmentjButton;
    // End of variables declaration//GEN-END:variables
}
