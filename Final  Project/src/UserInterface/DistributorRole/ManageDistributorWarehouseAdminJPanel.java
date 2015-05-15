/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.DistributorRole;


import Business.EcoSystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.DistributorWarehouseEnterprise;
import Business.Enterprise.Enterprise;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.EnterpriseAdminRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author relaince
 */
public class ManageDistributorWarehouseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private DistributorEnterprise distEnterprise;
    public ManageDistributorWarehouseAdminJPanel(JPanel upc, DistributorEnterprise distEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer= upc;
        this.ecoSystem = ecoSystem;
        this.distEnterprise = distEnterprise;
        
        
        
        
        
        personTypejComboBox.removeAllItems();
        warehousejComboBox.removeAllItems();
//        for(ClinicEnterprise clinicEnterprise : pharEnterprise.getClinicEnterpriseList()){
//            clinicNamejComboBox.addItem(clinicEnterprise);
//        }
        for(Network network : ecoSystem.getNetworkList()){
           for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
               if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.DistributorWarehouse)){
                   warehousejComboBox.addItem(enterprise);
                   for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
                   }
               }
           } 
        }
        
        populateWarehouseComboBox();
        
        
    }
    
    private void populateWarehouseComboBox(){
        warehouseNamejComboBox.removeAllItems();
        for(Network network : ecoSystem.getNetworkList()){
           for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
               if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.DistributorWarehouse)){
                   warehouseNamejComboBox.addItem(enterprise);
                   
               }
           } 
        }
    }    
    
    

    private void populateDistributorWarehouseAdminTable(Enterprise ent){
        DefaultTableModel dtm = (DefaultTableModel)distributionWarehouseAdminjTable.getModel();
        dtm.setRowCount(0);
//        Enterprise ent = null;
//        for(Network network : ecoSystem.getNetworkList()){
//            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                if(ent instanceof DistributorWarehouseEnterprise){
                    //ent = enterprise;
                    for(UserAccount ua : ent.getUserAccountDirectory().getUserAccountList()){
                        Object[] row = new Object[1];
                        row[0] = ua.getUsername();
                        dtm.addRow(row);
                    }
                }
            
//                for(UserAccount ua : ent.getUserAccountDirectory().getUserAccountList()){
//                Object[] row = new Object[1];
//                row[0] = ua.getUsername();
//                dtm.addRow(row);
//                
//            }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        warehouseNamejComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namejTextField = new javax.swing.JTextField();
        passwordjTextField = new javax.swing.JTextField();
        usernamejTextField = new javax.swing.JTextField();
        AddPersonjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        distributionWarehouseAdminjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        warehousejComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        personTypejComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("Warehouse Name:");

        warehouseNamejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Name:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        AddPersonjButton.setText("Add Person");
        AddPersonjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPersonjButtonActionPerformed(evt);
            }
        });

        distributionWarehouseAdminjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(distributionWarehouseAdminjTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Warehouse Name:");

        warehousejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        warehousejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehousejComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Person Type:");

        personTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel7.setText("DISTRIBUTOR MANAGE DISTRIBUTOR WAREHOUSE ADMIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(warehouseNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addGap(18, 18, 18)
                        .addComponent(refreshjButton)
                        .addGap(18, 18, 18)
                        .addComponent(AddPersonjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(warehousejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(warehousejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(warehouseNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(personTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(refreshjButton)
                    .addComponent(AddPersonjButton))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddPersonjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPersonjButtonActionPerformed
        Enterprise enterprise = (Enterprise)warehouseNamejComboBox.getSelectedItem();
        Person.PersonType pt = (Person.PersonType)personTypejComboBox.getSelectedItem();
        String name;
        try
        {
        String regex = "[^&%$#@!0-9()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(namejTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for name");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }

        
        try
        {
        name = namejTextField.getText();
        if ((namejTextField.getText().startsWith(" ")) || (namejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for name ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        
        String username;
        try
        {
        username = namejTextField.getText();
        if ((namejTextField.getText().startsWith(" ")) || (namejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Username ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        String password;
        try
        {
        password = namejTextField.getText();
        if ((namejTextField.getText().startsWith(" ")) || (namejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for password ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        Person person = enterprise.getPersonDirectory().createAndAddPerson(name, pt);
        boolean check = enterprise.getUserAccountDirectory().checkIfUsernameUnique(username);
        boolean f = true;
        for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(o!=null){
            boolean flag = o.getUserAccountDirectory().checkIfUsernameUnique(username);
        
       // if(check==true){
            if(flag == true){
                f = true;
        }
       // }
        else
        {

            f=false;
        }
        }
        }
            
                if(check==true&&f==true){
            
        UserAccount ua = enterprise.getUserAccountDirectory().createAndAddUserAccount(username, password, person, new EnterpriseAdminRole());
        namejTextField.setText("");
        usernamejTextField.setText("");
        passwordjTextField.setText("");
        JOptionPane.showMessageDialog(null, "Account created successfully");
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Username already exists");
            namejTextField.setText("");
            usernamejTextField.setText("");
            passwordjTextField.setText("");
        }
//        populateDistributorWarehouseAdminTable();
    }//GEN-LAST:event_AddPersonjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
//        populateDistributorWarehouseAdminTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void warehousejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehousejComboBoxActionPerformed
        Enterprise ent = (Enterprise)warehousejComboBox.getSelectedItem();
        populateDistributorWarehouseAdminTable(ent);
    }//GEN-LAST:event_warehousejComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPersonjButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable distributionWarehouseAdminjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namejTextField;
    private javax.swing.JTextField passwordjTextField;
    private javax.swing.JComboBox personTypejComboBox;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTextField usernamejTextField;
    private javax.swing.JComboBox warehouseNamejComboBox;
    private javax.swing.JComboBox warehousejComboBox;
    // End of variables declaration//GEN-END:variables
}
