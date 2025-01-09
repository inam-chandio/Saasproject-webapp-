<!-- familyMembers.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Family Members</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Family Members</h1>
    <form action="FamilyMemberServlet" method="post">
        <input type="text" name="name" placeholder="Name" required>
        <input type="text" name="role" placeholder="Role" required>
        <input type="date" name="dob" placeholder="Date of Birth" required>
        <input type="email" name="email" placeholder="Email">
        <input type="text" name="telephone" placeholder="Telephone">
        <textarea name="notes" placeholder="Notes"></textarea>
        <button type="submit">Add Member</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>Notes</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows should be dynamically generated here -->
        </tbody>
    </table>
</body>
</html>
