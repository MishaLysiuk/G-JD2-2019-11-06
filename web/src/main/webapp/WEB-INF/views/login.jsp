<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row s12">
    <h2>Login with Email and Password</h2>
</div>
<div class="row">
    <div class="col s3"></div>
    <div class="col s6">
        <form name='loginForm' action="<c:url value='login' />" method='POST'>
            <div class="row">
                <div class="input-field col s12 center">
                    <input name="username" type='email' required> <label for="username">Email:</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12 center">
                    <input name="password" type='password' required/><label for="password">Password:</label>
                </div>
            </div>
            <c:if test="${not empty error}">
            <div class="row">
                <div class="col s12 center">
                    <div class="error">${error}</div>
                </div>
            </div>
            </c:if>
            <c:if test="${not empty msg}">
            <div class="row">
                <div class="col s12 center">
                    <div class="msg">${msg}</div>
                </div>
            </div>
            </c:if>
            <div class="row">
                <div class="col s12 center">
                    <button class="btn blue darken-2 " type="submit">Sign in</button>
                </div>
            </div>
    </div>
    </form>
</div>
<div class="col s3"></div>
</div>