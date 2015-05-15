/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.PHDRole;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PHDEnterprise;
import Business.Network.Network;
import Business.Organization.CDCOrganization;
import Business.Organization.Organization;
import Business.Organization.PHDOrganization;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.EnrollmentRequest;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author relaince
 */
public class ProcessPHDOrderRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private OrderRequest request;
    private PHDOrganization phdOrg;
    private EcoSystem ecoSystem;
    private UserAccount ua;
    private PHDEnterprise phdEnterprise;
    public ProcessPHDOrderRequestJPanel(JPanel userProcessContainer, UserAccount ua, PHDEnterprise phdEnterprise, PHDOrganization phdOrg,OrderRequest request, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.phdOrg = phdOrg;
        this.ecoSystem = ecoSystem;
        this.ua = ua;
        this.phdEnterprise = phdEnterprise;
        
        resultjComboBox.removeAllItems();
        resultjComboBox.addItem("Approved");
        resultjComboBox.addItem("Cancelled");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultjComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resultjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        resultjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultjComboBoxActionPerformed(evt);
            }
        });
        add(resultjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 55, 133, -1));

        jLabel1.setText("Result");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 59, -1, -1));

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("PHD PROCESS ORDER REQUEST");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void resultjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultjComboBoxActionPerformed

    }//GEN-LAST:event_resultjComboBoxActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if(!request.getOrderResult().equals("PHD Approved")){
        String status = (String)resultjComboBox.getSelectedItem();
        if(status.equals("Approved")){
            request.setStatus("Completed");
            request.setOrderResult("PHD Approved");
            OrderRequest provOrderRequest = new OrderRequest();
            provOrderRequest.setVaccineName(request.getVaccineName());
            provOrderRequest.setQuantity(request.getQuantity());
            provOrderRequest.setSender(ua);
            provOrderRequest.setStatus("sent");
            provOrderRequest.setOrderResult("Waiting");
            provOrderRequest.setRequestID(request.getRequestID());
            provOrderRequest.setEnterpriseType(request.getEnterpriseType());
            provOrderRequest.setEnterpriseName(request.getEnterpriseName());
            provOrderRequest.setLocation(request.getLocation());
            provOrderRequest.setProviderLocation(request.getProviderLocation());
            provOrderRequest.setProviderEnterpriseType(request.getProviderEnterpriseType());
            provOrderRequest.setProviderEnterpriseName(request.getProviderEnterpriseName());
            System.out.println("phdEnterprise.getLocation()" +phdEnterprise.getLocation());
            Organization org = null;
        for(Network n : ecoSystem.getNetworkList()){
            boolean flag = false;
            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
               // if(phdEnterprise.getLocation().equals(e.getLocation())){
                    if(e.getEnterpriseType().getValue().equals("CDC")){
                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    if(o instanceof CDCOrganization){
                        //System.out.println("instance of provider org");
                        org = o;
                        flag = true;
                        break;
                    }
                }
            }
       // }
                if(flag == true)
                {
                    break;
                }
    }
            
            if(org!=null){
                org.getWorkQueue().getWorkRequestList().add(provOrderRequest);
                ua.getWorkQueue().getWorkRequestList().add(provOrderRequest);
                System.out.println("order request added to CDC org");
        }
            
            JOptionPane.showMessageDialog(null, "Result submitted");
            return;
            //}
           //}
          }
        }
            

        if(status.equals("Cancelled")){
            request.setStatus("Completed");
            request.setOrderResult("PHD Cancelled");
//            request.setSender(ua);
//            ShippingRequest shippingRequest = new ShippingRequest(); 
//            shippingRequest.setOrderId(request.getOrderId());
//            shippingRequest.setMessage(request.getMessage());
//            shippingRequest.setSender(ua);
//            shippingRequest.setStatus("Completed");
            //shippingRequest.setShippingResult("Cancelled");
//            Organization org = null;
//            for(Network n : ecoSystem.getNetworkList()){
//            for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
//                if(hospitalEnterprise.getLocation().equals(e.getLocation())){
//                    if(e.getEnterpriseType().getValue().equals("Provider")){
//                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
//                    if(o instanceof ProviderOrganization){
//                        //System.out.println("instance of provider org");
//                        org = o;
//                        break;
//                    }
//                }
//            }
//            if(org!=null){
//                org.getWorkQueue().getWorkRequestList().add(request);
//                ua.getWorkQueue().getWorkRequestList().add(request);
//                System.out.println("order request added to Provider org");
//        }
            
            JOptionPane.showMessageDialog(null, "Result submitted");
            return;
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Result already submitted");
            return;
        }
        

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox resultjComboBox;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
