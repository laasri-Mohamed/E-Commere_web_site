<%-- 
    Document   : panier
    Created on : 4 déc. 2022, 18:53:06
    Author     : Mohamed Nabil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="service.ProduitService"%>
<%@page import="entities.Panier"%>
<%@page import="java.util.List"%>
<%@page import="entities.Produit"%>
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
            <div class="d-flex py-3"><h3></h3><a class="mx-3 btn btn-primary" href="catalog.jsp">Back to your catalog</a></div>
            <div style="text-align: center;">
                <h2 >Votre Panier</h2>
            </div>
            <table table class="table table-loght">
                <thead>
                    <tr>
                        <th scope="col">Quantité</th>
                        <th scope="col">Désignation</th>
                        <th scope="col">Prix</th>
                        <th scope="col">Image</th>
                    </tr>
                </thead>
                <tbody>
                    <% double total = 0, sm = 0;%>
                    <%
                        HttpSession sessio = request.getSession();
                        ProduitService ps = new ProduitService();
                        List<Panier> paniers = (List<Panier>) sessio.getAttribute("listpr");
                        List<Produit> produits = ps.findAll();
                        if (paniers != null) {
                            for (Panier p : paniers) {
                                total += p.getQte() * p.getProduit().getPrix();
                    %>
                    <tr>
                        <td><%= p.getQte()%></td>
                        <td><%= p.getProduit().getDesignation()%></td>
                        <td><%= p.getProduit().getPrix()%></td>
                        <td><img src="<%="ressource\\images\\" + p.getProduit().getImage()%>" alt="user" class="rounded" width="45"></td>
                    </tr>
                    <%}
                    }%>
                </tbody>
            </table>
            <h2 style="text-align: center;">Total: <%=total%></h2>
        </div>
        
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
