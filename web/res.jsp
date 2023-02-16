<%-- 
    Document   : res
    Created on : 5 déc. 2022, 23:49:51
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
        <title>Gallery</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/libs/css/style.css">
        <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
        <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
        <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
        <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
        <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
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
                    <img src="<%="ressource\\images\\" + produits.get(i).getImage()%>" alt="<%= produits.get(i).getNom()%>" width="45" />
                    <figcaption><h4><%= produits.get(i).getNom() + " : " + produits.get(i).getPrix() + " DH"%> </h4></figcaption>
                </figure>
                <%}%>
            </div>
        </div>  
    </body>
</html>
