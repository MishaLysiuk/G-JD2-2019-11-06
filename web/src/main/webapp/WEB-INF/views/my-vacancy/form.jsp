<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>New vacancy</h1>
</div>

<div class="row">
    <form:form class="col s12" method="POST" modelAttribute="formVacancy" action="${myVacancy}/add">
        <form:input path="id" type="hidden" />

        <div class="input-field col s12">
            <form:input path="jobTitle" type="text" required="required" disabled="${readonly}" />
            <form:errors path="jobTitle" cssClass="red-text"/>
            <label for="jobTitle">Job title</label>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:select path="regionId" cssClass="browser-default" required="required" disabled="${readonly}"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:select path="countryId" cssClass="browser-default" required="required" disabled="${readonly}"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:select path="cityId" cssClass="browser-default" required="required" disabled="${readonly}"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="address" type="text" required="required" disabled="${readonly}"/>
                <form:errors path="address" cssClass="red-text"/>
                <label for="address">Address</label>
            </div>
            <div class="input-field col s6">
                <form:input path="companyName" type="text" required="required" disabled="${readonly}"/>
                <form:errors path="companyName" cssClass="red-text"/>
                <label for="companyName">Company</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:input path="contactInfo" type="text" required="required" disabled="${readonly}"/>
                <form:errors path="contactInfo" cssClass="red-text"/>
                <label for="contactInfo">Contact info</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:textarea path="description" type="textarea" required="required" disabled="${readonly}"/>
                <form:errors path="description" cssClass="red-text"/>
                <label for="description">Description</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <c:if test="${!readonly}">
                <button class="btn blue darken-2" type="submit">submit</button>
            </c:if>
        </div>
    </form:form>
</div>

<script src="${pageContext.request.contextPath}/resources/js/init-combos.js"></script>
<script>
    initComboboxes('${pageContext.request.contextPath}');
</script>

<script>
    $(document).ready(function () {
        var input = $('#companyName');
        input.autocomplete({
            minLength: 3,
            limit: 10,
        });
        input.on("input change", function () {
            var currentValue = this.value;
            $.ajax({
                url: '${contextPath}/autocomplete/company?name=' + currentValue,
                type: 'get',
                success: function (data) {
                    var instance = M.Autocomplete.getInstance(input);
                    instance.updateData(data)
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
    });
</script>
<script src="${pageContext.request.contextPath}/resources/js/init-combos.js"></script>
<script>
    initComboboxes('${pageContext.request.contextPath}');
</script>
