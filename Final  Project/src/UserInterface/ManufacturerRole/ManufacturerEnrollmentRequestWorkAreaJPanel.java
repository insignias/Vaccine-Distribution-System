/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ManufacturerRole;

import UserInterface.ProviderRole.*;
import Business.EcoSystem;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.ProviderEnterprise;
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
public class ManufacturerEnrollmentRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private ManufacturerEnterprise enterprise;
    private EcoSystem ecoSystem;
    public ManufacturerEnrollmentRequestWorkAreaJPanel(JPanel upc,UserAccount ua, ManufacturerEnterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ua = ua;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        populateTable();
    }

    private void populateTable(){
         DefaultTableModel dtm = (DefaultTableModel)ManufacturerEnrollmentRequestjTable.getModel();
         dtm.setRowCount(0);
         
         for(WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()){
             if(workRequest instanceof EnrollmentRequest){
                 EnrollmentRequest er = (EnrollmentRequest)workRequest;
             Object[] row = new Object[4];
             row[0] = workRequest.getMessage();
             row[1] = workRequest.getSender();
             row[2] = workRequest.getStatus();
             row[3] = er.getResult()== null ? "Waiting" : er.getResult();
             dtm.addRow(row);
             }
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        RefreshjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ManufacturerEnrollmentRequestjTable = new javax.swing.JTable();
        requestEnrollmentjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANUFACTURER ENROLLMENT REQUEST WORK AREA");

        RefreshjButton.setText("Refresh");
        RefreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshjButtonActionPerformed(evt);
            }
        });

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        ManufacturerEnrollmentRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ManufacturerEnrollmentRequestjTable);

        requestEnrollmentjButton.setText("Request Enrollment >>");
        requestEnrollmentjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestEnrollmentjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(backjButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RefreshjButton)
                            .addGap(27, 27, 27)
                            .addComponent(requestEnrollmentjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton)
                    .addComponent(requestEnrollmentjButton)
                    .addComponent(RefreshjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
        ManufacturerRequestEnrollmentJPanel mrejp = new ManufacturerRequestEnrollmentJPanel(userProcessContainer, ua, enterprise, ecoSystem);
        userProcessContainer.add("ManufacturerRequestEnrollmentJPanel", mrejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestEnrollmentjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ManufacturerEnrollmentRequestjTable;
    private javax.swing.JButton RefreshjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton requestEnrollmentjButton;
    // End of variables declaration//GEN-END:variables
}
