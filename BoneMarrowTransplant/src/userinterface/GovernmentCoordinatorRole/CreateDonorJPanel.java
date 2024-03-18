/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovernmentCoordinatorRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.People.Donor;
import Business.People.DonorDirectory;
import Magic.Design.*;
import Magic.Design.MyJLabel;
import Magic.Design.MyJButton;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Nishita
 */
public class CreateDonorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DonorListJPanel
     */
    private  EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        //InputStream in = Google.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
      // InputStream in =  new FileInputStream("C:\\Users\\adwai\\Documents\\NetBeansProjects\\google\\credentials.json");
        InputStream in =  new FileInputStream("credentials.json");
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");

    }
    
    public CreateDonorJPanel(EcoSystem system) throws GeneralSecurityException, IOException {
        initComponents();
        this.system = system;


        tblDonorDetails.getTableHeader().setDefaultRenderer(new MyTableFormat());
        tblDonorTable.getTableHeader().setDefaultRenderer(new MyTableFormat());
        populateTable();   
        populateGoogleSheetTable();
         
    }
     
    private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblDonorTable.getModel();
        
        dtm.setRowCount(0);
        
         for(Donor donor: system.getDonorDirectory().getDonorList()){            
            Object row[] = new Object[2];
            row[0]= donor;
            row[1]=donor.getName();
           // row[2]=donor.getContact();
              
            dtm.addRow(row);
        }        
    }

    
    private void populateGoogleSheetTable() throws GeneralSecurityException, IOException{
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1YulpIxHOwFfDMM57n7hbxZueFSsw-q414bD5tzNMUv0";
        final String range = "Form Responses 2!A2:S";
        //final String range = "Form Responses 1!A2:E";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            
            DefaultTableModel dtm = (DefaultTableModel) tblDonorDetails.getModel();
        
            dtm.setRowCount(0);
            
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
              //  System.out.printf("%s, %s\n", row.get(0), row.get(4));
          //    System.out.printf("%s, %s\n", row.get(0), row.get(1));
              System.out.println(row.get(1));
              System.out.println(row.get(3));
              Object row1[] = new Object[4];
            
            row1[1]=row.get(1);
            row1[2]=row.get(2);
            row1[0]= row.get(3);
            row1[3]=row.get(7);
            dtm.addRow(row1);              
            }
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
        tblDonorDetails = new javax.swing.JTable();
        lblDonorRequests = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        lblCreateProfile = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonorTable = new javax.swing.JTable();
        titleJPanel = new javax.swing.JPanel();
        lblCreateDonorProfile = new javax.swing.JLabel();
        lblUID = new javax.swing.JLabel();
        lblBloodGroup = new javax.swing.JLabel();
        txtUID = new javax.swing.JTextField();
        txtBloodGroup = new javax.swing.JTextField();
        btnCreateDonor = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDonorDetails.setBackground(new java.awt.Color(204, 204, 204));
        tblDonorDetails.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblDonorDetails.setForeground(new java.awt.Color(255, 255, 255));
        tblDonorDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UID", "Name", "Contact", "Blood Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonorDetails.setFocusable(false);
        tblDonorDetails.setGridColor(new java.awt.Color(0, 0, 0));
        tblDonorDetails.setRowHeight(30);
        tblDonorDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDonorDetailsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonorDetails);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 1200, 210));

        lblDonorRequests.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblDonorRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonorRequests.setText("Donor Requests");
        add(lblDonorRequests, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 210, -1));

        lblName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblName.setText("Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 70, 30));

        lblContact.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblContact.setText("Contact");
        add(lblContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, -1, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtName.setEnabled(false);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 212, -1));

        txtContact.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtContact.setEnabled(false);
        add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 212, -1));

        lblCreateProfile.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lblCreateProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateProfile.setText("Create Donor Profile");
        add(lblCreateProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));

        tblDonorTable.setBackground(new java.awt.Color(204, 204, 204));
        tblDonorTable.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tblDonorTable.setForeground(new java.awt.Color(255, 255, 255));
        tblDonorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonorTable.setGridColor(new java.awt.Color(0, 0, 0));
        tblDonorTable.setRowHeight(30);
        jScrollPane2.setViewportView(tblDonorTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 1180, 220));

        titleJPanel.setBackground(new java.awt.Color(102, 102, 102));
        titleJPanel.setPreferredSize(new java.awt.Dimension(926, 70));

        lblCreateDonorProfile.setBackground(new java.awt.Color(102, 102, 102));
        lblCreateDonorProfile.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCreateDonorProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateDonorProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateDonorProfile.setText("Create Donor Profile");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addComponent(lblCreateDonorProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 1457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 143, Short.MAX_VALUE))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCreateDonorProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(titleJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, -1));

        lblUID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUID.setText("UID");
        add(lblUID, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, -1, -1));

        lblBloodGroup.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBloodGroup.setText("Blood Group");
        add(lblBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, -1, 30));

        txtUID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtUID.setEnabled(false);
        add(txtUID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 420, 230, -1));

        txtBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtBloodGroup.setEnabled(false);
        add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 230, -1));

        btnCreateDonor.setBackground(new java.awt.Color(102, 102, 102));
        btnCreateDonor.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateDonor.setText("Create Donor");
        btnCreateDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDonorActionPerformed(evt);
            }
        });
        add(btnCreateDonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 120, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void tblDonorDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonorDetailsMousePressed
        // TODO add your handling code here:
                // TODO add your handling code here:
        
         int selectedRow = tblDonorDetails.getSelectedRow();
        if(selectedRow < 0){

        }
        else{
                    
        txtName.setText( String.valueOf(tblDonorDetails.getValueAt(selectedRow, 1)));
        txtContact.setText( String.valueOf(tblDonorDetails.getValueAt(selectedRow, 2)));
        txtUID.setText( String.valueOf(tblDonorDetails.getValueAt(selectedRow, 0)));
        txtBloodGroup.setText( String.valueOf(tblDonorDetails.getValueAt(selectedRow, 3)));
        
        btnCreateDonor.setEnabled(true);
        }
    }//GEN-LAST:event_tblDonorDetailsMousePressed

    private void btnCreateDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDonorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateDonorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateDonor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBloodGroup;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblCreateDonorProfile;
    private javax.swing.JLabel lblCreateProfile;
    private javax.swing.JLabel lblDonorRequests;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblUID;
    private javax.swing.JTable tblDonorDetails;
    private javax.swing.JTable tblDonorTable;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JTextField txtBloodGroup;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUID;
    // End of variables declaration//GEN-END:variables
}
