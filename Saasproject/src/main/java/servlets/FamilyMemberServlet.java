package servlets;

import models.FamilyMember;
import utils.DatabaseConnection;
import java.util.Date;
//import utils.DatabaseConnection;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class FamilyMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String dob = request.getParameter("dob"); // Expecting date in "yyyy-MM-dd" format
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String allergies = request.getParameter("allergies");
        String hobbies = request.getParameter("hobbies");
        String notes = request.getParameter("notes");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateOfBirth = sdf.parse(dob);
            FamilyMember member = new FamilyMember();
            member.setName(name);
            member.setRole(role);
            member.setDateOfBirth(new java.sql.Date(dateOfBirth.getTime()));
            member.setEmail(email);
            member.setTelephone(telephone);
            member.setAllergies(allergies);
            member.setHobbies(hobbies);
            member.setNotes(notes);

            saveFamilyMember(member);
            response.sendRedirect("familyMembers.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing request");
        }
    }

    private void saveFamilyMember(FamilyMember member) throws SQLException {
        String sql = "INSERT INTO family_members (name, role, date_of_birth, email, telephone, allergies, hobbies, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getRole());
            stmt.setDate(3, (java.sql.Date) member.getDateOfBirth());
            stmt.setString(4, member.getEmail());
            stmt.setString(5, member.getTelephone());
            stmt.setString(6, member.getAllergies());
            stmt.setString(7, member.getHobbies());
            stmt.setString(8, member.getNotes());

            stmt.executeUpdate();
        }
    }
}
