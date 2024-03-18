# **Bone Marrow Donation System**

## **About**

----------------------------------------------------------------------------------------------------

We have built an application that allows people who are suffering from blood cancer to connect with a potential bone marrow donor and receive appropriate treatment from the doctors within their network.

The application allows Donors & Patients to Register and allows the System admin to manage a network, manage enterprises in the selected network and accordingly create the credentials for each enterprise admin. Based on the availability of bone marrow, eligibility of the donor, and consent from the patient, possible treatment will be done by the doctor. The application consists of 5 Enterprises, 7 Organizations & overall 10 roles.

## **Structure**

----------------------------------------------------------------------------------------------------

### **Enterprises: -**

1. Government Enterprise
2. Hospital Enterprise
3. Bone Marrow Center
4. Legal Enterprise
5. Leukemia Curing Enterprise

### **Organizations: -**

1. Health Resource Service Administration
2. Bone Marrow Bank Organization
3. Doctors Organization
4. Cancer Treatment Organization
5. Legal Organization
6. Hospital Coordinators Organization
7. Laboratory Organization

### **Roles: -**

1. **System Admin:** A System Admin can manage networks, choose a network and create Enterprises and credentials for each Enterprise Admin.
2. **Patient:** A Patient can register to seek Bone Marrow Donation and Cancer Treatment. A patient would also sign the consent for the transplant and treatment.
3. **Donor:** A Donor would register to donate Bone Marrow to the Bone Marrow Bank.
4. **Hospital System Coordinator:** A Hospital System Coordinator will assign the donor to the respective Hospital
5. **Doctor:** A Doctor will perform the treatment on the receiver patient and conduct the Bone Marrow Transplant.
6. **Medical Technician:** A Medical Technician will perform appropriate medical tests in the laboratory to make sure the medical history of the Donor and Receiver coincides and is eligible for a successful transplant.
7. **Health Resource Service Officer:** An HRSA Officer receives a work request for Bone Marrow Donation and checks for eligibility of the donor request and approves or rejects it accordingly.
8. **Bone Marrow Bank Coordinator:** A Bone Marrow Bank Coordinator receives a work request from the patient's consent for transplant and checks the inventory to verify the HLA Type and Availability for the procedure of transplant to progress ahead.
9. **Leukemia Center Coordinator:** A Leukemia Center Coordinator receives a work request for curing Cancer and checks for eligibility if the treatment can be conducted or not based on the Patient's diagnosis.
10. **Legal Officer:** A Legal Officer receives a work request for a transplant from the Leukemia Center Coordinator for the procedure and the Legal Officer reviews the decision and decides to approve or reject it.

# **Object Diagram**

<br>
<br>
<image src="Object_Diagram.jpeg">
<br>
<br>

# **Class Diagram**

<br>
<br>
<image src="Class_Diagram.jpg">
<br>
<br>
