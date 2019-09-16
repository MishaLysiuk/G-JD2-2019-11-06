<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row ">
    <div class="col s6 offset-s3">
        <h1>Course</h1>
    </div>
</div>

<div class="row">
    <form:form class="col s12" method="post" action="${course}/add" modelAttribute="course">
        <div class="row">
            <div class="input-field col s12">
                <form:input path="name" type="text" required="required" disabled="${readonly}"/>
                <form:errors path="name" cssClass="red-text"/>
                <label for="name">Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="companyName" type="text" required="required" class="validate" disabled="${readonly}"/>
                <form:errors path="companyName" cssClass="red-text"/>
                <label for="companyName">Company</label>
            </div>
            <div class="input-field col s4">
                <form:input path="finalResult" type="number" required="required" disabled="${readonly}"/>
                <form:errors path="finalResult" cssClass="red-text"/>
                <label for="finalResult">Final result</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <form:input path="startDate" type="date" cssClass="date-picker" required="required" disabled="${readonly}"/>
                <form:errors path="startDate" cssClass="red-text"/>
                <label for="startDate">Start date</label>
            </div>
            <div class="input-field col s6">
                <form:input path="endDate" type="date" cssClass="date-picker" required="required" disabled="${readonly}"/>
                <form:errors path="endDate" cssClass="red-text"/>
                <label for="endDate">End date</label>
            </div>
        </div>
        <div class="row">
            <div class="col s6"></div>
            <div class="col s3">
                <c:if test="${!readonly}">
                    <button class="btn waves-effect waves-light right blue darken-2" type="submit">Save</button>
                </c:if>
            </div>
            <div class="col s3">
                <a class="btn waves-effect waves-light right blue darken-2" href="${course}">Back<i class="material-icons right"></i>
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