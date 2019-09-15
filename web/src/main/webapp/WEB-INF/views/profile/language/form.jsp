<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Foreign languages</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post" modelAttribute="userLanguage">
        <div class="row">
            <form:input path="id" type="hidden" />
            <div class="input-field col s6">
                <form:select path="languageId" required="required" disabled="${readonly}">
                    <form:options items="${languagesChoices}"/>
                </form:select>
                <form:errors path="languageId" cssClass="red-text" />
                <label for="languageId">Language</label>
            </div>
            <div class="input-field col s6">
                <form:select path="levelId" required="required" disabled="${readonly}">
                    <form:options items="${levels}"/>
                </form:select>
                <form:errors path="levelId" cssClass="red-text" />
                <label for="levelId">Level</label>
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
                <a class="btn waves-effect waves-light right" href="${language}">Back<i class="material-icons right"></i>
                </a>
            </div>
        </div>
    </form:form>
</div>