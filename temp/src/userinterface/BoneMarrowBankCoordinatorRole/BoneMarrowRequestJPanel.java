/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Bone_Marrow_Bank_CoordinatorRole;

import Business.HLA.PersonHLA;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Magic.Design.*;
import Business.Organization.Organization;
import Business.Organization.Bone_Marrow_Bank_Organization;
import Business.Organization.SystemCoordinatorOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import Magic.Design.MyJLabel;
import Magic.Design.MyJButton;
import Magic.Design.MyTableFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abhishekmathukiya
 */
public class BoneMarrowRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BoneMarrowRequestJPanel
     */
    private UserAccount userAccount;
    private Bone_Marrow_Bank_Organization marroworganization;
    private Enterprise enterprise;
    private Network network;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private EcoSystem system;
    
    public BoneMarrowRequestJPanel(UserAccount userAccount, Bone_Marrow_Bank_Organization bmBankOrganization, Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userAccount = userAccount;
        this.marroworganization = bmBankOrganization;
        this.enterprise = enterprise;
        this.network = network;
        this.system = system;
         
        tblBoneMarrowCoordinator.getTableHeader().setDefaultRenderer(new MyTableFormat());
        tblHLAAvailability.getTableHeader().setDefaultRenderer(new MyTableFormat());
        
        
        populateBoneMarrowCoordinatorTable();
        populateHlaAvailabilityTable();
        
        HideApproveLael();
    }

    private void HideApproveLael(){
        approveLabel.setVisible(false);
    }
   
    public void populateBoneMarrowCoordinatorTable(){
        DefaultTableModel model = (DefaultTableModel)tblBoneMarrowCoordinator.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getPatient();
            row[2] = request.getPatient().getName();
            row[3] = request.getPatient().getEmailID();
            row[4] = String.join(", ",request.getPatient().getHLA().getHlaValuesList());
            row[5] = request.getStatus();
             
            model.addRow(row);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblListOfBoneMarrowRequests = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnOnHold = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBoneMarrowCoordinator = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblBoneMarrowBank = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHLAAvailability = new javax.swing.JTable();
        lblBoneMarrowInventory = new javax.swing.JLabel();
        approveLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 720));
        setPreferredSize(new java.awt.Dimension(1150, 830));

        lblListOfBoneMarrowRequests.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblListOfBoneMarrowRequests.setText("List of BoneMarrow Requests");

        btnApprove.setBackground(new java.awt.Color(102, 102, 102));
        btnApprove.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnApprove.setText("Approve Request");
        btnApprove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnOnHold.setBackground(new java.awt.Color(102, 102, 102));
        btnOnHold.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnOnHold.setForeground(new java.awt.Color(255, 255, 255));
        btnOnHold.setText("Hold Request");
        btnOnHold.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOnHold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnHoldActionPerformed(evt);
            }
        });

        tblBoneMarrowCoordinator.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblBoneMarrowCoordinator.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Number", "Patient ID", "Patient Name", "Email ID", "HLA", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBoneMarrowCoordinator.setGridColor(new java.awt.Color(0, 0, 0));
        tblBoneMarrowCoordinator.setRowHeight(30);
        tblBoneMarrowCoordinator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBoneMarrowCoordinatorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBoneMarrowCoordinator);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        lblBoneMarrowBank.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblBoneMarrowBank.setForeground(new java.awt.Color(255, 255, 255));
        lblBoneMarrowBank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoneMarrowBank.setText("Bone Marrow Bank");
        lblBoneMarrowBank.setMaximumSize(new java.awt.Dimension(350, 28));
        lblBoneMarrowBank.setMinimumSize(new java.awt.Dimension(350, 28));
        lblBoneMarrowBank.setPreferredSize(new java.awt.Dimension(350, 28));
        jPanel3.add(lblBoneMarrowBank);

        tblHLAAvailability.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblHLAAvailability.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HLA Combination", "Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHLAAvailability.setRowHeight(30);
        jScrollPane1.setViewportView(tblHLAAvailability);
        if (tblHLAAvailability.getColumnModel().getColumnCount() > 0) {
            tblHLAAvailability.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        lblBoneMarrowInventory.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblBoneMarrowInventory.setText("Bone Marrow Inventory");

        approveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/BloodLeukemia_Centre_Coordinator_Role/approve1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(btnOnHold, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(approveLabel)
                .addGap(155, 155, 155))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(lblBoneMarrowInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel2))))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(lblListOfBoneMarrowRequests))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblBoneMarrowInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2)))
                .addGap(20, 20, 20)
                .addComponent(lblListOfBoneMarrowRequests)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOnHold, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(btnApprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(approveLabel))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        approveLabel.setVisible(true);
        
        int selectedRow = tblBoneMarrowCoordinator.getSelectedRow();
        
        if (selectedRow < 0){
            //JOptionPane.showMessageDialog(null, "Please select a row first!" );
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the table</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        else{
            WorkRequest request = (WorkRequest)tblBoneMarrowCoordinator.getValueAt(selectedRow, 0);
            if(request.getStatus().equals("Legally Approved. Passing to BoneMarrowBank")
                || request.getStatus().equals("On Hold Due to BoneMarrow unavailability")){
                
                dB4OUtil.storeSystem(system);
                populateBoneMarrowCoordinatorTable();
        
                Enterprise ent = null;
                Organization org = null;
        
                for (Enterprise enterprise : network.getEnterprise_Directory().getEnterpriseList()) {
                    if (enterprise.getEnterpriseType().toString().equals("Hospital")) {
                            ent = enterprise;
                            break;
                    }
                }
                
                if(ent == null) {
                    JOptionPane.showMessageDialog(null, 
                            new JLabel(  "<html><b>There is no Hospital Enterprise.<br> Cannot proceed..</b></html>")
                            , "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                    if(organization instanceof SystemCoordinatorOrganization) {
                        org = organization;
                        break;
                    }
                }
        
                if (org != null) {
                    request.setStatus("BoneMarrowBank Approved. Passing to System Coordinator");
                    org.getWorkQueue().getWorkRequestList().add(request);
                }
                else {
                    JOptionPane.showMessageDialog(null, "No organization present", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                 JOptionPane.showMessageDialog(null, new JLabel("<html><b>Work Request is already in progress!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
                
            }
        }
            
     dB4OUtil.storeSystem(system);
        
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnOnHoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnHoldActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblBoneMarrowCoordinator.getSelectedRow();
        
        if (selectedRow < 0){
            //JOptionPane.showMessageDialog(null, "Please select a row first!" );
            
            JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the table!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
            
            
            return;
        }
        else{
            WorkRequest request = (WorkRequest)tblBoneMarrowCoordinator.getValueAt(selectedRow, 0);
            if(request.getStatus().equals("Legally Approved. Passing to BoneMarrowBank")){
                request.setStatus("On Hold Due to BoneMarrow unavailability");
                
                dB4OUtil.storeSystem(system);
                populateBoneMarrowCoordinatorTable();   
            }
            else{
              JOptionPane.showMessageDialog(null, new JLabel("<html><b>Work Request is already in progress!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
                
              //  JOptionPane.showMessageDialog(null, "Work Request is already in progress!" ); 
            }
        }
        
    }//GEN-LAST:event_btnOnHoldActionPerformed

    private void tblBoneMarrowCoordinatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBoneMarrowCoordinatorMouseClicked
        // TODO add your handling code here:
        
        int selectedRow = tblBoneMarrowCoordinator.getSelectedRow();
       // jPanel1.setVisible(true);
        if (selectedRow < 0){   
            //JOptionPane.showMessageDialog(null, new JLabel(  "<html><b>Please select a row from the table!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
             return;
        }
         else{
            WorkRequest request = (WorkRequest)tblBoneMarrowCoordinator.getValueAt(selectedRow, 0);
            if(request.getStatus().equals("Legally Approved. Passing to BoneMarrowBank")){
                //request.setStatus("On Hold Due to BoneMarrow unavailability");
                if(request.getPatient().isEmergencyStatus() == true){
                    JOptionPane.showMessageDialog(null, new JLabel("Legally Approved. Passing to BoneMarrowBank"), "Warning", JOptionPane.WARNING_MESSAGE);
                }
                //dB4OUtil.storeSystem(system);
                //populateBoneMarrowCoordinatorTable();   
            }
            else{
              //JOptionPane.showMessageDialog(null, new JLabel("<html><b>Work Request is already in progress!</b></html>"), "Warning", JOptionPane.WARNING_MESSAGE);
//                 jPanel1.setVisible(false);
              //  JOptionPane.showMessageDialog(null, "Work Request is already in progress!" ); 
            }
        }
        
        
        
    }//GEN-LAST:event_tblBoneMarrowCoordinatorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel approveLabel;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnOnHold;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBoneMarrowBank;
    private javax.swing.JLabel lblBoneMarrowInventory;
    private javax.swing.JLabel lblListOfBoneMarrowRequests;
    private javax.swing.JTable tblBoneMarrowCoordinator;
    private javax.swing.JTable tblHLAAvailability;
    // End of variables declaration//GEN-END:variables

    private void populateHlaAvailabilityTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblHLAAvailability.getModel();
        dtm.setRowCount(0);
//        marroworganization.getInventory().HLACountAdd(new PersonHLA().updateHLAlist("HLA_A,HLA_B"),6);
//        marroworganization.getInventory().HLACountAdd(new PersonHLA().updateHLAlist("HLA_A"),5);
//        marroworganization.getInventory().HLACountAdd(new PersonHLA().updateHLAlist("HLA_A,HLA_B,HLA_C"),7);
//        dB4OUtil.storeSystem(system);
        for(Map.Entry<String, Integer> hlaCount : marroworganization.getInventoryData().entrySet()) {
            
            Object row[] = new Object[2];
            row[0]= hlaCount.getKey().toString();
            row[1]=hlaCount.getValue();
              
            dtm.addRow(row);
            
        }
    }
}
