<%@ page import="beans.StudentsBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 23.09.2017
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>1 laba</title>
  <link rel="stylesheet" href="styles.css">
    <%
        if(StudentsBean.sizeList()>0){
    %>
  <link rel="stylesheet" href="newstyles.css">
    <% } %>
  <script type="text/javascript" src="jquery.min.js"></script>
  <script type="text/javascript" src="jquery.validate.min.js"></script>
  <script type="text/javascript" src="validate.js"></script>
  <script type="text/javascript" src="interactiveImage.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

</head>
<header>
  <div id="logo" >
    <img src="images/image2.png">
  </div>
  <div id="about">
    WebSite developed by Promotorovv Vlad from P3211,variant 356.
  </div>
</header>
<body>
<div id="content" >
  <div id="description">
    <h1>What is helpSystems?</h1>
    HelpSystems is a free service developed by some student to help another students successfully do their homework.<br/>
    You only need to enter data and the program will do everything for you.
  </div>
  <div class="program">
    <div id="dataimage">
      <img id="graph" src="images/graph.jpg">
    </div>
    <div class="form">
      <form method="post" class="data-form" id="myForm">
        <input type="text" id="enterR" placeholder="enterR"  name="enterR"/>
        <br/>
        <input type="text" id="enterY" placeholder="enterY"  name="enterY"/>
        <div id="chooseX">
          <h1>Choose X:</h1>
          <input type="radio" id="enterX1" name="enterX" value="1">
          <label for="enterX1">1</label>
          <input type="radio" id="enterX2" name="enterX" value="2">
          <label for="enterX2">2</label>
          <input type="radio" id="enterX3" name="enterX" value="3">
          <label for="enterX3">3</label>
          <input type="radio" id="enterX4" name="enterX" value="4">
          <label for="enterX4">4</label>
          <input type="radio" id="enterX5" name="enterX" value="5">
          <label for="enterX5">5</label>
          <br/>
          <input type="radio" id="enterX6" name="enterX" value="0">
          <label for="enterX6">0</label>
          <input type="radio" id="enterX7" name="enterX" value="-1">
          <label for="enterX7">-1</label>
          <input type="radio" id="enterX8" name="enterX" value="-2">
          <label for="enterX8">-2</label>
          <input type="radio" id="enterX9" name="enterX" value="-3">
          <label for="enterX9">-3</label>
        </div>
        <input type="radio" id="code" name="code" value="1" checked="checked">
        <input type="submit" value="Calculate" id="button">
      </form>
    </div>
  </div>
  <div id="refresh">fsdfsf</div>
  <div class="result">
    <table id="results">
      <tr><th>R</th><th>X</th><th>Y</th><th><%out.print(StudentsBean.sizeList());%></th></tr>
      <%
        if(StudentsBean.sizeList()>0) {
          ArrayList<StudentsBean> list = StudentsBean.getList();
          for (StudentsBean bean:list) {
            %>
            <tr>
              <td><% out.print(bean.getEnterR()); %></td>
              <td><% out.print(bean.getEnterX()); %></td>
              <td><% out.print(bean.getEnterY()); %></td>
              <td><% out.print(bean.getResult()); %></td>
            </tr>
            <%
          }
        }
      %>
    </table>
    <div id="clear">
      Clear
    </div>
  </div>
</div>
</body>
</html>