<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit account</h4>
<div class="row">

    <form:form class="col s12" method="POST" action="${pagesAccount}"
               modelAttribute="formAccount">
        <form:input path="id" type="hidden" />
        <div class="row">
            <div class="input-field col s12">
                <form:input path="email" type="text" disabled="${readonly}" />
                <form:errors path="email" cssClass="red-text" />
                <label for="email">Email</label>
            </div>

            <div class="input-field col s12">
                <form:input path="password" type="text" disabled="${readonly}" />
                <form:errors path="password" cssClass="red-text" />
                <label for="password">Password</label>
            </div>

            <div class="input-field col s12">
                <form:input path="roleId" type="number" disabled="${readonly}" />
                <form:errors path="roleId" cssClass="red-text" />
                <label for="roleId">roleId</label>
            </div>
        </div>
        <div class="row">
            <div class="col s6"></div>
            <div class="col s3">
                <c:if test="${!readonly}">
                    <button class="btn waves-effect waves-light right" type="submit">submit</button>
                </c:if>
            </div>
            <div class="col s3">
                <a class="btn waves-effect waves-light right" href="${pagesAccount}">to list<i
                        class="material-icons right"></i>
                </a>
            </div>
        </div>
    </form:form>
</div>


<c:if test='${param["showAlerts"]}'>
    <!-- checks the URL parameter -->


    <script src="${contextPath}/resources/js/sample-alert-with-params.js"></script>
    <script>
        showMessage('${contextPath}'); // execute function defined somewhere above
    </script>

</c:if>