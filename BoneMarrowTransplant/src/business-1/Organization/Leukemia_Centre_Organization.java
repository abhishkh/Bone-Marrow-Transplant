/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.Leukemia_Centre_Coordinator_Role;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author sohamshah
 */
public class Leukemia_Centre_Organization extends Organization{
    public Leukemia_Centre_Organization() {
        super(Organization.BloodCancerCentreType.BloodCancerCentre.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Leukemia_Centre_Coordinator_Role());
        return roles;
    }
}
