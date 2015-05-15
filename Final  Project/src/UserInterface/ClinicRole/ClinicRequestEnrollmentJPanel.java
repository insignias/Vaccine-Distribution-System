/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ClinicRole;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PharmaceuticalOrganization;
import Business.Organization.ProviderOrganization;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.EnrollmentRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ClinicRequestEnrollmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount ua;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    public ClinicRequestEnrollmentJPanel(JPanel upc, UserAccount ua, Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ua = ua;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendjButton = new javax.swing.JButton();
        messagejTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sendjButton.setText("Send");
        sendjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendjButtonActionPerformed(evt);
            }
        });
        add(sendjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));
        add(messagejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 126, -1));

        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setText("Request Enrollment ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sendjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendjButtonActionPerformed
        String message;
        try
        {
        message = messagejTextField.getText();
         if ((messagejTextField.getText().startsWith(" ")) || (messagejTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for message ");
        }       
        catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        EnrollmentRequest request = new EnrollmentRequest();
        if(request.getStatus()==null){
        request.setMessage(message);
        request.setSender(ua);
        request.setStatus("sent");}

        Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise.getLocation().equals(e.getLocation())){
                    if(enterprise.getEnterpriseType().getValue().equals("Provider")){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    if(o instanceof ProviderOrganization){
                        System.out.println("instance of provider org");
                        org = o;
                        break;
                    }
                }
            }
                if(enterprise.getEnterpriseType().getValue().equals("Pharmaceutical")){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    if(o instanceof PharmaceuticalOrganization){
                        System.out.println("instance of provider org");
                        org = o;
                        break;
                    }
                }
            }
           }
           }
               
          }
        
        if(org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            ua.getWorkQueue().getWorkRequestList().add(request);
            System.out.println("work request added");
        }
        if(org==null){
            System.out.println("org is null");
        }
        JOptionPane.showMessageDialog(null, "Enrollment request sent");
        messagejTextField.setText("");
        return;
        
    }//GEN-LAST:event_sendjButtonActionPerformed

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
    private javax.swing.JTextField messagejTextField;
    private javax.swing.JButton sendjButton;
    // End of variables declaration//GEN-END:variables
}