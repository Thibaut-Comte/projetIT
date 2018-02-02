<!DOCTYPE html>

<html lang="fr,en">
<head>
    <?php require 'includes/head.html'; ?>
    <link rel="stylesheet" href="./style/border.css" media="screen,projection" type="text/css">
    <!-- All the files that are required -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/style/login.css">
<!--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <title>SCPI : Bourse d'échange</title>
</head>
<body class="container-fluid">
<header>
    <?php require 'includes/header.html'; ?>
</header>
<main>
    <!-- Where all the magic happens -->
    <!-- LOGIN FORM -->
    <div class="text-center" style="padding:50px 0">
        <div class="logo">Login</div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form id="login-form" class="text-left">
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
                        <div class="form-group login-group-checkbox">
                            <input type="checkbox" id="lg_remember" name="lg_remember">
                            <label for="lg_remember">remember</label>
                        </div>
                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p>forgot your password? <a href="forgot.html">click here</a></p>
                    <p>new user? <a href="register.html">create new account</a></p>
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



