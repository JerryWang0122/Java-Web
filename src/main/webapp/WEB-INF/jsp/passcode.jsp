<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pass Code</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body style="padding: 15px">
        <!-- Pass Code -->
        <form method="get">
            <fieldset>
                <legend class="fs-3">Pass Code</legend>
                Code：<input class="form-control w-25" id="code" name="code" placeholder="請輸入passcode" required type="number">
                <img src="/JavaWeb_war_exploded/passcode" alt="" valign="middle"><br>
                <input class="btn btn-primary" type="submit" value="Verify">
            </fieldset>
        </form>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
