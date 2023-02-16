<%-- 
    Document   : registration
    Created on : 17 nov. 2022, 17:29:37
    Author     : LAASRI MOHAMED
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up Form by Colorlib</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Sign up</h2>

                            <form method="post" action="RegistServlet" class="register-form"
                                  id="register-form">
                                <div class="form-group">
                                    <label for="name"></label>
                                    <table border="0">
                                        <tr>
                                            <td>Type d'utilisateurs :</td>
                                            
                                            <td>Admin<input id="etd" type="radio" name="type" value="Admin" checked="checked" onclick="showAdmin();"/>
                                                Client <input id="prof" type="radio" name="type" value="Client" checked="checked" onclick="showClient();"/></td>
                                        </tr>
                                       
                                    </table>

                                </div>
                                <div class="form-group">
                                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label> <input type="text" name="fname" id="fname" placeholder="First Name" required=""/>
                                </div>
                                <div class="form-group">
                                    <label for="name">
                                        <i class="zmdi zmdi-account material-icons-name"></i></label> <input type="text" name="lname" id="lname" placeholder="Last Name" required=""/>
                                </div>
                                <div class="form-group">
                                    <label for="email"><i class="zmdi zmdi-email"></i></label> <input type="email" name="email" id="email" placeholder="Your Email" required=""/>
                                </div>
                                <div class="form-group">
                                    <label for="pass"><i class="zmdi zmdi-lock"></i></label> <input type="password" name="pass" id="pass" placeholder="Password" required=""/>
                                </div>
                                <div class="form-group">
                                    <label for="contact"><i class="zmdi zmdi-phone "></i></label><input type="text" name="tele" id="contact" placeholder="Telephone" />
                                </div>
                                <div class="form-group">
                                    <label for="adresse"><i class="zmdi zmdi-lock-outline"></i></label><input type="text" name="adresse" id="adresse" placeholder="Adresse" />
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" /> <label for="agree-term" class="label-agree-term"><span><span></span></span>I
                                        agree all statements in <a href="#" class="term-service">Terms of service</a></label>
                                </div>
                                <div class="form-group form-button"> <input type="submit" name="signup" id="signup"
                                           class="form-submit" value="Register" />
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure>
                                <img src="images/signup-image.jpg" alt="sing up image">
                            </figure>
                            <a href="login.jsp" class="signup-image-link">I am already member</a>
                        </div>
                    </div>
                </div>
            </section>


        </div>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/roleUser.js" type="text/javascript"></script>


    </body>
</html>
