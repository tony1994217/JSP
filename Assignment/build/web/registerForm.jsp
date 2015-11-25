<%-- 
    Document   : registerForm
    Created on : 2015年11月23日, 上午11:08:39
    Author     : tony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="handleCustomer?action=register">
            <input type="hidden" value="1" name="custId">
            <input type="hidden" value="N" name="isLoggedIn">
            <table>
                <tr><td>Name:</td><td><input type="text" name="name"></td></tr>
                <tr><td>Telephone Number:</td><td><input type="text" name="telephone"></td></tr>
                <tr><td>Delivery Address:</td><td><input type="text" name="delivery"></td></tr>
            </table>
        </form>
    </body>
</html>
