/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PharmaceuticalRole;


import UserInterface.PHDRole.*;
import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Organization.PHDOrganization;
import Business.Organization.PharmaceuticalOrganization;

import Business.Person.Person;
import Business.WorkQueue.EnrollmentRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class ProcessPharmaWorkRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EnrollmentRequest request;
    private PharmaceuticalOrganization pharOrg;
    private EcoSystem ecoSystem;
    public ProcessPharmaWorkRequestJPanel(JPanel userProcessContainer, PharmaceuticalOrganization pharOrg, EnrollmentRequest request, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.pharOrg = pharOrg;
        this.ecoSystem = ecoSystem;
        
        resultjComboBox.removeAllItems();
        resultjComboBox.addItem("Approve");
        resultjComboBox.addItem("Cancel");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        resultjComboBox = new javax.swing.JComboBox();

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("PHARMACEUTICAL PROCESS WORK REQUEST");

        jLabel1.setText("Result:");

        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        resultjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        resultjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultjComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(resultjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(backJButton1)
                        .addGap(18, 18, 18)
                        .addComponent(submitJButton)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(resultjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton1)
                    .addComponent(submitJButton))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        String status = (String)resultjComboBox.getSelectedItem();
        if(status.equals("Approve")){
            request.setStatus("Completed");
            request.setResult("Approved");
//           Organization sOrg = null;
//        for(Organization o : business.organizationDirectory().getOrganizationList()){
//           if(o instanceof SupplierOrganization){
//               sOrg = o;
//               break;
//           }
//           }
//          for(Person p : phdOrg.getPersonDirectory().getPersonList()){
//            System.out.println("supp:" +s.getFirstName());
//            System.out.println("requester: " +request.getSender().getPerson().getFirstName());
//            if(p.equals(request.getSender().getPerson())){
//                System.out.println("in if loop");
//            
//                //p.setStatus("Approved");
//            }
//        }
       
            JOptionPane.showMessageDialog(null, "Result submitted");
            return;
        }
        
         if(status.equals("Cancel")){
            request.setStatus("Completed");
            request.setResult("Cancelled");
//        Organization sOrg = null;
//        for(Organization o : business.organizationDirectory().getOrganizationList()){
//           if(o instanceof SupplierOrganization){
//               sOrg = o;
//               break;
//           }
//           }
//          for(Person p : phdOrg.getPersonDirectory().getPersonList()){
////            if(p.equals(request.getSender().getPerson())){
////                System.out.println("in if loop");
////            
////                p.setStatus("Cancelled");
////            }
//        }
         
        JOptionPane.showMessageDialog(null, "Result submitted");
        return;
        }
 
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void resultjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultjComboBoxActionPerformed
        
    }//GEN-LAST:event_resultjComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox resultjComboBox;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}