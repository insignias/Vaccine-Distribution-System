/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ProviderRole;

import Business.EcoSystem;
import Business.Enterprise.ProviderEnterprise;
import Business.Organization.Organization;
import Business.Organization.ProviderOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EnrollmentRequest;
import Business.WorkQueue.WorkRequest;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManageEnrollmentRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private EcoSystem ecoSystem;
    private ProviderEnterprise enterprise;
    public ManageEnrollmentRequestJPanel(JPanel upc, UserAccount ua, ProviderEnterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ua = ua;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        populateTable();
    }

        private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)enrollmentjTable.getModel();
        dtm.setRowCount(0);
        System.out.println("here in the workrequest table1");
//        Organization org = null;
        for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(o instanceof ProviderOrganization){
              Organization org = o;
//                break;
//            }
//        }
                for(WorkRequest request : org.getWorkQueue().getWorkRequestList()){
                    if( request instanceof EnrollmentRequest){
                    System.out.println("here in the workrequest table2");
                    Object[] row = new Object[4];
                    row[0] = request;
                    row[1] = request.getSender().getPerson().getName();
                    row[2] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
                    row[3] = request.getStatus();
                    dtm.addRow(row);
                }
            }
        }
    }
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        processJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        enrollmentjTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 216, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PROVIDER MANAGE ENROLLMENT WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 169, -1, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 169, -1, -1));

        enrollmentjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enrollmentjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, -1, 95));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
         userProcessContainer.remove(this);
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
         layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = enrollmentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        EnrollmentRequest request = (EnrollmentRequest)enrollmentjTable.getValueAt(selectedRow, 0);
        
        
        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(ua.getPerson().getName())){
                    
                
                
                request.setStatus("Processing");
                
                ProcessWorkRequestJPanel pwrjp = new ProcessWorkRequestJPanel(userProcessContainer,enterprise,request,ecoSystem);
                userProcessContainer.add("ProcessWorkRequestJPanel", pwrjp);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
        }
    
            else
            {
                JOptionPane.showMessageDialog(null, "Request is assigned to : " +request.getReceiver() );
                return;
            }
        }
        if(request.getReceiver() == null){
            JOptionPane.showMessageDialog(null, "Please assign a receiver ");
            return;
        }
    }//GEN-LAST:event_processJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
         int selectedRow = enrollmentjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)enrollmentjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(ua);
            request.setStatus("Pending");
            populateTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
            return;
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JTable enrollmentjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    // End of variables declaration//GEN-END:variables
}
