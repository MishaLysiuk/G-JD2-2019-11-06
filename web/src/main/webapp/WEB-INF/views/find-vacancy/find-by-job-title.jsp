<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row ">
    <div class="col s8 offset-s2">
        <h1>Search vacancy by Job Title</h1>
    </div>
</div>

<div class="row">
    <form:form class="col s12" method="POST" modelAttribute="jobTitle" action="${findVacancy}/byJobTitle">

        <div class="row">
            <div class="input-field col s6 offset-s3">
                <form:input path="jobTitle" type="text"/>
                <form:errors path="jobTitle" cssClass="red-text"/>
                <label for="jobTitle">Input job title</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2" type="submit">Search</button>
        </div>
    </form:form>
</div>
