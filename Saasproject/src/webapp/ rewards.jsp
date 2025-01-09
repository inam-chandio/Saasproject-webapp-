<!-- rewards.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
head>
    <title>Rewards</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Rewards Management</h1>
    <form action="RewardServlet" method="post">
        <input type="text" name="description" placeholder="Reward Description" required>
        <input type="number" name="pointsRequired" placeholder="Points Required" required>
        <button type="submit">Add Reward</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Description</th>
                <th>Points Required</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows should be dynamically generated here -->
        </tbody>
    </table>
</body>
</html>
