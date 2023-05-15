<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des contacts</title>
    <%@ page import="Bean.ContactBean" %>
    <%@ page import="java.util.List" %>
        <%@ page import="java.util.ArrayList" %>
    
</head>
<body>
    <h1>Liste des contacts</h1>
    <table>
        <thead>
            <tr>
                <th>Nom</th>
                <th>E-mail</th>
            </tr>
        </thead>
        <tbody>
            <% 
            // Assuming 'contacts' is a list of ContactBean objects
            List<ContactBean> contacts = new ArrayList<>();
            // Code to populate the 'contacts' list goes here
            for (ContactBean contact : contacts) { 
            %>
                <tr>
                    <td><%= contact.getNom() %></td>
                    <td><%= contact.getEmail() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
