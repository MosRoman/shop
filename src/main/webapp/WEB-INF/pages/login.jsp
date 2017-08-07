<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF=8"/>
    <title>Shop</title>
    <link href="/static/css/style.css" rel="stylesheet"  type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div id="wrapper">

    <div id="header">

        <img src="/static/images/d4.png" width="150" height="150" id="rez" alt="clock">
        <p >Wheels and Discs</p>
    </div>
    <div id="content">
                    <div align="center">
                        <c:url value="/j_spring_security_check" var="loginUrl" />


                        <form action="${loginUrl}" method="POST">


                            <c:if test="${param.error ne null}">
                                <p>Wrong login or password!</p>
                            </c:if>

                            <c:if test="${param.logout ne null}">

                            </c:if>
                        </form>
                    </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <td></td>
                <td><b>Type</b></td>
                <td><b>Brand</b></td>
                <td><b>Diametr</b></td>
                <td><b>Price($ USA)</b></td>

            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${product.id}" id="checkbox_${product.id}"/></td>
                    <c:choose>
                        <c:when test="${product.type ne null}">
                            <td>${product.type.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${product.brand}</td>
                    <td>${product.diametr}</td>
                    <td>${product.price}</td>

                </tr>
            </c:forEach>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${allPages ne null}">
                    <c:forEach var="i" begin="1" end="${allPages}">
                        <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
                <c:if test="${byTypePages ne null}">
                    <c:forEach var="i" begin="1" end="${byTypePages}">
                        <li><a href="/type/${typeId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
            </ul>
        </nav>


    </div>
</div>

<div id="login">
    <div align="center">
        <c:url value="/j_spring_security_check" var="loginUrl" />



        <form action="${loginUrl}" method="POST">
            Login:<br/><input type="text" name="j_login"><br/>
            Password:<br/><input type="password" name="j_password"><br/>
            <input type="submit" value="Enter" />

            <p><a href="/register"><h3>Register new user</h3></a></p>



            <c:if test="${param.logout ne null}">

            </c:if>
        </form>
    </div>


</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_product').click(function(){
        window.location.href='/product_add_page';
    });
    $('#basket').click(function(){
        window.location.href='/basket_page';
    });
    $('#basket2').click(function(){
        window.location.href='/basket_page2';
    });
    $('#admin').click(function(){
        window.location.href='/admin';
    });


    $('#delete_product').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/product/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#order_product').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/product/order", data, function(data, status) {
            window.location.reload();
        });
    });

</script>
</body>
</html>
