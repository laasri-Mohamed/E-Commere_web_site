<%-- 
    Document   : index1
    Created on : 20 nov. 2022, 11:44:42
    Author     : LAASRI MOHAMED
--%>




<%@page import="entities.Panier"%>
<%@page import="entities.Produit"%>
<%@page import="java.util.List"%>
<%@page import="service.ProduitService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ProduitService pd = new ProduitService();
    List<Produit> products = pd.findAll();

%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <style>
            .table tbody td{
                vartical-align: middle;           
            }
            .btn-incre, .btn-decre{
                
                box-shadow: none;
                font-size: 25px;
            }
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <div class="container">
            <div class="d-flex py-3"><h3></h3><a class="mx-3 btn btn-primary" href="#">Check Out</a></div>

            
            <div class="d-flex py-3"><h3>Total Price: $452</h3><a class="mx-3 btn btn-primary" href="#">Check Out</a></div>
            <table class="table table-loght">
                
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Brand</th>
                        <th scope="col">Price</th>
                        <th scope="col">Buy Now</th>
                        <th scope="col">Cancel</th>
                    </tr>
                </thead>
                <tbody>
                <%                    if (!products.isEmpty()) {
                        for (Produit p : products) {%>
                   
                    <tr>
                        <td><%=p.getNom()%></td>
                        <td><%=p.getCategorie()%></td>
                        <td><%=p.getMarque()%></td>
                        <td><%=p.getPrix()%></td>
                        <td>
                    
                            <form action="AddCart" method="post" class="form-inline">
                                <input type="hidden" name="id" value="1" class="form-inpute">
                                <div class="form-group d-flex justify-content-between">
                                    <a class="btn btn-sm btn-decre" href=""><i class="fas fa-minus-square"></i></a>
                                    <input type="text" name="quantity" class="form-control" value="" readonly>
                                    <a class="btn btn-sm btn-incre" href=""><i class="fas fa-plus-square"></i></a>

                                </div>
                            </form>
                        </td>
                        <td><a class="btn btn-sm btn-danger" href="">Remove</a></td>
                    </tr>
                   <%}%>          
                </tbody>
                
            </table>
        <%}%>
        
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
</html>
