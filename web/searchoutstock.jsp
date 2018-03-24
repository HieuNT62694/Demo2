<%-- 
    Document   : searchoutstock
    Created on : Mar 7, 2018, 6:14:27 PM
    Author     : HieuNTSE
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <font color="blue">Welcome,${sessionScope.USER}</font><br>
        <h1>Some Products are out stock</h1>
        <br>
        <c:set var="result" value="${requestScope.SEARCHOUTSTOCK}"/>
        <c:set var="errors" value="${requestScope.IMPORTERR}"/>
         <c:if test="${not empty errors.quantitybigthan0}">
            <font color="red">
            ${errors.quantitybigthan0}
            </font><br>
        </c:if>
            <c:if test="${not empty errors.quantityint}">
            <font color="red">
            ${errors.quantityint}
            </font><br>
        </c:if>
        <c:if test="${not empty errors.pricebigthan0}">
            <font color="red">
            ${errors.pricebigthan0}
            </font><br>
        </c:if>
        <c:if test="${not empty errors.pricefloat}">
            <font color="red">
            ${errors.pricefloat}
            </font><br><br><br>
        </c:if>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Manufactore Date</th>
                        <th>Expried Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="import">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.productName}
                            </td>
                            <td>
                                <input type="text" name="txtQuantity" value="${dto.quantity}" />
                            </td>
                            <td>
                                <input type="text" name="txtPrice" value="<f:formatNumber type="number" pattern="###,###,###,###" value="${dto.price}"/>"/>

                            </td>
                            <td>

                                <f:formatDate pattern="dd-MM-yyyy" value="${dto.manufactureDate}" />
                                <input type="hidden" name="txtmanufactureDate" value="${dto.manufactureDate}" />
                            </td>
                            <td>

                                <f:formatDate pattern="dd-MM-yyyy" value="${dto.expiredDate}" />
                                <input type="hidden" name="txtexpiredDate" value="${dto.expiredDate}" />

                            </td>
                            <td>
                                <input type="submit" value="Import" name="btAction" />
                                <input type="hidden" name="txtProductid" value="${dto.productID}" />
                                <input type="hidden" name="txtId" value="${dto.id}" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
       


    </c:if>
    <c:if test="${empty result}">
        <h2>No Record is match !!</h2>
    </c:if>
</body>
</html>
