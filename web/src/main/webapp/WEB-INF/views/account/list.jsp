<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">Accounts</h4>
<table class="stripped highlight ">
    <tbody>
    <tr>
        <th><mytaglib:sort-link pageUrl="${listWorker}" column="first_name">First Name</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listWorker}" column="last_name">Last Name</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listWorker}" column="password">Password</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listWorker}" column="role_id">RoleId</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listWorker}" column="updated">Updated</mytaglib:sort-link></th>
        <th></th>
    </tr>
    <c:forEach var="account" items="${gridItems}" varStatus="loopCounter ">
        <tr>
            <td><c:out value="${account.firstName}"/></td>
            <td><c:out value="${account.lastName}"/></td>
            <td><c:out value="${account.password}"/></td>
            <td><c:out value="${account.role}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${account.updated}"/></td>
            <td class="right"><a class="btn-floating blue darken-2" href="${listWorker}/${account.id}"><i class="material-icons">info</i></a>
                <a
                        class="btn-floating blue darken-2" href="${listWorker}/${account.id}/edit"><i class="material-icons">edit</i></a>
                <a
                        class="btn-floating red" href="${listWorker}/${account.id}/delete"><i
                        class="material-icons">delete</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="blue darken-2 btn right " href="${listWorker}/add"><i class="material-icons">add</i></a>