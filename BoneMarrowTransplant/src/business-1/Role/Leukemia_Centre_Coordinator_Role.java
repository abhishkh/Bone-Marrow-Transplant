/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Leukemia_Centre_Organization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.BloodLeukemia_Centre_Coordinator_Role.Leukemia_Centre_Coordinator_WorkAreaJPanel;
/**
 *
 * @author sohamshah
 */
public class Leukemia_Centre_Coordinator_Role extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new Leukemia_Centre_Coordinator_WorkAreaJPanel(account, (Leukemia_Centre_Organization) organization, enterprise, business, network);
    }
}
