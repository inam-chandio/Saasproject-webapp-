package models;

import java.util.Date;

// FamilyMember.java
public class FamilyMember {
    private int id;
    private String name;
    private String role;
    private Date dateOfBirth;
    private String email;
    private String telephone;
    private String allergies;
    private String hobbies;
    private String notes;

    // Getters and setters for FamilyMember
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getHobbies() { return hobbies; }
    public void setHobbies(String hobbies) { this.hobbies = hobbies; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}