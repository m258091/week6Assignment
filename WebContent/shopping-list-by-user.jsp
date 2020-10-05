<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping List</title>
</head>
<body>
<form method = "post" action = "listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
   <td><input type="radio" name="id" value="${currentlist.id}"></td>
   <td><h2>${currentlist.listName}</h2></td></tr>
   <tr><td>Shopper: ${currentlist.shopper.shopperName}</td></tr>
   <c:forEach var = "listVal" items = "${currentlist.listOfCars}">
            <tr><td colspan="3"> Car:
                ${listVal.make}, ${listVal.model}, ${listVal.year}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "delete" name="doThisToList">
</form>
<br />
<a href="addCarsForCarListServlet">Create a new List</a>

</body>
</html>