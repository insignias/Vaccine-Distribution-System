/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PHDRole;


import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Organization.PHDOrganization;

import Business.Person.Person;
import Business.WorkQueue.EnrollmentRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class PHDProcessEnrollmentRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EnrollmentRequest request;
    private PHDOrganization phdOrg;
    private EcoSystem ecoSystem;
    public PHDProcessEnrollmentRequestJPanel(JPanel userProcessContainer, PHDOrganization phdOrg, EnrollmentRequest request, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.phdOrg = phdOrg;
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel2.setText("PHD PROCESS ENROLLMENT REQUEST");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 22, -1, -1));

        jLabel1.setText("Result");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 60, -1, -1));

        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 101, -1, -1));

        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, -1, -1));

        resultjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        resultjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultjComboBoxActionPerformed(evt);
            }
        });
        add(resultjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 56, -1, -1));
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
