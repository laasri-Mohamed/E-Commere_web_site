<%-- 
    Document   : verfier
    Created on : Nov 27, 2022, 12:52:11 PM
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
            <legend>Verification  </legend>
            <form action="Verfier">
                <table>
                    <tr>
                        <td><h3>saisie le code recuper depuis votre gmail:</h3></td>
                    </tr>
                    <tr>
                        <td>Code de validation:</td>
                        <td><input type="number" name="code"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="valider"></td>
                    </tr>
                    <tr><td><h4></h4></td></tr>
                </table>
            </form>
        </fieldset>
    </body>
</html>
