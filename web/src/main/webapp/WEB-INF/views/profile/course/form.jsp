<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Course</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post" modelAttribute="course">
        <div class="row">
            <div class="input-field col s6">
                <form:input path="name" type="text" disabled="${readonly}"/>
                <label for="name">Name</label>
            </div>
            <div class="input-field col s6">
                <form:input path="companyName" type="text" disabled="${readonly}"/>
                <label for="companyName">Company</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <form:input path="startDate" type="text" cssClass="date-picker" disabled="${readonly}"/>
                <label for="startDate">Start date</label>
            </div>
            <div class="input-field col s4">
                <form:input path="endDate" type="text" cssClass="date-picker" disabled="${readonly}"/>
                <label for="endDate">End date</label>
            </div>
            <div class="input-field col s4">
                <form:input path="finalResult" type="text" disabled="${readonly}"/>
                <label for="finalResult">Final result</label>
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
                <a class="btn waves-effect waves-light right" href="${education}">Back<i class="material-icons right"></i>
                </a>
            </div>
        </div>
    </form:form>
</div>