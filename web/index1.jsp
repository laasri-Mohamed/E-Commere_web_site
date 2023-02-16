<%-- 
    Document   : index1
    Created on : 20 nov. 2022, 11:44:42
    Author     : LAASRI MOHAMED
--%>

<%@page import="entities.Panier"%>
<%@page import="entities.Client"%>
<%@page import="entities.User"%>
<%@page import="entities.Produit"%>
<%@page import="java.util.List"%>
<%@page import="service.ProduitService"%>
<%
    ProduitService pd = new ProduitService();
    List<Produit> products = pd.findAll();
    int id = 0;

    try {
        id = Integer.parseInt(request.getParameter("id"));
    } catch (NumberFormatException e) {

    }
    String url = "./cart?id=" + id + "&quantite=1";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%!Client c;%>
        <%
            HttpSession sessio = request.getSession();
            if (sessio != null) {
                c = (Client) sessio.getAttribute("email");
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
        <title>Welcome Mr <%= c.getNom()%>!</title>
        <%@include file="/includes/head.jsp"%>

    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <%!int i = 0;%>
        <%
            HttpSession sessi = request.getSession();
            List<Panier> paniers = (List<Panier>) sessio.getAttribute("listpr");
            if (paniers != null) {
                i = paniers.size();
            }
        %>
        <div class="container">

            <div class="card-header my-3"></div>
            <div class="card-header my-3"></div>
            <div class="card"></div>
            <div class="card-header my-3">All Products</div>
                <div class="row">
                    <ul id="myUL">
                <center><input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for products.."></center>
                    <%  if (!products.isEmpty()) {
                        for (Produit p : products) {%>
                    <div class="col-md-3 my-3">
                        <div class="card w-100" style="width: 18rem;">
                            <img class="card-img-top" src="<%="ressource\\images\\" + p.getImage()%>" alt="Card image cap" width="130">
                            <div class="card-body">
                                <h5 class="card-title"><a><%= p.getNom()%></a></h5>
                                <h6 class="price"><%= p.getPrix()%></h6>
                                <h6 class="Category">Category= <%= p.getCategorie()%></h6>
                                <h6 class="Category">Brand= <%= p.getMarque()%></h6>
                                <h6 class="Category"><%= p.getDescription()%></h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a id="cart" name="id" href="./cart?id=<%= p.getId()%>" class="btn btn-dark">Add to Cart</a>
                                    <a href="#" class="btn btn-primary">Buy Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%  }
                        }
                    %>
            </ul>
        </div>
    </div>
    <%@include file="/includes/footer.jsp"%>
</body>
<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
<link rel="stylesheet" href="assets/libs/css/style.css">
<link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
<link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
<link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
<link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
<link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
<link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
<link href="css/filtre.css" rel="stylesheet" type="text/css"/>
<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<script src="assets/libs/js/main-js.js"></script>
<script src="assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
<script src="assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
<script src="assets/vendor/charts/morris-bundle/raphael.min.js"></script>
<script src="assets/vendor/charts/morris-bundle/morris.js"></script>
<script src="assets/vendor/charts/c3charts/c3.min.js"></script>
<script src="assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
<script src="assets/vendor/charts/c3charts/C3chartjs.js"></script>
<script src="assets/libs/js/dashboard-ecommerce.js"></script>
<script src="includes/filtre.js" type="text/javascript"></script>
</html>
