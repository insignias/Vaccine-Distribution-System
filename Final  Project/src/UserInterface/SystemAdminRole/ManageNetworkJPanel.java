/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.SystemAdminRole;

import Business.EcoSystem;
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
public class ManageNetworkJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    public ManageNetworkJPanel(JPanel upc, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        populateNetworkTable();
    }

  private void populateNetworkTable(){
      DefaultTableModel dtm = (DefaultTableModel)networkjTable.getModel();
      dtm.setRowCount(0);
      
      for(Network network : ecoSystem.getNetworkList()){
      Object[] row = new Object[1];
      row[0] = network.getName();
      dtm.addRow(row);
      }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkjTable = new javax.swing.JTable();
        networkNameJTextField = new javax.swing.JTextField();
        submitjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backjButton.setText("<< Back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 216, -1, -1));

        networkjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 55, 375, 95));
        add(networkNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 168, 83, -1));

        submitjButton.setText("Submit");
        submitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButtonActionPerformed(evt);
            }
        });
        add(submitjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 169, -1, -1));

        jLabel1.setFont(new java.awt.Font("American Typewriter", 1, 18)); // NOI18N
        jLabel1.setText("MANAGE NETWORK");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 14, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButtonActionPerformed

    private void submitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButtonActionPerformed
        String name;
        try
        {
        String regex = "[^&%$#@!0-9()~`.,]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(networkNameJTextField.getText());
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
        name = networkNameJTextField.getText();
        if ((networkNameJTextField.getText().startsWith(" ")) || (networkNameJTextField.getText().isEmpty()))
            throw new Exception(" Please enter valid characters for Username ");
        }        
        catch (Exception e) {
        //System.err.println("Caught IOException: " + e.getMessage());
        JOptionPane.showMessageDialog(null,e.getMessage());
        return;
        }
        
        boolean flag = ecoSystem.searchNetwork(name);
        if(flag==false){
        Network network = ecoSystem.createAndAddNetwork();
        network.setName(name);
        populateNetworkTable();
        networkNameJTextField.setText("");
        }
//            }
            else{
                JOptionPane.showMessageDialog(null, "Network Already exists");
                networkNameJTextField.setText("");
            }
//        }
//                network = ecoSystem.createAndAddNetwork();
//                network.setName(name);
//                populateNetworkTable();
//                networkNameJTextField.setText("");
//    }
        
    }//GEN-LAST:event_submitjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField networkNameJTextField;
    private javax.swing.JTable networkjTable;
    private javax.swing.JButton submitjButton;
    // End of variables declaration//GEN-END:variables
}
