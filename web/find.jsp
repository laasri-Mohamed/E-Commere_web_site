<%-- 
    Document   : find
    Created on : 6 déc. 2022, 01:59:21
    Author     : Mohamed Nabil
--%>

<%@page import="entities.Categorie"%>
<%@page import="service.CategorieService"%>
<%@page import="entities.Marque"%>
<%@page import="service.MarqueService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
        <title>Gallery</title>
    </head>
    <body>
        <div>
            <h3> Add product here: </h3>
            <form action="ImageUpload" method="post" name="uploadForm" enctype="multipart/form-data">
                <input type="text" name="nom" placeholder="Nom " value="" /><br/>
                <input type="text" name="designation" placeholder="Design" value="" /><br/>
                <input type="text" name="prix" placeholder="Prix " value="" /><br/>
                <input type="text" name="unite" placeholder="Unites " value="" /><br/>
                <input type="text" name="description" placeholder="Desc " value="" /><br/>
                <select name="marque" id="marque">
                    <%
                        MarqueService ms = new MarqueService();
                        for (Marque m : ms.findAll()) {
                    %>
                    <option><%= m.getNom()%></option>
                    <%}%>
                </select>
                <select name="categorie" id="categorie">
                    <%
                        CategorieService cs = new CategorieService();
                        for (Categorie m : cs.findAll()) {
                    %>
                    <option><%= m.getNom()%> </option>
                    <%}%>
                </select>
                <input type="file" name="file" />
                <input type="submit" value="upload" />
            </form>         
        </div>
    </body>
</html>
