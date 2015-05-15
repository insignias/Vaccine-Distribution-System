/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClinicRole;

import Business.EcoSystem;
import Business.Enterprise.ClinicEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.PharmaceuticalEnterprise;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author insignia
 */
public class ClinicVaccineRequestOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private ClinicOrganization clinicOrganization;
    private EcoSystem ecoSystem;
    //private static int count;
    public ClinicVaccineRequestOrderJPanel(JPanel upc,UserAccount account,Enterprise enterprise, ClinicOrganization clinicOrganization,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
        this.clinicOrganization = clinicOrganization;
        this.ecoSystem = ecoSystem;
        //count++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vaccineNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantityjTextField = new javax.swing.JTextField();
        submitjButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        requestIDjTextField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("CLINIC REQUEST VACCINE ORDER");

        jLabel2.setText("Vaccine Name:");

        jLabel3.setText("Quantity:");

        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Request ID:");

        requestIDjTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(backButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitjButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(requestIDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(vaccineNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(quantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(requestIDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vaccineNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantityjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(submitjButton))
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        
        String vaccineName;
        try
        {
        String regex = "[^&%$#@!()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(vaccineNameTextField.getText());
        if (!matcher.matches()) 
        throw new Exception("Enter valid characters for Vaccine name");
        }
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }

        
        try
        {
        vaccineName = vaccineNameTextField.getText();
         if ((vaccineNameTextField.getText().startsWith(" ")) || (vaccineNameTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for message ");
        }       
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        
        int quantity;
        quantity = Integer.parseInt(quantityjTextField.getText());
         
        OrderRequest orderRequest = new OrderRequest();
        if(orderRequest.getStatus()==null)
        {
        orderRequest.setVaccineName(vaccineName);
        orderRequest.setQuantity(quantity);
        orderRequest.setSender(account);
        orderRequest.setStatus("sent");
        orderRequest.setOrderResult("Waiting");
        orderRequest.setRequestID(orderRequest.getRequestID());
        orderRequest.setLocation(enterprise.getLocation());
        orderRequest.setEnterpriseType(enterprise.getEnterpriseType().getValue());
        orderRequest.setEnterpriseName(enterprise.getName());
            System.out.println("clinicEnterprise.getName(): " +enterprise.getName());
        }
        
        requestIDjTextField.setText(String.valueOf(orderRequest.getRequestID()));
        
        Organization org = null;
        HospitalEnterprise hosEnt = null;
        for(Network n : ecoSystem.getNetworkList()){
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise.getLocation().equals(e.getLocation())){
                    System.out.println("enterprise: " +e.getLocation());
                    if(e instanceof HospitalEnterprise){
                    //if(e.getEnterpriseType().getValue().equals("Hospital")){
                        hosEnt = (HospitalEnterprise)e;
                        System.out.println("hospital");
                        for(ClinicEnterprise clinicEnt : hosEnt.getClinicEnterpriseList()){
                            if(clinicEnt.getName().equals(enterprise.getName())){
                                for(Organization o : hosEnt.getOrganizationDirectory().getOrganizationList()){
                                if(o instanceof HospitalOrganization){
                                   //System.out.println("instance of provider org");
                                 org = o;
                                 break;
                                    
                            }
                        }
                    }
                }
            }
                                PharmaceuticalEnterprise pharEnt = null;
                                if(e instanceof PharmaceuticalEnterprise){
                                //if(e.getEnterpriseType().getValue().equals("Hospital")){
                                    pharEnt = (PharmaceuticalEnterprise)e;
                                    System.out.println("Pharmaceutical");
                                    for(ClinicEnterprise clinicEnt : pharEnt.getClinicEnterpriseList()){
                                    if(clinicEnt.getName().equals(enterprise.getName())){
                                        for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                                            if(o instanceof PharmaceuticalOrganization){
                                                //System.out.println("instance of provider org");
                                                org = o;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        
        if(org!=null){
            org.getWorkQueue().getWorkRequestList().add(orderRequest);
            account.getWorkQueue().getWorkRequestList().add(orderRequest);
            System.out.println("work request added");
        }
        if(org==null){
            System.out.println("org is null");
        }
        JOptionPane.showMessageDialog(null, "Order request sent");
        vaccineNameTextField.setText("");
        quantityjTextField.setText("");
        return;
        
               
    }//GEN-LAST:event_submitjButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField quantityjTextField;
    private javax.swing.JTextField requestIDjTextField;
    private javax.swing.JButton submitjButton;
    private javax.swing.JTextField vaccineNameTextField;
    // End of variables declaration//GEN-END:variables
}
