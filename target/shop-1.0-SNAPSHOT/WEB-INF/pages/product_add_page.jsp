<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Product</title>
        <link href="/static/css/style.css" rel="stylesheet"  type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div id="wrapper">

        <div id="header">

            <img src="/static/images/d4.png" width="150" height="150" id="rez">
            <p >Wheels and Discs</p>
        </div>
        <div class="container">
            <input type="button"  class="btn btn-default navbar-btn" value="Go to Main Menu" onClick='location.href="/"'>
            <form role="form" class="form-horizontal" action="/product/add" method="post">
                        <h3>New product</h3>
                <select class="selectpicker form-control form-group" name="type">
                    <option value="-1">Default</option>
                    <c:forEach items="${types}" var="type">
                        <option value="${type.id}">${type.name}</option>
                    </c:forEach>
                </select>
                        <input class="form-control form-group" type="text" name="brand" placeholder="Brand">
                        <input class="form-control form-group" type="text" name="diametr" placeholder="Diametr">
                        <input class="form-control form-group" type="text" name="price" placeholder="Price">
                    <input type="submit" class="btn btn-primary" value="Add">
            </form>
        </div>

        <script>
            $('.selectpicker').selectpicker();
        </script>

    </div>
    </body>
</html>