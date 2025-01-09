<!-- shoppingList.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping List</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
body>
    <h1>Shopping List</h1>
    <form action="ShoppingListServlet" method="post">
        <input type="text" name="itemName" placeholder="Item Name" required>
        <input type="number" name="quantity" placeholder="Quantity" required>
        <input type="text" name="category" placeholder="Category">
        <input type="checkbox" name="purchased" value="true"> Purchased
        <button type="submit">Add Item</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Category</th>
                <th>Purchased</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows should be dynamically generated here -->
        </tbody>
    </table>
</body>
</html>
