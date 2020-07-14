<%--
  Created by IntelliJ IDEA.
  User: Згидиш
  Date: 11.05.2020
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Увійти</title>
    <link rel="stylesheet" href="css/Style.css">




    <style>
a{
background-color: lavender;
    font-size:18px;

}
a:focus{
text-underline: #3742fa;
    background-color: #9b59b6;



}

    </style>
</head>
<body >


    <form action="${pageContext.request.contextPath}/Log_in" class="box" method="get">
        <h3>  LOGIN</h3>
        <input type="text" name="Username" placeholder="Введіть своє ім'я">

        <input type="password" name="Password" placeholder=" Введіть свій пароль">

        <input type="submit" name="enter" value="Увійти">

        <a href="Registration.jsp">зареєструватися</a>
    </form>

</body>
</html>