<%--
  Created by IntelliJ IDEA.
  User: Згидиш
  Date: 12.05.2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
    <link rel="stylesheet" href="css/Cabinet.css">
</head>
<body>

<%= request.getParameter("Username") %>


<div>
    <form action="${pageContext.request.contextPath}/cabinet" method="post" name="container">

        <div>
            <input type="text" placeholder="Введіть поїздку до " name="City_to">
        </div>

        <div>
            <input type="date" placeholder="Оберіть дату прибуття " name="date_to">
        </div>

        <div>
            <input type="text" placeholder="Введіть поїздку з " name="From_city">
        </div>


        <div>
            <input type="date" placeholder="Оберіть дату від'їзду" name="date_from">
        </div>


        <input type="submit">
    </form>

</div>




</body>
</html>
