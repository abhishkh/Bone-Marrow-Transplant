/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.LegalOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author sohamshah
 */
public class LegalOfficerOrganization extends Organization {
     public LegalOfficerOrganization() {
        super(Organization.LegalType.LegalOfficer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LegalOfficerRole());
        return roles;
    }
}
