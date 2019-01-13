<%-- 
    Document   : shops
    Created on : Dec 28, 2018, 11:31:09 PM
    Author     : medEl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/snackbar.min.css" rel="stylesheet"/>
        <link href="css/shops.css" rel="stylesheet"/>


        <title>Shops</title>
    </head>
    <body class="bg">

        <div id ="menu-container" class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <a href="logout.do" class="naved">Sign Out</a>
                </div>
                <div class="col-md-4">
                    <a href="#" class="naved current">All Shops</a>
                    <a href="preferred.do" class="naved">My Preferred Shops</a>
                </div>
            </div>
            <div class="row" id="container1">
                <s:iterator value="shops" var="shop">

                    <div class="col-md-2 col-margin">
                        <div class="card card-style">
                            <img class="card-img-top" src="<s:property value="picUrl"/>" alt="Card image" style="height: 300px;">
                            <div class="card-body bg-dark">
                                <h4 class="card-title" style="color: wheat;">&nbsp;<s:property value="name"/></h4>
                                <button id="like" class="btn bg-success btn-size" i="<s:property value="shopId"/>">Like</button>


                            </div>        


                        </div>
                    </div>
                </s:iterator>
            </div>

        </div>

    </body>


    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/snackbar.min.js"></script>
    <script src="js/shops.js"></script>


</html>
