<%-- 
    Document   : catalog
    Created on : 4 déc. 2022, 18:38:41
    Author     : Mohamed Nabil
--%>

<%@page import="entities.Panier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entities.Produit"%>
<%@page import="service.ProduitService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@include file="/includes/head.jsp"%>
        <link href="style/css.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/libs/css/style.css">
        <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
        <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
        <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
        <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
        <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
        <title>Panier Simple</title>
    </head>
    <body>
        <a class="navbar-brand" href="index1.jsp">E-Commerce <i class="fa fa-fw fa-shopping-cart"></i></a>

        <div class="container">

            <fieldset>
                <div class="card-header my-3">Liste des produits</div>
                <form action="AjouterPanier" method="GET">
                    <%!int i = 0;%>
                    <%
                        HttpSession sessio = request.getSession();
                        List<Panier> paniers = (List<Panier>) sessio.getAttribute("listpr");
                        if (paniers != null) {
                            i = paniers.size();
                        }
                    %>
                    <div style="text-align: right;">
                        <span><i class="fa fa-fw fa-shopping-cart"></i><a href="panier.jsp"> <%= i%></a></span>
                    </div>
                    <div>
                        <%
                            ProduitService p = new ProduitService();
                            for (Produit pp : p.findAll()) {
                        %>
                        <div class="card text-white bg-info mb-3" style="max-width: 18rem;">
                            <div class="card-body">
                                <img src="<%="ressource\\images\\" + pp.getImage()%>" width="130"><br/>
                                <h5 class="card-text"></h5>
                                <h5 class="card-text">Désignation: <%= pp.getDesignation()%></h5>
                                <h5 class="card-text">Prix : <%= pp.getPrix()%>&nbspDH</h5>   

                                <a class="mx-3 btn btn-primary" name="id" href="./cart?id=<%= pp.getId()%>" >Ajouter</a>
                            </div>
                        </div>
                        <%}%>
                    </div>
                </form>
            </fieldset>
        </div>
        <%@include file="/includes/footer.jsp"%>

    </body>
</html>
