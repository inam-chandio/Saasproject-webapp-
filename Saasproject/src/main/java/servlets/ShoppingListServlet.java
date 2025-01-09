package servlets;

import utils.DatabaseConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShoppingListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String category = request.getParameter("category");
        boolean purchased = Boolean.parseBoolean(request.getParameter("purchased"));

        try {
            saveShoppingItem(itemName, quantity, category, purchased);
            response.sendRedirect("shoppingList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing request");
        }
    }

    private void saveShoppingItem(String itemName, int quantity, String category, boolean purchased) throws SQLException {
        String sql = "INSERT INTO shopping_list (item_name, quantity, category, purchased) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, itemName);
            stmt.setInt(2, quantity);
            stmt.setString(3, category);
            stmt.setBoolean(4, purchased);
            stmt.executeUpdate();
        }
    }
}
