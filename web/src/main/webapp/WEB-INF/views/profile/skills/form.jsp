<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Skills</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post" action="${skill}/add" modelAttribute="skill">
        <div class="row">
            <div class="input-field col s6">
                <form:select path="groupId" cssClass="browser-default" required="required"/>
            </div>
            <div class="input-field col s6">
                <form:select path="id" cssClass="browser-default" required="required"/>
            </div>
        </div>

        <div class="row">
            <div class="col s3">
                <c:if test="${!readonly}">
                    <button class="btn waves-effect waves-light right" type="submit">Save</button>
                </c:if>
            </div>
            <div class="col s3">
                <a class="btn waves-effect waves-light right" href="${skill}">Back<i
                        class="material-icons right"></i>
                </a>
            </div>
        </div>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/initSkills.js"></script>
<script>
    initComboboxes('${pageContext.request.contextPath}');
</script>