/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.SystemAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author relaince
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    public SystemAdminWorkAreaJPanel(JPanel upc, EcoSystem ecoSystem) {
        initComponents();
        userProcessContainer = upc;
        this.ecoSystem = ecoSystem;
        populateTree();
    }

    private void populateTree(){
        DefaultTreeModel model = (DefaultTreeModel)ecoSystemjTree.getModel();
        ArrayList<Network> networkList = ecoSystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Enterprise enterprise;
        Organization organization;
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
                       
        for(int i = 0; i<networkList.size();i++){
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
        
            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j < enterpriseList.size();j++){
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0; k < organizationList.size(); k++){
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
                
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ecoSystemjTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        manageNetworkjButton = new javax.swing.JButton();
        manageEnterprisejButton = new javax.swing.JButton();
        manageEnterpriseAdminjButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(150);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("EcoSystem");
        ecoSystemjTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(ecoSystemjTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkjButton.setText("Manage Network");
        manageNetworkjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkjButtonActionPerformed(evt);
            }
        });
        jPanel2.add(manageNetworkjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, -1, -1));

        manageEnterprisejButton.setText("Manage Enterprise");
        manageEnterprisejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterprisejButtonActionPerformed(evt);
            }
        });
        jPanel2.add(manageEnterprisejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, -1));

        manageEnterpriseAdminjButton.setText("Manage Enterprise Admin");
        manageEnterpriseAdminjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseAdminjButtonActionPerformed(evt);
            }
        });
        jPanel2.add(manageEnterpriseAdminjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jSplitPane1.setRightComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageNetworkjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkjButtonActionPerformed
        ManageNetworkJPanel mnjp = new ManageNetworkJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageNetworkJPanel",mnjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkjButtonActionPerformed

    private void manageEnterprisejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterprisejButtonActionPerformed
        ManageEnterpriseJPanel mejp = new ManageEnterpriseJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageEnterpriseJPanel",mejp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterprisejButtonActionPerformed

    private void manageEnterpriseAdminjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseAdminjButtonActionPerformed
        ManageEnterpriseAdminJPanel meajp = new ManageEnterpriseAdminJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageEnterpriseAdminJPanel",meajp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseAdminjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ecoSystemjTree;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageEnterpriseAdminjButton;
    private javax.swing.JButton manageEnterprisejButton;
    private javax.swing.JButton manageNetworkjButton;
    // End of variables declaration//GEN-END:variables
}
