<%@ page import="beans.StudentsBean" %><%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 24.09.2017
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>1 Laba</title>
    <link rel="stylesheet" href="styles2.css">
</head>
<header>
    <div id="logo" >
        <img src="images/image2.png">
    </div>
    <div id="about">
        WebSite developed by Promotorov Vlad from P3211,variant 356.
    </div>
</header>
<body>
<div id="content" >
    <div class=program>
        <div id="dataimage">
            <img src="images/image4.png">
        </div>
        <div id="result">
            <h1>Result of calculations:</h1>
            <table>
                <tr><th>R</th><th>X</th><th>Y</th><th>Result</th></tr>
                <tr>
                    <%
                        StudentsBean bean;
                        if(StudentsBean.sizeList()>0) bean=StudentsBean.getList().get(StudentsBean.getList().size()-1);
                        else{
                            bean=new StudentsBean();
                            bean.setEnterR("Nothing");
                            bean.setEnterY("Nothing");
                            bean.setEnterX("Nothing");
                            bean.setResult("Nothing");
                        }
                    %>
                    <td><% out.print(bean.getEnterR()); %></td>
                    <td><% out.print(bean.getEnterX()); %></td>
                    <td><% out.print(bean.getEnterY()); %></td>
                    <td><% out.print(bean.getResult()); %></td>
                </tr>
            </table>
            <a href="http://localhost:8080/2labaIAD_war_exploded/WelcomeApp"><input type="submit" value="Again" id="button"></a>
        </div>
    </div>
</div>
</body>
</html>

