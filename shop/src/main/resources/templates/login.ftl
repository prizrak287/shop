<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Login!
    </div>
    <form method="post" action="/login">
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="hashPassword">
        </label>
        <br>
        <input type="submit" value="Log In" formmethod="post" formaction="/login">
    </form>
    <input type="button" value="Sign Up" onclick="document.location = '/signUp'">
</div>
</body>
</html>