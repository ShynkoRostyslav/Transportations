<%--
  Created by IntelliJ IDEA.
  User: Згидиш
  Date: 12.05.2020
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="css/Registration.css">


    <style>
li{
list-style-type:none;

}
ul{
padding-left: 0 ;


}

    </style>

</head>
<body>
<div class="container">

<form action="${pageContext.request.contextPath}/registration"
      class="container"
      method="post"
>


            <input type="text" name="username" placeholder="Вкажыть ім'я" required>
          <input type="text"  name="age"  placeholder="Вкажіть вік" >
           <input type="text" name ="surname" placeholder="Введіть прізвище ">
  <input type="password" name="password" placeholder="Введите пароль">
    <input  type="submit" name="submit" value="Зареєструватися">

    <br />

</form>

</div>




</body>
</html>--%>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="css/Registration.css">
    <link rel="stylesheet" href="fontawesome-free-5.13.1-web/css/font-awesome.min.css">

    <style>
        li{
            list-style-type:none;

        }
        ul{
            padding-left: 0 ;
        }

    </style>

    <link href="fontawesome-free-5.13.1-web/css/all.css" rel="stylesheet">
    <script defer src="script.js"></script>
</head>
<body>


<form action="${pageContext.request.contextPath}/registration"
      class="container"
      method="post"
      id="form">


    <input class="" type="text" name="username" placeholder="Вкажыть ім'я" id="username_1" >

    <i class="" id="u_1"></i>
    <i class="" id="u_2"></i>
    <small class="" id="userError_1">Error</small>

    <input class="" type="text"  name="age"  placeholder="Вкажіть вік" id ="age_1">

    <i class="" id="a_1"></i>
    <i class="" id="a_2" ></i>

    <small class ="" id ="ageError_1">Error</small>
    <input class="" type="text" name ="surname" placeholder="Введіть прізвище " id="surname_1">

    <i class="" id="s_1"></i>
    <i class="" id="s_2" ></i>

    <small class="" id="surnameError_1">Error</small>
    <input class="" type="password" name="password" placeholder="Введите пароль" id="password_1">


    <i class="" id="p_1"></i>
    <i class="" id="p_2"></i>

    <small class="" id="passwordError_1">Error</small>
    <input class="" type="submit" name="submit" value="Зареєструватися">
    <br />

</form>






</body>
</html>
