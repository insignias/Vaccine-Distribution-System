/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.EnterpriseAdminRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    public ManageOrganizationJPanel(JPanel upc, Enterprise enterprise) {
        initComponents();
        userProcessContainer = upc;
        this.enterprise = enterprise;
        populateOrganizationsComboBox();
        populateOrganizationsTable();
    }

    private void populateOrganizationsComboBox(){
        organizationsjComboBox.removeAllItems();
        if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.CDC.getValue())){
                    for (Type type : Organization.Type.values()){
                        if (type.getValue().equals(Type.CDC.getValue())){
                        organizationsjComboBox.addItem(type);
                        break;
                    }
                }
            }
         if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Insurance.getValue())){
                    for (Type type : Organization.Type.values()){
                        if (type.getValue().equals(Type.Insurance.getValue())){
                        organizationsjComboBox.addItem(type);
                        break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.PHD.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.PHD.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Distributor.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Distributor.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                }
            }   
         }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.DistributorWarehouse.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.DistributorWarehouse.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                }
            }   
         }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Clinic.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Clinic.getValue())){
                    organizationsjComboBox.addItem(type);
                    
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Pharmaceutical.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Pharmaceutical.getValue())){
                    organizationsjComboBox.addItem(type);
                    //break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Hospital.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Hospital.getValue())){
                    organizationsjComboBox.addItem(type);
                    //break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Manufacturer.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Manufacturer.getValue())){
                    organizationsjComboBox.addItem(type);
                    break;
                    }
                }
            }
            if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Provider.getValue())){
                 for (Type type : Organization.Type.values()){
                    if (type.getValue().equals(Type.Provider.getValue())){
                    organizationsjComboBox.addItem(type);
                    //break;
                }
                 
            }
        }
    }
    
    
    private void populateOrganizationsTable(){
        DefaultTableModel dtm = (DefaultTableModel)organizationsjTable.getModel();
        dtm.setRowCount(0);
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
        
            Object[] row = new Object[1];
            row[0] = org.getName();
            dtm.addRow(row);
        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationsjTable = new javax.swing.JTable();
        organizationsjComboBox = new javax.swing.JComboBox();
        addOrganizationjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        organizationsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Organizations"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationsjTable);

        organizationsjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addOrganizationjButton.setText("Add Organization");
        addOrganizationjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrganizationjButtonActionPerformed(evt);
            }
        });

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("ENTERPRISEADMIN MANAGE ORGANIZATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(organizationsjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addOrganizationjButton)
                            .addComponent(backjButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(organizationsjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addOrganizationjButton)
                .addGap(18, 18, 18)
                .addComponent(backjButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addOrganizationjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrganizationjButtonActionPerformed
        Type type = (Type)organizationsjComboBox.getSelectedItem();
        boolean flag = enterprise.getOrganizationDirectory().checkIfOrgUnique(type);
        if(flag==true){
        enterprise.getOrganizationDirectory().createOrganization(type);
        populateOrganizationsTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, type+ " already added");
        }
    }//GEN-LAST:event_addOrganizationjButtonActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrganizationjButton;
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationsjComboBox;
    private javax.swing.JTable organizationsjTable;
    // End of variables declaration//GEN-END:variables
}
