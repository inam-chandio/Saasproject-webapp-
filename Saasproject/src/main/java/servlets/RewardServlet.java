package servlets;

import utils.DatabaseConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        int pointsRequired = Integer.parseInt(request.getParameter("pointsRequired"));

        try {
            saveReward(description, pointsRequired);
            response.sendRedirect("rewards.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing request");
        }
    }

    private void saveReward(String description, int pointsRequired) throws SQLException {
        String sql = "INSERT INTO rewards (description, points_required) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, description);
            stmt.setInt(2, pointsRequired);
            stmt.executeUpdate();
        }
    }
}
