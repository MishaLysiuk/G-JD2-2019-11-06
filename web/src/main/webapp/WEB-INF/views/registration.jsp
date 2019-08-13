<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Login with Email and Password</h2>
<div class="row">
    <div class="col s3"></div>
    <div class="col s6">
        <form name='loginForm' action="<c:url value='login' />" method='POST'>
            <div class="row">
                <div class="input-field col s12 center">
                    <input id="first_name" type='text' required> <label for="first_name">First name:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12 center">
                    <input id="last_name" type='text' required/><label for="last_name">Last Name:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12 center">
                    <input id="email" type='text'> <label for="email">Email:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12 center">
                    <input id="password" type='password' required/><label for="password">Password:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12 center">
                    <input id="confirm_password" type='password' required/><label for="confirm_password">Confirm
                    password:</label>
                </div>
            </div>
            <div class="row">
                <div class="col s12 center">
                    <button class="btn purple lighten-3 " type="submit">Sign up</button>
                </div>
            </div>
        </form>
    </div>
</div>