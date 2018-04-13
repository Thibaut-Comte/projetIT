<!DOCTYPE html>

<html lang="fr,en">
<head>
	<%@include file="./includes/head.html" %>
	<script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js" integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./style/login.css">

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <title>SCPI : Bourse d'échange</title>
    
</head>
<body class="container-fluid">
<header>
    <%@include file="./includes/header.html" %>
</header>
<main>
    <!-- Where all the magic happens -->
    <!-- LOGIN FORM -->
    <div class="text-center" style="padding:50px 0">
        <div class="logo">Login</div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form id="login-form" class="text-left" action="controleur?action=auth" method="POST">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="lg_username" class="sr-only">Username</label>
                            <input type="text" class="form-control" id="lg_username" name="lg_username" placeholder="username">
                        </div>
                        <div class="form-group">
                            <label for="lg_password" class="sr-only">Password</label>
                            <input type="password" class="form-control" id="lg_password" name="lg_password" placeholder="password">
                        </div>
<!--                         <div class="form-group login-group-checkbox"> -->
<!--                             <input type="checkbox" id="lg_remember" name="lg_remember"> -->
<!--                             <label for="lg_remember">remember</label> -->
<!--                         </div> -->
                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p>forgot your password? <a href="forgot.jsp">click here</a></p>
                    <p>new user? <a href="register.jsp">create new account</a></p>
                </div>
            </form>
        </div>
        <!-- end:Main Form -->
    </div>
</main>
<aside>

</aside>
<footer>

</footer>
</body>
</html>



