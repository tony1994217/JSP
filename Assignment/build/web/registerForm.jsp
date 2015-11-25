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
        <link rel="stylesheet" type="text/css" href="css/mystyles.css">
        <style type="text/css">
        </style>
    <body bgcolor="#F2F2F2">
        <form method="get" action="handleCustomer?action=register" id="registerTable">
            <h1 style="color:#585858;">Please Sign Up</h1>
            <input type="hidden" value="1" name="custId">
            <table>
                <tr><td>Full Name:*</td><td><input id="registerText" type="text"  name="custFullName" placeholder="Your full name" ></td></tr>
                <tr><td>TelephonePhone Number:*</td><td><input id="registerText" type="text" name="custTel" placeholder="(within 8 numbers)"></td></tr>
                <tr><td>Delivery Address:*</td><td><input id="registerText" type="text" name="custAddress" placeholder="(within 50 numbers)"></td></tr>
                <tr><td><label style="font-size: 15px;">* = cannot be null</label></td><td  style="text-align: right;"><input type="reset" id="but" value="Reset" > <input type="submit" id="but" value="Sign Up"></td></tr>
            </table>
        </form>
    </body>
</html>
