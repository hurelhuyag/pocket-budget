<%--
  User: hurelhuyag
  Email: hurle0409@gmail.com
  Date: 12/8/12
  Time: 7:30 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${finances}" var="item" varStatus="stat">
    <div>
        ${item.id} - ${item.amount} - ${item.type}
    </div>
</c:forEach>