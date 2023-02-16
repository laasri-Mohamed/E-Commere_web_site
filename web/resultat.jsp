<%-- 
    Document   : resultat
    Created on : 5 déc. 2022, 17:00:38
    Author     : Mohamed Nabil
--%>

<%@page import="entities.Produit"%>
<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page import="service.ProduitService"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galerie en JSP Servlet - Java web application</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="result">
            <h3>${requestScope["message"]}</h3>
            <%
                ProduitService ps = new ProduitService();
                List<Produit> produits = ps.findAll();
                for (int i = 0; i < produits.size(); i++) {
            %>
            <div>
                <figure>
                    <img src="<%="ressource\\images\\" + produits.get(i).getImage()%>" alt="<%= produits.get(i).getNom()%>" />
                    <figcaption><h3><%= produits.get(i).getNom() + " " + produits.get(i).getPrix()%> </h3></figcaption>
                </figure>
                <%}%>
            </div>
        </div>
    </body>
</html>
//Source : www.exelib.net
