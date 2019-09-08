<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Main information</h1>
</div>

<div class="row">
    <form:form class="col s12" method="POST" action="${profile}" modelAttribute="userAccountDTO">
        <div class="row">
            <form:input path="id" type="hidden" />
            <form:input path="password" type="hidden" />
            <form:input path="role" type="hidden" />
            <div class="input-field col s6">
                <form:input path="firstName" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="firstName" cssClass="red-text" />
                <label for="firstName">First Name</label>
            </div>
            <div class="input-field col s6">
                <form:input path="lastName" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="lastName" cssClass="red-text" />
                <label for="lastName">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="email" type="email" class="validate" disabled="${readonly}"/>
                <form:errors path="email" cssClass="red-text" />
                <label for="email">Email</label>
            </div>
            <div class="col s6">
                <a class="btn blue darken-2">Change password</a>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="birthday" type="date" cssClass="date-picker" disabled="${readonly}"/>
                <form:errors path="birthday" cssClass="red-text" />
                <label for="birthday">Birthday</label>
            </div>
            <div class="input-field col s6">
                <form:select path="motherTongueId" disabled="${readonly}">
                    <form:options items="${languagesChoices}"/>
                </form:select>
                <form:errors path="motherTongueId" cssClass="red-text" />
                <label for="motherTongueId">Mother tongue</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="jobTitle" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="jobTitle" cssClass="red-text" />
                <label for="jobTitle">Job title</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="contactInfo" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="contactInfo" cssClass="red-text" />
                <label for="contactInfo">Contact info</label>
            </div>
        </div>

        <c:if test="${!readonly}">
            <div class="col s2 offset-s5">
                <button class="btn blue darken-2 " type="submit" name="action">Save changes</button>
            </div>
        </c:if>

        <c:if test="${readonly}">
            <div class="col s2 offset-s5">
                <a href="${profile}/edit"><i class="small material-icons">edit</i>Edit profile</a>
            </div>
        </c:if>
    </form:form>
</div>