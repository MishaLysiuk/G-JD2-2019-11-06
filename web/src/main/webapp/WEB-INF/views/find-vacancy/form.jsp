<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>New vacancy</h1>
</div>

<div class="row">
    <form:form class="col s12" method="POST" modelAttribute="formVacancy">
        <form:input path="id" type="hidden" />

        <div class="input-field col s12">
            <form:input path="jobTitle" type="text" disabled="${readonly}"/>
            <form:errors path="jobTitle" cssClass="red-text"/>
            <label for="jobTitle">Job title</label>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="companyName" type="text" disabled="${readonly}"/>
                <form:errors path="companyName" cssClass="red-text"/>
                <label for="companyName">Company</label>
            </div>
            <div class="input-field col s6">
                <form:input path="address" type="text" disabled="${readonly}"/>
                <form:errors path="address" cssClass="red-text"/>
                <label for="address">Address</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="contactInfo" type="text" disabled="${readonly}"/>
                <form:errors path="jobTitle" cssClass="red-text"/>
                <label for="contactInfo">Contact info</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <c:if test="${!readonly}">
                <button class="btn blue darken-2 right" type="submit">submit</button>
            </c:if>
        </div>
    </form:form>
</div>

<script>
    $(document).ready(function(){
        $('input.autocomplete').autocomplete({
            data: {
                "Apple": null,
                "Microsoft": null,
                "Google": 'https://placehold.it/250x250'
            },
        });
    });
</script>