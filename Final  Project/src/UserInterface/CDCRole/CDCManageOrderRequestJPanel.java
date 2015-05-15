/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.CDCRole;

import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.CDCOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class CDCManageOrderRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private CDCEnterprise enterprise;
    private EcoSystem ecoSystem;
    private CDCOrganization cdcOrganization;
    public CDCManageOrderRequestJPanel(JPanel upc, UserAccount account, CDCEnterprise enterprise,CDCOrganization cdcOrganization, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
        this.cdcOrganization = cdcOrganization;
        this.ecoSystem = ecoSystem;
        populateReceivedRequestTable();
        populateSentRequestTable();
    }

    private void populateReceivedRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
        dtm.setRowCount(0);
//        OrderRequest or = null;
        if(cdcOrganization !=null){
            for(WorkRequest request : cdcOrganization.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
              OrderRequest or = (OrderRequest)request;
             
              Object[] row = new Object[6];
                row[0] = or;
                row[1] = or.getQuantity();
                row[2] = or.getSender().getPerson().getName();
                row[3] = or.getReceiver() == null ? null : or.getReceiver().getPerson().getName();
                row[4] = or.getStatus();
                row[5] = or.getOrderResult() == null ? "Waiting" : or.getOrderResult();
                dtm.addRow(row);
                
            }
          }
        
        }
            
        }
        
        
    
    private void populateSentRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)phdOrderRequestjTable.getModel();
        dtm.setRowCount(0);
//        OrderRequest por = null;
        for(WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
              OrderRequest por = (OrderRequest)request;
             // break;
          
//            if(por!=null){
                Object[] row = new Object[5];
                row[0] = por;
                row[1] = por.getQuantity();
                row[2] = por.getSender().getPerson().getName();
                row[3] = por.getStatus();
                row[4] = por.getOrderResult() == null ? "Waiting" : por.getOrderResult();
                dtm.addRow(row);
                }
            }
        }
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderRequestjTable = new javax.swing.JTable();
        assignjButton = new javax.swing.JButton();
        processjButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        phdOrderRequestjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 398, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CDC MANAGE ORDER REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        orderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Quantity", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderRequestjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, 499, 99));

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });
        add(assignjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 200, -1, -1));

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });
        add(processjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        phdOrderRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(phdOrderRequestjTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 281, 499, 99));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel2.setText("OUTGOING ORDER REQUEST:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 247, -1, -1));

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("INCOMING ORDER REQUEST:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 55, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void assignjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        WorkRequest request = (WorkRequest)orderRequestjTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null)
        {
            request.setReceiver(account);
            request.setStatus("Pending");
            populateReceivedRequestTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Request is already assigned");
            return;
        }
    }//GEN-LAST:event_assignjButtonActionPerformed

    private void processjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processjButtonActionPerformed
        int selectedRow = orderRequestjTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row from the table");
            return;
        }
        OrderRequest request = (OrderRequest)orderRequestjTable.getValueAt(selectedRow, 0);

        if(request.getReceiver() != null){
            if(request.getReceiver().getPerson().getName().equals(account.getPerson().getName())){
                if(!request.getOrderResult().equals("CDC Approved")){
                    request.setStatus("Processing");
                    CDCProcessOrderRequestJPanel pporjp = new CDCProcessOrderRequestJPanel(userProcessContainer, account, enterprise, cdcOrganization, request, ecoSystem);
                    userProcessContainer.add("ProviderProcessOrderRequestJPanel", pporjp);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Result has already been submitted");
                    return;
                }
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
    }//GEN-LAST:event_processjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateReceivedRequestTable();
        populateSentRequestTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderRequestjTable;
    private javax.swing.JTable phdOrderRequestjTable;
    private javax.swing.JButton processjButton;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
