<!-- tasks.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tasks</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Manage Tasks</h1>
    <form action="TaskServlet" method="post">
        <input type="text" name="description" placeholder="Description" required>
        <input type="date" name="dueDate" placeholder="Due Date" required>
        <input type="checkbox" name="completed" value="true"> Completed
        <input type="number" name="points" placeholder="Points" required>
        <button type="submit">Add Task</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Description</th>
                <th>Due Date</th>
                <th>Completed</th>
                <th>Points</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows should be dynamically generated here -->
        </tbody>
    </table>
</body>
</html>
