package servlets;

import utils.DatabaseConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate"); // "yyyy-MM-dd"
        boolean completed = Boolean.parseBoolean(request.getParameter("completed"));
        int points = Integer.parseInt(request.getParameter("points"));

        try {
            saveTask(description, dueDate, completed, points);
            response.sendRedirect("tasks.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing request");
        }
    }

    private void saveTask(String description, String dueDate, boolean completed, int points) throws SQLException {
        String sql = "INSERT INTO tasks (description, due_date, completed, points) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, description);
            stmt.setDate(2, java.sql.Date.valueOf(dueDate));
            stmt.setBoolean(3, completed);
            stmt.setInt(4, points);
            stmt.executeUpdate();
        }
    }
}
