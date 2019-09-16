<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row ">
    <div class="col s6 offset-s3">
        <h1>Worker</h1>
    </div>
</div>

<div class="row">

    <form:form class="col s12" method="POST" modelAttribute="item">
        <div class="row">
            <form:input path="id" type="hidden"/>
            <div class="input-field col s6">
                <form:input path="firstName" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="firstName" cssClass="red-text"/>
                <label for="firstName">First Name</label>
            </div>
            <div class="input-field col s6">
                <form:input path="lastName" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="lastName" cssClass="red-text"/>
                <label for="lastName">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="email" type="email" class="validate" disabled="${readonly}"/>
                <form:errors path="email" cssClass="red-text"/>
                <label for="email">Email</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="birthday" type="date" cssClass="date-picker" disabled="${readonly}"/>
                <form:errors path="birthday" cssClass="red-text"/>
                <label for="birthday">Birthday</label>
            </div>
            <div class="input-field col s6">
                <form:select path="motherTongueId" disabled="${readonly}">
                    <form:options items="${languagesChoices}"/>
                </form:select>
                <form:errors path="motherTongueId" cssClass="red-text"/>
                <label for="motherTongueId">Mother tongue</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="jobTitle" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="jobTitle" cssClass="red-text"/>
                <label for="jobTitle">Job title</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="contactInfo" type="text" class="validate" disabled="${readonly}"/>
                <form:errors path="contactInfo" cssClass="red-text"/>
                <label for="contactInfo">Contact info</label>
            </div>
        </div>
    </form:form>
</div>