<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row ">
    <div class="col s6 offset-s4">
        <h1>Education</h1>
    </div>
</div>

<div class="row">
    <form:form class="col s12" method="POST" action="${education}/add" modelAttribute="education">

        <div class="row">
            <div class="input-field col s6">
                <form:select path="specialityId" required="required" disabled="${readonly}">
                    <form:options items="${specialities}"/>
                </form:select>
                <form:errors path="specialityId" cssClass="red-text" />
                <label for="specialityId">Speciality</label>
            </div>
            <div class="input-field col s6">
                <form:select path="degreeId" required="required" disabled="${readonly}">
                    <form:options items="${degrees}"/>
                </form:select>
                <form:errors path="degreeId" cssClass="red-text" />
                <label for="degreeId">Degree</label>
            </div>
        </div>

        <div class="row">
            <form:input path="id" type="hidden" />
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
                <form:input path="university" type="text" class="validate" required="required" disabled="${readonly}"/>
                <form:errors path="university" cssClass="red-text" />
                <label for="university">University</label>
            </div>
            <div class="input-field col s6">
                <form:input path="address" type="text" class="validate" required="required" disabled="${readonly}"/>
                <form:errors path="address" cssClass="red-text" />
                <label for="address">address</label>
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
            <div class="col s6"></div>
            <div class="col s3">
                <c:if test="${!readonly}">
                    <button class="btn waves-effect waves-light right blue darken-2" type="submit">Save</button>
                </c:if>
            </div>
            <div class="col s3">
                <a class="btn waves-effect waves-light right blue darken-2" href="${education}">Back<i class="material-icons right"></i>
                </a>
            </div>
        </div>
    </form:form>
</div>

<script src="${pageContext.request.contextPath}/resources/js/init-combos.js"></script>
<script>
    initComboboxes('${pageContext.request.contextPath}');
</script>