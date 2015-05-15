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
public class ManageClinicsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private HospitalEnterprise hospitalEnterprise;
    public ManageClinicsJPanel(JPanel upc, HospitalEnterprise hospitalEnterprise, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        this.hospitalEnterprise = hospitalEnterprise;
        
        
        enterpriseTypejComboBox.removeAllItems();
                for(Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values())
                    {
                        if(type.getValue().equals(Enterprise.EnterpriseType.Clinic.getValue())){
//        for(ClinicEnterprise clinicEnterprise : hospitalEnterprise.getClinicEnterpriseList()){
                        enterpriseTypejComboBox.addItem(type);
                        break;
                        }
                    }   
                populateClinicTable();
                    
    }
    
    private void populateClinicTable(){
       DefaultTableModel model = (DefaultTableModel)clinicjTable.getModel();
       
       model.setRowCount(0);

                    for(Enterprise enterprise : hospitalEnterprise.getClinicEnterpriseList()){
                    Object[] row = new Object[2];
                    row[0] = enterprise.getName();
                    row[1] = enterprise.getLocation();
                    model.addRow(row);
               }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ClinicNamejTextField = new javax.swing.JTextField();
        addClinicjButton = new javax.swing.JButton();
        enterpriseTypejComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clinicjTable = new javax.swing.JTable();
        refreshjButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Clinic Name:");

        addClinicjButton.setText("Add Clinic");
        addClinicjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClinicjButtonActionPerformed(evt);
            }
        });

        enterpriseTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Enterprise Type:");

        clinicjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clinic Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(clinicjTable);

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

        jLabel3.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel3.setText("HOSPITAL MANAGE CLINICS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ClinicNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(enterpriseTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton1)
                        .addGap(18, 18, 18)
                        .addComponent(refreshjButton)
                        .addGap(18, 18, 18)
                        .addComponent(addClinicjButton)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(enterpriseTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ClinicNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(refreshjButton)
                    .addComponent(addClinicjButton))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addClinicjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClinicjButtonActionPerformed
//       for(Network n : ecoSystem.getNetworkList()){
//           for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
//               if(e.getEnterpriseType().getValue()=="Clinic"){
                
                    Enterprise.EnterpriseType eType = (Enterprise.EnterpriseType)enterpriseTypejComboBox.getSelectedItem();
                    String name;
                    try
                        {
                        String regex = "[^&%$#@!0-9()~`.,]*";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(ClinicNamejTextField.getText());
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
                            name = ClinicNamejTextField.getText();
                            if ((ClinicNamejTextField.getText().startsWith(" ")) || (ClinicNamejTextField.getText().isEmpty()))
                                throw new Exception(" Please enter valid characters");
                        }        
                    catch (Exception e) {
                                            //System.err.println("Caught IOException: " + e.getMessage());
                                            JOptionPane.showMessageDialog(null,e.getMessage());
                                            return;
                                        }
//                    ClinicEnterprise ce = new ClinicEnterprise(name, eType);
                    ClinicEnterprise ce = new ClinicEnterprise(name, eType);
                    ce.setLocation(hospitalEnterprise.getLocation());
                    boolean flag = hospitalEnterprise.checkIfClinicUnique(name);
                    if(flag==true){
                    hospitalEnterprise.createEnterprise(ce);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Clinic name already exists");
                        return;
                    }
//                    Enterprise enterprise = hospitalEnterprise.createEnterprise(name,eType);
//                    System.out.println("Clinic Enterprise added to hospital Enterprise");
//                    enterprise.setLocation(hospitalEnterprise.getLocation());
                    for(Network n : ecoSystem.getNetworkList()){
                        //Enterprise.EnterpriseType eType = (Enterprise.EnterpriseType)enterpriseTypejComboBox.getSelectedItem();
                        boolean check = n.getEnterpriseDirectory().checkIfClinicUnique(name);
                        if(check==true){
                        Enterprise ent = n.getEnterpriseDirectory().createAndAddEnterprise(name, eType);
                        System.out.println("Clinic Enterprise added to Enterprise");
                        ent.setLocation(hospitalEnterprise.getLocation());
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "Clinic name already exists");
                          return;  
                        }
                    }
                    populateClinicTable();
//                   enterpriseTypejComboBox.removeAll();
//                   enterpriseTypejComboBox.add(e.getEnterpriseType());
//                   String name = ClinicNamejTextField.getText();
//                   ClinicEnterprise ce = new ClinicEnterprise(name, Enterprise.EnterpriseType.Clinic);
//               }
//           }
//       }
        
    }//GEN-LAST:event_addClinicjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateClinicTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClinicNamejTextField;
    private javax.swing.JButton addClinicjButton;
    private javax.swing.JButton backJButton1;
    private javax.swing.JTable clinicjTable;
    private javax.swing.JComboBox enterpriseTypejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
