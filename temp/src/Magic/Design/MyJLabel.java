/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Magic.Design;

/**
 *
 * @author HP
 */
public class MyJLabel extends javax.swing.JLabel{
    public MyJLabel() {
        
        setMagicDesign();
    }

    private void setMagicDesign() {
        
//        this.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        this.setForeground(new java.awt.Color(0, 0, 0));
        
        this.setBackground(new java.awt.Color(255, 255, 255));

        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


    }
}
