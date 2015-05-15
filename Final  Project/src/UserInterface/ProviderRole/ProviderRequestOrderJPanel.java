/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ProviderRole;

import Business.Enterprise.ProviderEnterprise;
import Business.Organization.Organization;
import Business.Organization.PHDOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ProviderRequestOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ProviderEnterprise enterprise;
    public ProviderRequestOrderJPanel(JPanel upc, UserAccount account, ProviderEnterprise enterprise) {
        initComponents();
        userProcessContainer = upc;
        this.account = account;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messagejTextField = new javax.swing.JTextField();
        sendjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vaccineTypejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dosesjTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(messagejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 159, 101, -1));

        sendjButton.setText("Send");
        sendjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendjButtonActionPerformed(evt);
            }
        });
        add(sendjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 205, -1, 30));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("PROVIDER ORDER REQUEST");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, -1));

        backButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel1.setText("Message:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 165, -1, -1));

        jLabel3.setText("Vaccine Type:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, -1, -1));
        add(vaccineTypejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 67, 101, -1));

        jLabel4.setText("Quantity:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 119, -1, -1));
        add(dosesjTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 113, 101, -1));
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
        int doses = Integer.parseInt(dosesjTextField.getText());
        String vaccineType = vaccineTypejTextField.getText();
        OrderRequest request = new OrderRequest();
        if(request.getStatus()==null){
            request.setMessage(message);
            request.setSender(account);
            request.setStatus("sent");
//            request.setDoses(doses);
//            request.setVaccineType(vaccineType);
        }

                Organization org = null;
                for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(o instanceof PHDOrganization){
                                org = o;
                                break;
                            }
                    }
                if(org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
            System.out.println("work request added");

            JOptionPane.showMessageDialog(null, "Enrollment request sent");
            messagejTextField.setText("");
            return;
                }
    }//GEN-LAST:event_sendjButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField dosesjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField messagejTextField;
    private javax.swing.JButton sendjButton;
    private javax.swing.JTextField vaccineTypejTextField;
    // End of variables declaration//GEN-END:variables
}
