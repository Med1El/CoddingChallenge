<%-- 
    Document   : preffered
    Created on : Jan 11, 2019, 9:38:24 PM
    Author     : SuperUser
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


        <title>Preferred Shops</title>
    </head>
    <body class="bg">

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <a href="logout.do" class="naved">Sign Out</a>
                </div>
                <div class="col-md-4">
                    <a href="redirect.do" class="naved ">All Shops</a>
                    <a href="#" class="naved current">My Preferred Shops</a></div>
            </div>
            <div class="row" id="container2">
                <s:iterator value="shops" var="shop">

                    <div class="col-md-2 col-margin">
                        <div class="card card-style">
                            <img class="card-img-top" src="<s:property value="picUrl"/>" alt="Card image" style="height: 300px;">
                            <div class="card-body bg-dark">
                                <h4 class="card-title" style="color: wheat;">&nbsp;<s:property value="name"/></h4>
                                <button id="remove" class="btn bg-warning btn-size" i="<s:property value="shopId"/>">Remove</button>


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
