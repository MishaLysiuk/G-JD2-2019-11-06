<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row ">
    <div class="col s8 offset-s2">
        <h1>Search vacancy by City</h1>
    </div>
</div>

<div class="row">
    <form:form class="col s12" method="POST" modelAttribute="location" action="${findVacancy}/byCity">

        <div class="row">
            <div class="input-field col s12">
                <form:select path="regionId" cssClass="browser-default" required="required"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:select path="countryId" cssClass="browser-default" required="required"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <form:select path="cityId" cssClass="browser-default" required="required"/>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2" type="submit">Search</button>
        </div>

    </form:form>


</div>
<script src="${pageContext.request.contextPath}/resources/js/init-combos.js"></script>
<script>
    initComboboxes('${pageContext.request.contextPath}');
</script>
