<%-- 
    Document   : index2
    Created on : Dec 28, 2018, 4:24:26 PM
    Author     : medEl
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SignIn/SignUp</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
    </head>

    <body class="text-center bg" >
        <div class="container-fluid">
            <div class="row" >
                <div class="col-md-6">
                    <s:form class="form-sign" action="signin">
                        <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>
                        <s:textfield type="email" name="email" class="form-control" placeholder="Email address" required="true"/>
                        <s:password type="password" name="pass" class="form-control" placeholder="Password" required="true"/>
                        <s:label></s:label>
                        <s:submit class="btn btn-lg btn-primary btn-block" type="submit" value="Sign In"></s:submit>

                    </s:form>
                </div>
                <div class="col-md-6">
                    <s:form class="form-sign" action="signup">
                        <h1 class="h3 mb-3 font-weight-normal">New To Our Website?</h1>
                        <h1 class="h3 mb-3 font-weight-normal">Please Sign Up</h1>
                        <s:textfield type="text" name="fullName" class="form-control" placeholder="Full Name" required="true"/>
                        <s:textfield type="email" name="email" class="form-control" placeholder="Email Address" required="true"/>
                        <s:password type="password" name="pass" class="form-control" placeholder="Password" required="true"/>
                        <s:password type="password" name="repeatPass" class="form-control" placeholder="Repeat Password" required="true"/>
                        <s:label></s:label>
                        <s:submit class="btn btn-lg btn-primary btn-block" type="submit" value="Sign Up"></s:submit>
                    </s:form>
                </div>
            </div>
        </div>
    </body>
</html>

