<%-- 
    Document   : updatemodepasse
    Created on : Nov 27, 2022, 11:55:23 AM
    Author     : MOHAMED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/mpob.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <legend>nouveau mot de passe</legend>
            <form action="updatemotdepasse" method="post">
                <table>
                    <tr>
                        <td>passworde:</td>
                        <td><input type="password" name="password"></td>
                        <td>confirmer password :</td>
                        <td><input type="password" name="passwordcnf"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Modifier"</td>
                    </tr>
                    <tr><td><h4></h4></td></tr>
                </table>
            </form>
        </fieldset>
    </body>
</html>
