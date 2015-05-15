/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ClinicVaccineOrderRequestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private ClinicOrganization clinicOrganization;
    private EcoSystem ecoSystem;
    public ClinicVaccineOrderRequestWorkAreaJPanel(JPanel upc,UserAccount account,Enterprise enterprise, ClinicOrganization clinicOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
        this.clinicOrganization = clinicOrganization;
        this.ecoSystem = ecoSystem;
        populateTable();
    }

    public void populateTable(){
         DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
         dtm.setRowCount(0);
         
         for(WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()){
             if(workRequest instanceof OrderRequest){
             OrderRequest or = (OrderRequest)workRequest;
             Object[] row = new Object[5];
             row[0] = or.getVaccineName();
             row[1] = or.getQuantity();
             row[2] = workRequest.getSender();
             row[3] = workRequest.getStatus();
             row[4] = or.getOrderResult()== null ? "Waiting" : or.getOrderResult();
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Sender", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 419, 89));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC REQUEST ORDER WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        backjButton.setText("<<Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 152, -1, -1));

        RequestOrderjButton.setText("Request Order");
        RequestOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestOrderjButtonActionPerformed(evt);
            }
        });
        add(RequestOrderjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void RequestOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestOrderjButtonActionPerformed
        ClinicVaccineRequestOrderJPanel cvrojp = new ClinicVaccineRequestOrderJPanel(userProcessContainer, account, enterprise, clinicOrganization, ecoSystem);
        userProcessContainer.add("ClinicRequestOrderJPanel", cvrojp);
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RequestOrderjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
