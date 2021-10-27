<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Contacts Handling</title>
</head>
<body>
<h1><%= "Click the appropriate link" %>
</h1>
<br/>
<a href="GET/contacts">Get All Contacts</a>
<br/>
<a href="GET/contacts/282">Get Contacts By Id</a>
<br/>
<a href="DELETE/contacts?id=289">Delete Contact By Id</a>
<br/>
<a href="PUT/contacts?id=287&firstName=Pavlo&lastName=Gorobec&phone=234">Put Contact</a>
<br/>
<a href="POST/contacts?firstName=Nik&lastName=Port&phone=777">Post Contact</a>
</body>
</html>