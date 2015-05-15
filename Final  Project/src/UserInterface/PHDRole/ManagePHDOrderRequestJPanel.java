/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PHDRole;

import Business.EcoSystem;
import Business.Enterprise.PHDEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Organization.PHDOrganization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class ManagePHDOrderRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private PHDOrganization phdOrg;
    private UserAccount ua; 
    private PHDEnterprise phdEnterprise;
    public ManagePHDOrderRequestJPanel(JPanel upc, UserAccount ua, PHDEnterprise phdEnterprise, PHDOrganization phdOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.phdOrg = phdOrg;
        this.ua = ua;
        this.phdEnterprise = phdEnterprise;
        populateTable();
        populateSentOrderTable();
    }

    private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderRequestjTable.getModel();
        dtm.setRowCount(0);
        System.out.println("here in the workrequest table1");
//        OrderRequest or = null;
        for(WorkRequest request : phdOrg.getWorkQueue().getWorkRequestList()){
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
    
    private void populateSentOrderTable(){
        DefaultTableModel dtm = (DefaultTableModel)orderSentRequestjTable.getModel();
        dtm.setRowCount(0);
        System.out.println("here in the workrequest table1");
//        OrderRequest cor = null;
        for(WorkRequest request : ua.getWorkQueue().getWorkRequestList()){
            if(request instanceof OrderRequest){
             OrderRequest cor = (OrderRequest)request; 
           
            Object[] row = new Object[5];
            row[0] = cor;
            row[1] = cor.getQuantity();
            row[2] = cor.getSender().getPerson().getName();
            row[3] = cor.getStatus();
            row[4] = cor.getOrderResult() == null ? "Waiting" : cor.getOrderResult();
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
        orderSentRequestjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("PHD MANAGE ORDER REQUEST");

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
        if (orderRequestjTable.getColumnModel().getColumnCount() > 0) {
            orderRequestjTable.getColumnModel().getColumn(3).setHeaderValue("Receiver");
        }

        assignjButton.setText("Assign to me");
        assignjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignjButtonActionPerformed(evt);
            }
        });

        processjButton.setText("Process");
        processjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processjButtonActionPerformed(evt);
            }
        });

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        orderSentRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(orderSentRequestjTable);

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel2.setText("INCOMING ORDER REQUEST:");

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        jLabel3.setText("OUTGOING ORDER REQUEST:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backJButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(assignjButton)
                            .addGap(46, 46, 46)
                            .addComponent(refreshjButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(processjButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignjButton)
                    .addComponent(refreshjButton)
                    .addComponent(processjButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton1))
        );
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
            request.setReceiver(ua);
            request.setStatus("Pending");
            populateTable();
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
            if(request.getReceiver().getPerson().getName().equals(ua.getPerson().getName())){
                if(!request.getOrderResult().equals("PHD Approved")){
                    request.setStatus("Processing");
                    ProcessPHDOrderRequestJPanel pphdorjp = new ProcessPHDOrderRequestJPanel(userProcessContainer, ua, phdEnterprise, phdOrg, request, ecoSystem);
                    userProcessContainer.add("ProcessWorkRequestJPanel", pphdorjp);
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
        populateTable();
        populateSentOrderTable();
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
    private javax.swing.JTable orderSentRequestjTable;
    private javax.swing.JButton processjButton;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
