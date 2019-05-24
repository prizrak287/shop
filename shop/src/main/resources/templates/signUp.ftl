<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Login!
    </div>
    <form method="post" action="/signUp">
        <label for="firstName">Имя
            <input class="input-field" type="text" id="firstName" name="firstName">
        </label>
        <br>
        <label for="lastName">Фамилия
            <input class="input-field" type="text" id="lastName" name="lastName">
        </label>
        <br>
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="hashPassword">
        </label>
        <br>
        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>