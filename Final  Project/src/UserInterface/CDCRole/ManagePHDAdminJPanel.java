/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.CDCRole;


import Business.EcoSystem;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PHDEnterprise;

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
public class ManagePHDAdminJPanel extends javax.swing.JPanel {

     private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private CDCEnterprise cdcEnterprise;
    public ManagePHDAdminJPanel(JPanel upc, CDCEnterprise cdcEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer= upc;
        this.ecoSystem = ecoSystem;
        this.cdcEnterprise = cdcEnterprise;
        
        
        PHDNamejComboBox.removeAllItems();
        personTypejComboBox.removeAllItems();
        
        boolean flag = false;
        for(Network network : ecoSystem.getNetworkList()){
           for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
               if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.PHD)){
                   PHDNamejComboBox.addItem(enterprise);
                   if(flag == false){
                        for(Person.PersonType pt : Person.PersonType.values()){
                            if(pt.getValue().equals(Person.PersonType.EnterpriseAdmin.getValue())){
                                personTypejComboBox.addItem(pt);
                                flag = true;
                                break;
                            }
                        }
                    }
                } 
            }
        }
        
        
    }

    private void populatePHDAdminTable(){
        DefaultTableModel dtm = (DefaultTableModel)PHDAdminjTable.getModel();
        dtm.setRowCount(0);
        Enterprise ent = null;
        for(Network network : ecoSystem.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise instanceof PHDEnterprise){
                    ent = enterprise;
                    for(UserAccount ua : ent.getUserAccountDirectory().getUserAccountList()){
                        Object[] row = new Object[1];
                        row[0] = ua.getUsername();
                        dtm.addRow(row);
                    }
                }
            }
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PHDNamejComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namejTextField = new javax.swing.JTextField();
        passwordjTextField = new javax.swing.JTextField();
        usernamejTextField = new javax.swing.JTextField();
        AddPersonjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PHDAdminjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        personTypejComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("PHD Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        PHDNamejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(PHDNamejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 144, 107, -1));

        jLabel2.setText("Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 228, -1, -1));

        jLabel3.setText("Username:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 274, -1, -1));

        jLabel4.setText("Password:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        add(namejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 222, 107, -1));
        add(passwordjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 314, 107, -1));
        add(usernamejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 268, 107, -1));

        AddPersonjButton.setText("Add Person");
        AddPersonjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPersonjButtonActionPerformed(evt);
            }
        });
        add(AddPersonjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 360, -1, -1));

        PHDAdminjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(PHDAdminjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 248, 92));

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 360, -1, -1));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel5.setText("CDC MANAGE PHD ADMIN");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel6.setText("Person Type:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 187, -1, -1));

        personTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(personTypejComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 183, 107, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void AddPersonjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPersonjButtonActionPerformed
        Enterprise enterprise = (Enterprise)PHDNamejComboBox.getSelectedItem();
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
        populatePHDAdminTable();
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
    }//GEN-LAST:event_AddPersonjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populatePHDAdminTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPersonjButton;
    private javax.swing.JTable PHDAdminjTable;
    private javax.swing.JComboBox PHDNamejComboBox;
    private javax.swing.JButton backJButton1;
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
