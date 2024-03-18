/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.GovernmentCoordinatorRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author sohamshah
 */
public class GovernmentOrganization extends Organization {
    public GovernmentOrganization() {
        super(Organization.GovernmentType.Government.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new GovernmentCoordinatorRole());
        return roles;
    }
}
