<%--
  Created by IntelliJ IDEA.
  User: jerrywang
  Date: 2024/5/4
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
    <head>
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0, user-scalable=yes, minimum-scale=1.0, maximum-scale=3.0">
        <meta charset="UTF-8">
        <title>User Info Update</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body style="padding: 15px">
        <%-- 更新user --%>
        <form action="/JavaWeb_war_exploded/myuser/update" method="post" class="mb-5">
            <fieldset>
                <legend class="fs-3">User Info Update</legend>
                員工編號：<input type="text" class="w-25 form-control" id="empId" name="empId" value="${updateUser.id}" readonly required><br>
                姓名：<input type="text" class="w-25 form-control" id="eName" name="eName" value="${updateUser.name}" placeholder="請輸入姓名" required><br>
                處室：<input type="text" class="w-25 form-control" id="eDept" name="eDept" value="${updateUser.dept}" placeholder="請輸入所屬單位" required><br>
                職稱：<input type="text" class="w-25 form-control" id="eTitle" name="eTitle" value="${updateUser.title}" placeholder="請輸入職稱" required><br>
                信箱：<input type="text" class="w-25 form-control" id="eEmail" name="eEmail" value="${updateUser.email}" placeholder="請輸入信箱" required><br>
                 <input type="submit" class="btn btn-primary" value="更新資料">
            </fieldset>
        </form>

    </body>
</html>
