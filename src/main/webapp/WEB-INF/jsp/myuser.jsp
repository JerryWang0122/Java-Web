<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/5/4
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
    <head>
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0, user-scalable=yes, minimum-scale=1.0, maximum-scale=3.0">
        <meta charset="UTF-8">
        <title>My User</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
    </head>
    <body style="padding: 15px">
        <%-- 新增user --%>
        <form action="/JavaWeb_war_exploded/myuser" method="post" class="mb-5">
            <fieldset>
                <legend class="fs-3">User Register</legend>
                員工編號：<input type="text" class="w-25 form-control" id="empId" name="empId" placeholder="請輸入員工編號" required><br>
                姓名：<input type="text" class="w-25 form-control" id="eName" name="eName" placeholder="請輸入姓名" required><br>
                處室：<input type="text" class="w-25 form-control" id="eDept" name="eDept" placeholder="請輸入所屬單位" required><br>
                職稱：<input type="text" class="w-25 form-control" id="eTitle" name="eTitle" placeholder="請輸入職稱" required><br>
                信箱：<input type="text" class="w-25 form-control" id="eEmail" name="eEmail" placeholder="請輸入信箱" required><br>
                密碼：<input type="password" class="w-25 form-control" id="ePassword" name="ePassword" placeholder="請輸入密碼" required><br>
                <input type="submit" class="btn btn-primary" value="新增User">
            </fieldset>
        </form>

        <%-- Room 列表 --%>
        <div>
            <h3>員工列表</h3>
            <table class='table table-dark text-center table-striped table-bordered'>
                <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Name</th>
                    <th>Dept</th>
                    <th>Title</th>
                    <th>Email</th>
                    <th>使用權限</th>
                    <th>Create Date</th>
                    <th>Update Date</th>
                    <th>修改</th>
                    <th>刪除</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${myusers}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.dept}</td>
                        <td>${user.title}</td>
                        <td>${user.email}</td>
                        <td>
                            <%-- EL Language底層實現equals的方式跟Java不同，正規使用 eq 標籤  --%>
                            <c:choose>
                                <c:when test="${user.authLevel eq -1}">
                                    無效
                                </c:when>
                                <c:when test="${user.authLevel eq 0}">
                                    註冊
                                </c:when>
                                <c:when test="${user.authLevel eq 1}">
                                    一般員工
                                </c:when>
                                <c:when test="${user.authLevel eq 2}">
                                    庫房人員
                                </c:when>
                                <c:when test="${user.authLevel eq 3}">
                                    Root
                                </c:when>
                                <c:otherwise>
                                    ${user.authLevel}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${user.createDate}</td>
                        <td>${user.updateDate}</td>
                        <td><a href="/JavaWeb_war_exploded/myuser/update?updateId=${user.id}" class="btn btn-success">修改</a></td>
                        <td><a href="/JavaWeb_war_exploded/myuser?deleteId=${user.id}" class="btn btn-danger">刪除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
