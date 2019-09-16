<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row ">
    <div class="col s6 offset-s3">
        <h1>Change password</h1>
    </div>
</div>

<div class="row">
    <form:form class="col s12" method="POST" action="${profile}/password" modelAttribute="passwordDTO">
        <div class="row">

            <div class="input-field col s6 offset-s3">
                <form:input path="oldPassword" type="password" class="validate" required="required"/>
                <form:errors path="oldPassword" cssClass="red-text"/>
                <label for="oldPassword">Password</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6 offset-s3">
                <form:input path="newPassword" type="password" class="validate" required="required"/>
                <form:errors path="newPassword" cssClass="red-text"/>
                <label for="newPassword">New password</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6 offset-s3">
                <form:input path="confirmPassword" type="password" class="validate" required="required"/>
                <form:errors path="confirmPassword" cssClass="red-text"/>
                <label for="confirmPassword">Confirm password</label>
            </div>
        </div>

        <div class="row">
            <div class="col s12 center">
                <div>${error}</div>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2 " type="submit" name="action">Save changes</button>
        </div>

    </form:form>
</div>