/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.HospitalRole;


import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;

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
public class ManageClinicAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private HospitalEnterprise hospitalEnterprise;
    public ManageClinicAdminJPanel(JPanel upc, HospitalEnterprise hospitalEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer= upc;
        this.ecoSystem = ecoSystem;
        this.hospitalEnterprise = hospitalEnterprise;
        populateClinicAdminTable();
        
        
        clinicNamejComboBox.removeAllItems();
        personTypejComboBox.removeAllItems();
                for(ClinicEnterprise clinicEnterprise : hospitalEnterprise.getClinicEnterpriseList()){
                   clinicNamejComboBox.addItem(clinicEnterprise);
                   for(Person.PersonType pt : Person.PersonType.values()){
                    if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
                    personTypejComboBox.addItem(pt);
                }
            }
           } 
        
        
        
    }

    private void populateClinicAdminTable(){
        DefaultTableModel dtm = (DefaultTableModel)ClinicAdminjTable.getModel();
        dtm.setRowCount(0);
        for(Enterprise enterprise : hospitalEnterprise.getClinicEnterpriseList()){
            for(Network network : ecoSystem.getNetworkList()){
                for(Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise.getName().equals(ent.getName())){
                    for(UserAccount ua : ent.getUserAccountDirectory().getUserAccountList()){
                        Object[] row = new Object[1];
                        row[0] = ua.getUsername();
                        dtm.addRow(row);
                    }
                }
            }
          }
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        clinicNamejComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namejTextField = new javax.swing.JTextField();
        passwordjTextField = new javax.swing.JTextField();
        usernamejTextField = new javax.swing.JTextField();
        AddPersonjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClinicAdminjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        personTypejComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("Clinic Name:");

        clinicNamejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Name:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        AddPersonjButton.setText("Add Person");
        AddPersonjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPersonjButtonActionPerformed(evt);
            }
        });

        ClinicAdminjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ClinicAdminjTable);

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Person Type:");

        personTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel6.setText("HOSPITAL MANAGE CLINIC ADMIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(backJButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addComponent(refreshjButton)
                        .addGap(18, 18, 18)
                        .addComponent(AddPersonjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(clinicNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(personTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clinicNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(personTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(refreshjButton)
                    .addComponent(AddPersonjButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddPersonjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPersonjButtonActionPerformed
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
        username = usernamejTextField.getText();
        if ((usernamejTextField.getText().startsWith(" ")) || (usernamejTextField.getText().isEmpty()))
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
        password = passwordjTextField.getText();
        if ((passwordjTextField.getText().startsWith(" ")) || (passwordjTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Password ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        Enterprise enterprise = (Enterprise)clinicNamejComboBox.getSelectedItem();
        Person.PersonType pt = (Person.PersonType)personTypejComboBox.getSelectedItem();
        System.out.println("hospital enterprise: " +enterprise);
        for(Network network : ecoSystem.getNetworkList()){
            for(Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("network enterprise: " +ent);
                if(enterprise.getLocation().equals(ent.getLocation())){
                if(enterprise.getName().equals(ent.getName())){
                    System.out.println("network enterprise: " +ent);
                    System.out.println("both are equal");
                    Person p = ent.getPersonDirectory().createAndAddPerson(name, pt);
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
         
                    UserAccount ua = ent.getUserAccountDirectory().createAndAddUserAccount(username, password, p, new EnterpriseAdminRole());
                    namejTextField.setText("");
                    usernamejTextField.setText("");
                    passwordjTextField.setText("");
                    populateClinicAdminTable();
                    JOptionPane.showMessageDialog(null, "Account created successfully");
                }
                else
        {
            JOptionPane.showMessageDialog(null, "Username already exists");
            usernamejTextField.setText("");
            passwordjTextField.setText("");
        }
                }
                }
              }    
            }
//            populateClinicAdminTable();
//            namejTextField.setText("");
//            usernamejTextField.setText("");
//            passwordjTextField.setText("");
        
        
    }//GEN-LAST:event_AddPersonjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateClinicAdminTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPersonjButton;
    private javax.swing.JTable ClinicAdminjTable;
    private javax.swing.JButton backJButton1;
    private javax.swing.JComboBox clinicNamejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namejTextField;
    private javax.swing.JTextField passwordjTextField;
    private javax.swing.JComboBox personTypejComboBox;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JTextField usernamejTextField;
    // End of variables declaration//GEN-END:variables
}
