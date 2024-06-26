<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/4/29
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    // 接收來自 BMRServlet 的資料
    List<Map<String, Object>> bmrList = (List)request.getAttribute("bmrList");
%>
<html>
    <head>
        <title>BMR List</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 15px;">
        <h2>BMR List:</h2>
        
        <table class='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Height</th>
                    <th>Weight</th>
                    <th>BMR</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                <% for (int i = 0; i < bmrList.size(); i++) { %>
                <tr>
                    <% Map<String, Object> map = bmrList.get(i);%>
                    <td><%=i  %></td>
                    <td><%=map.get("name") %></td>
                    <td><%=map.get("gender").equals("0") ? "女" : "男" %></td>
                    <td><%=map.get("age") %></td>
                    <td><%=map.get("height") %></td>
                    <td><%=map.get("weight") %></td>
                    <td><%=map.get("bmr") %></td>
                    <td><a href="/JavaWeb_war_exploded/servlet/bmr?deleteId=<%=i %>" class="btn btn-danger">Delete</a> </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <a class="btn btn-primary" href="/JavaWeb_war_exploded/bmr.html">回上一頁</a>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>