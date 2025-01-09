<!-- events.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Events Calendar</h1>
    <form action="EventServlet" method="post">
        <input type="text" name="title" placeholder="Event Title" required>
        <textarea name="description" placeholder="Description"></textarea>
        <input type="datetime-local" name="startDate" placeholder="Start Date" required>
        <input type="datetime-local" name="endDate" placeholder="End Date" required>
        <input type="text" name="type" placeholder="Type">
        <input type="checkbox" name="recurring" value="true"> Recurring
        <button type="submit">Add Event</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Type</th>
                <th>Recurring</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows should be dynamically generated here -->
        </tbody>
    </table>
</body>
</html>
