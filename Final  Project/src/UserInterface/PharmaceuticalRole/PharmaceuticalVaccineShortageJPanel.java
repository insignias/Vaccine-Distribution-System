/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PharmaceuticalRole;

import UserInterface.HospitalRole.*;
import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PHDEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Organization.HospitalOrganization;
import Business.Organization.PHDOrganization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ShortageRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author insignia
 */
public class PharmaceuticalVaccineShortageJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount ua;
    private PharmaceuticalOrganization pharOrg;
    private PharmaceuticalEnterprise pharEnterprise;
    
    public PharmaceuticalVaccineShortageJPanel(JPanel upc,UserAccount ua, PharmaceuticalEnterprise pharEnterprise, PharmaceuticalOrganization pharOrg, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ua = ua;
        this.ecoSystem = ecoSystem;
        this.pharOrg = pharOrg;
        this.pharEnterprise = pharEnterprise;
        
        populateShortageTable();
        
    }

    private void populateShortageTable(){
        DefaultTableModel dtm = (DefaultTableModel)vaccineShortageReportjTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest wr : pharOrg.getWorkQueue().getWorkRequestList()){
            if(wr instanceof ShortageRequest){
                ShortageRequest sr = (ShortageRequest)wr;
                Object[] row = new Object[5];
                row[0] = sr;
                row[1] = sr.getShortage();
                row[2] = sr.getReason();
                row[3] = sr.getReportDate();
                row[4] = sr.getSender();
                dtm.addRow(row);
           
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineShortageReportjTable = new javax.swing.JTable();
        backJButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("VACCINE SHORTAGE REPORT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        vaccineShortageReportjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Shortage", "Reason", "Date Reported", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineShortageReportjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 430, 87));

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable vaccineShortageReportjTable;
    // End of variables declaration//GEN-END:variables
}
