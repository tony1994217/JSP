<%-- 
    Document   : index
    Created on : 2015年11月1日, 下午04:55:37
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
    </head>
    <body>
        <div id="header">
<img src="img/heading.png" width="400" height="100" border="0" alt="setalpm" usemap="#Map">
<form method="get" action="" id="form">
<table>
                    <tr><td>Username:</td><td><input type="text" name="username"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
                    <tr><td><a href="registerForm.jsp">Click here to register</a></td><td align="right"><input type="reset" value="Rest" > <input type="submit" value="Login"></td></tr>
                </table>
</form>
</div>

<div id="nav">
    <nav>
        <a href="index.jsp" ><img src="img/icon00.png" height="30" width="30" id="img"><label id="col">Home&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></a>
        <a href="index.jsp" ><label id="col">item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></a>
        <a href="index.jsp" ><label id="col">item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></a>
        <a href="index.jsp" ><label id="col">item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></a>
        <a href="index.jsp" ><label id="col">item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></a>
    </nav>
</div>

<div id="section">
    <iframe  src="productDetails.jsp" frameborder="0" scrolling="no" width="200" height="200"  ></iframe>
</div>
       
        

<div id="footer">

</div>

    </body>
</html>
