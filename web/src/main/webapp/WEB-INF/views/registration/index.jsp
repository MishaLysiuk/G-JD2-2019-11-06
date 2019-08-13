<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main id="main">
    <div id="loginUiContainer">
        <div id="login-tab" class="active">Login</div>
        <div id="register-tab">Register</div>
        <div id="loginContainer">
            <div class="form-group">
                <input type="email" class="form-control inputBox" id="login-email" placeholder="Email">
            </div>
            <div class="form-group">
                <input type="password" class="form-control inputBox" id="login-password" placeholder="Password">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Login">
            </div>
            <div class="textcenter signUpTxt ">Don't have an account? <a href="#" class="link registerLink">Sign up</a>
            </div>
        </div>
        <div id="registerContainer" hidden>
            <div class="form-group">
                <input type="text" class="form-control inputBox" id="register-fname" placeholder="First Name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control inputBox" id="register-lname" placeholder="Last Name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control inputBox" id="register-email" placeholder="Email">
            </div>
            <div class="form-group">
                <input type="password" class="form-control inputBox" id="register-password" placeholder="Password">
            </div>
            <div class="form-group">
                <input type="password" class="form-control inputBox" id="register-cnfrmpassword"
                       placeholder="Confirm Password">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Register">
            </div>
            <div class="textcenter signUpTxt ">Already have an account? <a href="#" class="link loginLink">Login</a>
            </div>
        </div>
    </div>
</main>
<script src="js/main.js"></script>