<%-- 
    Document   : Mpob
    Created on : Nov 27, 2022, 12:02:38 PM
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
            <legend>Mot de passe oublié!</legend>
            <form action="Mdob">
                <h3>Entrez votre E-mail pour envoyer un code sur votre e-mail</h3>
                <table>
                    <tr>
                        <td>E-mail</td>
                        <td><input type="email" name="email"></td>
                         <td><input type="submit" value="Envoyer"></td>
                    </tr>
                    <tr><td><h4></h4></td></tr>
                </table>
            </form>
        </fieldset>

    </body>
</html>
