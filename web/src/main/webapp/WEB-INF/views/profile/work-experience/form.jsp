<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Work Experience</h1>
</div>
<div class="row">
    <form:form class="col s12" method="post" action="${workExperience}/add" modelAttribute="workExperience">
        <div class="row">
            <form:input path="id" type="hidden" />
            <div class="input-field col s12">
                <form:input path="jobTitle" type="text" class="validate" required="required" disabled="${readonly}"/>
                <form:errors path="jobTitle" cssClass="red-text" />
                <label for="jobTitle">Job title</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <form:select path="regionId" cssClass="browser-default" required="required" disabled="${readonly}"/>
            </div>
            <div class="input-field col s4">
                <form:select path="countryId" cssClass="browser-default" required="required" disabled="${readonly}"/>
            </div>
            <div class="input-field col s4">
                <form:select path="cityId" cssClass="browser-default" required="required" disabled="${readonly}"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="startDate" type="date" cssClass="date-picker" required="required" disabled="${readonly}"/>
                <form:errors path="startDate" cssClass="red-text" />
                <label for="startDate">Start date</label>
            </div>
            <div class="input-field col s6">
                <form:input path="endDate" type="date" cssClass="date-picker" required="required" disabled="${readonly}"/>
                <form:errors path="endDate" cssClass="red-text" />
                <label for="endDate">End date</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="companyName" type="text" class="validate" required="required" disabled="${readonly}"/>
                <form:errors path="companyName" cssClass="red-text" />
                <label for="companyName">Company</label>
            </div>
            <div class="input-field col s6">
                <form:input path="address" type="text" class="validate" required="required" disabled="${readonly}"/>
                <form:errors path="address" cssClass="red-text" />
                <label for="address">Address</label>
            </div>
        </div>
        <div class="row">
            <div class="col s6"></div>
            <div class="col s3">
                <c:if test="${!readonly}">
                    <button class="btn waves-effect waves-light right" type="submit">Save</button>
                </c:if>
            </div>
            <div class="col s3">
                <a class="btn waves-effect waves-light right" href="${workExperience}">Back<i class="material-icons right"></i>
                </a>
            </div>
        </div>
    </form:form>
</div>

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