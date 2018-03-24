<%-- 
    Document   : searchproduct
    Created on : Mar 7, 2018, 9:00:39 AM
    Author     : HieuNTSE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Search</title>
    </head>
    <body>
        <c:set var="searchValue1" value="${param.txtFromdate}"/>
        <c:set var="searchValue2" value="${param.txtTodate}"/>
        <font color="blue">Welcome,${sessionScope.USER}</font>
        <h1>Search result</h1>
        <br>
        From:<font color="red">${searchValue1}</font>
        To:<font color="red">${searchValue2}</font>
        <c:if test="${not empty searchValue1}">
            <c:if test="${not empty searchValue2}">
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
                                        </td>
                                        <td>
                                            <f:formatDate pattern="dd-MM-yyyy" value="${dto.expiredDate}" />
                                        </td>
                                        <td>
                                            <input type="checkbox" name="chkItem" value="${dto.productID}" />
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
    </body>
</html>
