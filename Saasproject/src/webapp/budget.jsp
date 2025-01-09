<!-- budget.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
head>
    <title>Budget</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Budget Overview</h1>
    <form action="BudgetServlet" method="post">
        <input type="text" name="category" placeholder="Category" required>
        <input type="number" name="amount" placeholder="Amount" required>
        <input type="date" name="transactionDate" placeholder="Date" required>
        <select name="type">
            <option value="income">Income</option>
            <option value="expense">Expense</option>
        </select>
        <button type="submit">Record Transaction</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Category</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Type</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows should be dynamically generated here -->
        </tbody>
    </table>
</body>
</html>
