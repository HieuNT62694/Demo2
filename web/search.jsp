<%-- 
    Document   : search
    Created on : Mar 6, 2018, 6:56:33 PM
    Author     : HieuNTSE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Search Expried Products</h1>

        <br>
        <font color="blue">Welcome,${sessionScope.USER}</font>

        <form method="POST" action="searchexpired">

            From Date : <input type="text" name="txtFromdate" placeholder="dd-mm-yyyy" value="${param.txtFromdate}" /><br>
            <c:set var="errors" value="${requestScope.SEARCHDAYERR}"/>
            <c:if test="${not empty errors.fromdateInvalid}">
                <font color="red">
                ${errors.fromdateInvalid}
                </font><br>
            </c:if>
            <c:if test="${not empty errors.wrongformfromdate}">
                <font color="red">
                ${errors.wrongformfromdate}
                </font><br>
            </c:if>
            To Date : <input type="text" name="txtTodate" placeholder="dd-mm-yyyy" value="${param.txtTodate}" /><br>
            <c:set var="errors" value="${requestScope.SEARCHDAYERR}"/>
            <c:if test="${not empty errors.todateInvalid}">
                <font color="red">
                ${errors.todateInvalid}
                </font><br>
            </c:if>
            <c:if test="${not empty errors.wrongformtodate}">
                <font color="red">
                ${errors.wrongformtodate}
                </font><br>
            </c:if>
            <input type="submit" value="Search" name="btAction"/>
            <input type="reset" value="Reset" /><br>
            <c:set var="errors" value="${requestScope.SEARCHDAYERR}"/>
            <c:if test="${not empty errors.todatefromdate}">
                <font color="red">
                ${errors.todatefromdate}
                </font><br>
            </c:if>
        </form>
        <br>
        <a href="logout">Logout</a>

        <br>
        <a href="Searchoutstock">Searching Product is out of stock</a>
        <br>
        <c:if test="${empty errors}">
            <c:set var="searchValue1" value="${param.txtFromdate}"/>
            <c:set var="searchValue2" value="${param.txtTodate}"/>
            <c:if test="${not empty searchValue1}">
                <c:if test="${not empty searchValue2}">

                    <h1>Search result</h1>
                    <br>
                    From:<font color="red">${searchValue1}</font>
                    To:<font color="red">${searchValue2}</font>
                    <c:set var="result" value="${requestScope.SEARCHPRODUCT}"/>
                    <c:if test="${not empty result}">
                        <form action="delete" method="POST">
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                        <th>Expried Date</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>



                                <tbody>
                                    <c:forEach var="dto" items="${result}" varStatus="counter">
                                        <tr>
                                            <td>
                                                ${counter.count}
                                            </td>
                                            <td>
                                                ${dto.productName}
                                            </td>
                                            <td>
                                                ${dto.quantity}
                                                <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                            </td>
                                            <td>
                                                <f:formatDate pattern="dd-MM-yyyy" value="${dto.expiredDate}" />
                                            </td>
                                            <td>
                                                <input type="checkbox" name="chkItem" value="${dto.id}" />
                                                <input type="hidden" name="txtProductid" value="${dto.productID}" />
                                                <input type="hidden" name="lastSearchValue1" value="${searchValue1}" />
                                                <input type="hidden" name="lastSearchValue2" value="${searchValue2}" />
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <input type="submit" value="Delete" name="btAction" />
                        </form>
                    </c:if>
                    <c:if test="${empty result}">
                        <h2>No Record is match !!</h2>
                    </c:if>
                </c:if>
            </c:if>


        </c:if>
    </body>
</html>
