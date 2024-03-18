/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Magic.Design.MyJLabel;
import Magic.Design.MyJTextField;
import static Business.Enterprise.Enterprise.EnterpriseType.HRSA;
import static Business.Enterprise.Enterprise.EnterpriseType.Legal;
import Business.Organization.Organization;
import Business.Organization.Organization.BloodCancerCentreType;
import Business.Organization.Organization.GovernmentType;
import Business.Organization.Organization.LegalType;
import Business.Organization.Organization.BoneMarrowBankType;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Magic.Design.MyTableFormat;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static Business.Enterprise.Enterprise.EnterpriseType.BloodCancerCentre;
import static Business.Enterprise.Enterprise.EnterpriseType.BoneMarrowBank;
import Magic.Design.MyJButton;


/**
 *
 * @author abhishekmathukiya
 */


public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer,OrganizationDirectory directory, Enterprise enterprise, EcoSystem system ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise = enterprise;
        this.system = system;
        tblOrganization.getTableHeader().setDefaultRenderer(new MyTableFormat());
        txtEnterpriseName.setText(enterprise.getName());
        populateTable();
        populateCombo();
    }
    
    private void populateCombo(){
        cmbOrganizationType.removeAllItems();
        boolean add = true; 
       // for (Type type : Organization.Type.values()){
        //    if (!type.getValue().equals(Type.Admin.getValue()))
        //        organizationJComboBox.addItem(type);
       // }
       
       System.out.println(enterprise.getEnterpriseType());
       System.out.println(enterprise.getEnterpriseType().toString().equals(BoneMarrowBank.toString()));
       if(enterprise.getEnterpriseType().toString().equals(Legal.toString())){
        for(Organization.LegalType legalType: Organization.LegalType.values()){
            add = true;
            if (legalType.getValue().equals(Organization.LegalType.LegalOfficer.getValue())){
                for (Organization organization : directory.getOrganizationList()) {
                    if(organization.getName().equals(legalType.getValue()))
                        add = false;
                }
                if(add)
                    cmbOrganizationType.addItem(legalType);
            }
        }
        }
       
       else if(enterprise.getEnterpriseType().toString().equals(BoneMarrowBank.toString())){
        for(Organization.BoneMarrowBankType bmType: Organization.BoneMarrowBankType.values()){
            add = true;
            System.out.println(bmType.getValue());
            System.out.println(Organization.BoneMarrowBankType.BoneMarrowBank.getValue());
            if (bmType.getValue().equals(Organization.BoneMarrowBankType.BoneMarrowBank.getValue())){
                for (Organization organization : directory.getOrganizationList()) {
                    if(organization.getName().equals(bmType.getValue()))
                        add = false;
                }
                if(add)
                    cmbOrganizationType.addItem(bmType);
            }
        }
        }
       else if(enterprise.getEnterpriseType().toString().equals(BloodCancerCentre.toString())){
        for(Organization.BloodCancerCentreType cancerType: Organization.BloodCancerCentreType.values()){
            if (cancerType.getValue().equals(Organization.BloodCancerCentreType.BloodCancerCentre.getValue())){
                cmbOrganizationType.addItem(cancerType);
            }
        }
        }
       else if(enterprise.getEnterpriseType().toString().equals(HRSA.toString())){
        for(Organization.GovernmentType govtType: Organization.GovernmentType.values()){
            add = true;
            if (govtType.getValue().equals(Organization.GovernmentType.Government.getValue())){
                for (Organization organization : directory.getOrganizationList()) {
                    if(organization.getName().equals(govtType.getValue()))
                        add = false;
                }
                if(add)
                    cmbOrganizationType.addItem(govtType);
            }
        }
        }
       else{
        for (Organization.Type type : Organization.Type.values()){ 
            add = true;
            if (type.getValue().equals(Organization.Type.SystemCoordinator.getValue())
                    ||type.getValue().equals(Organization.Type.Doctor.getValue())
                    ||type.getValue().equals(Organization.Type.MedicalTechnician.getValue())
                    ) {
                for (Organization organization : directory.getOrganizationList()) {
                    if(organization.getName().equals(type.getValue()))
                        add = false;
                }
                if(add)
                    cmbOrganizationType.addItem(type);
            }
        }
       
    }
    }
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrganization.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getName();
            row[1] = organization.getRealName();
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganization = new javax.swing.JTable();
        panel1 = new javax.swing.JPanel();
        lblCreateOrganization = new javax.swing.JLabel();
        lblNameOfOrganization = new javax.swing.JLabel();
        txtOrganizationName = new javax.swing.JTextField();
        nameSeparator = new javax.swing.JSeparator();
        cmbOrganizationType = new javax.swing.JComboBox();
        lblSelectOrganizationType = new javax.swing.JLabel();
        btnAddOrganization = new javax.swing.JButton();
        nameSeparator2 = new javax.swing.JSeparator();
        nameSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        lblManageOrganization = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        nameSeparator4 = new javax.swing.JSeparator();
        txtEnterpriseName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 204));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1150, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));

        tblOrganization.setBackground(new java.awt.Color(153, 153, 153));
        tblOrganization.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 255, 204)));
        tblOrganization.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblOrganization.setForeground(new java.awt.Color(255, 255, 255));
        tblOrganization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization Type", "Organization Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        tblOrganization.setGridColor(new java.awt.Color(0, 0, 0));
        tblOrganization.setRowHeight(30);
        jScrollPane1.setViewportView(tblOrganization);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 650, 200));

        panel1.setBackground(new java.awt.Color(255, 204, 204));
        panel1.setPreferredSize(new java.awt.Dimension(250, 400));
        panel1.setRequestFocusEnabled(false);
        panel1.setVerifyInputWhenFocusTarget(false);
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCreateOrganization.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblCreateOrganization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateOrganization.setText("Create Organization");
        panel1.add(lblCreateOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 328, 36));

        lblNameOfOrganization.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNameOfOrganization.setText("Name of Organization");
        panel1.add(lblNameOfOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, 26));

        txtOrganizationName.setBackground(new java.awt.Color(242, 242, 242));
        txtOrganizationName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtOrganizationName.setBorder(null);
        txtOrganizationName.setCaretColor(new java.awt.Color(30, 59, 92));
        txtOrganizationName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOrganizationNameFocusGained(evt);
            }
        });
        txtOrganizationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrganizationNameActionPerformed(evt);
            }
        });
        panel1.add(txtOrganizationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 270, 30));

        nameSeparator.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(nameSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 280, 10));

        cmbOrganizationType.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });
        panel1.add(cmbOrganizationType, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 240, 30));

        lblSelectOrganizationType.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSelectOrganizationType.setText("Select Organization Type ");
        panel1.add(lblSelectOrganizationType, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 220, -1));

        btnAddOrganization.setBackground(new java.awt.Color(153, 153, 153));
        btnAddOrganization.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAddOrganization.setText("Add Organization");
        btnAddOrganization.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrganizationActionPerformed(evt);
            }
        });
        panel1.add(btnAddOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 130, 40));

        nameSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(nameSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 290, 10));

        nameSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(nameSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 290, 10));

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1030, 350));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(926, 70));

        lblManageOrganization.setBackground(new java.awt.Color(255, 153, 153));
        lblManageOrganization.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblManageOrganization.setForeground(new java.awt.Color(255, 255, 255));
        lblManageOrganization.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblManageOrganization.setText("                                                               Manage Organization");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblManageOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, 1668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblManageOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1680, -1));

        lblEnterprise.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEnterprise.setText("Enterprise:");
        add(lblEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, -1, -1));

        nameSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        add(nameSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 240, 10));

        txtEnterpriseName.setEditable(false);
        txtEnterpriseName.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtEnterpriseName.setBorder(null);
        add(txtEnterpriseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrganizationActionPerformed

        String check1 = "";    
        
        if (txtOrganizationName.getText().isEmpty()) {
            txtOrganizationName.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtOrganizationName.setForeground(Color.red);

            JOptionPane.showMessageDialog(null, 
                    new JLabel("<html><b>Organization Name can not be empty!</b></html>") , 
                    "Error", JOptionPane.ERROR_MESSAGE);
                   

            //JOptionPane.showMessageDialog(null, "Organization name cannot be empty!");
            check1 = "do not go further!";
            return;
        }

        
        for (Organization organization : directory.getOrganizationList()) {

            if (organization.getName().equals(txtOrganizationName.getText())) {
                
            JOptionPane.showMessageDialog(null, 
                    new JLabel("<html><b>Organization name already exists!</b></html>") , 
                    "Error", JOptionPane.ERROR_MESSAGE);
            
                check1 = "do not go further!";
                return;
            }
        }

// Main Process after validation checks
        if(check1.equals("")){
        if(enterprise.getEnterpriseType().toString().equals(Legal.toString())){
            directory.createLegalOrganization((LegalType)cmbOrganizationType.getSelectedItem(), txtOrganizationName.getText());
        }
        else if(enterprise.getEnterpriseType().toString().equals(HRSA.toString())){
            directory.createGovernmentOrganization((GovernmentType)cmbOrganizationType.getSelectedItem(), txtOrganizationName.getText());
        }
        else if(enterprise.getEnterpriseType().toString().equals(BoneMarrowBank.toString())){
            directory.createBoneMarrowOrganization((BoneMarrowBankType)cmbOrganizationType.getSelectedItem(), txtOrganizationName.getText());
        }
        else if(enterprise.getEnterpriseType().toString().equals(BloodCancerCentre.toString())){
            directory.createCancerCentreOrganization((BloodCancerCentreType)cmbOrganizationType.getSelectedItem(), txtOrganizationName.getText());
        }
        else{
            
        Type type = (Type) cmbOrganizationType.getSelectedItem();
        directory.createOrganization(type, txtOrganizationName.getText());
        }
        populateTable();
        
        
       JOptionPane.showMessageDialog(null, 
               new JLabel("<html><b>"+ txtOrganizationName.getText() + " Organization Created!</b></html>"),
                "Approved",
                JOptionPane.INFORMATION_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/images/approved.png"))
       );
                   
        
        
        dB4OUtil.storeSystem(system);
        
        
        txtOrganizationName.setText("");
//        organizationJComboBox.removeItem(organizationJComboBox.getSelectedItem());
        }
        populateCombo();
    }//GEN-LAST:event_btnAddOrganizationActionPerformed

    private void txtOrganizationNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrganizationNameFocusGained
        // TODO add your handling code here:
        txtOrganizationName.setText("");
    }//GEN-LAST:event_txtOrganizationNameFocusGained

    private void txtOrganizationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrganizationNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrganizationNameActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrganization;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCreateOrganization;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblManageOrganization;
    private javax.swing.JLabel lblNameOfOrganization;
    private javax.swing.JLabel lblSelectOrganizationType;
    private javax.swing.JSeparator nameSeparator;
    private javax.swing.JSeparator nameSeparator1;
    private javax.swing.JSeparator nameSeparator2;
    private javax.swing.JSeparator nameSeparator4;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable tblOrganization;
    private javax.swing.JTextField txtEnterpriseName;
    private javax.swing.JTextField txtOrganizationName;
    // End of variables declaration//GEN-END:variables
}
