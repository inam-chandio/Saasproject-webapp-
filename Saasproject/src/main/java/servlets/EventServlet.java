package servlets;

import utils.DatabaseConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String startDate = request.getParameter("startDate"); // "yyyy-MM-dd HH:mm"
        String endDate = request.getParameter("endDate"); // "yyyy-MM-dd HH:mm"
        String type = request.getParameter("type");
        boolean recurring = Boolean.parseBoolean(request.getParameter("recurring"));

        try {
            saveEvent(title, description, startDate, endDate, type, recurring);
            response.sendRedirect("events.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing request");
        }
    }

    private void saveEvent(String title, String description, String startDate, String endDate, String type, boolean recurring) throws SQLException {
        String sql = "INSERT INTO events (title, description, start_date, end_date, type, recurring) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(startDate));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(endDate));
            stmt.setString(5, type);
            stmt.setBoolean(6, recurring);
            stmt.executeUpdate();
        }
    }
}
