<%-- 
    Document   : index
    Created on : 17 Mar, 2017, 4:11:32 PM
    Author     : PAVAN VARMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Capture Face</title>
</head>
<body>
<center>
<strong>Check Mail for Customer ID</strong><br><br>
<form action="/WebApp/DetecF" method="post">
Enter Your Customer ID: <input type="text" name="cus_id" /><br><br>
Enter Your Name: <input type="text" name="cus_name" /><br><br>
<input type="Submit" name="scan_face" value="Scan Face" /><br><br>
</form>
</center>
</body>
</html>