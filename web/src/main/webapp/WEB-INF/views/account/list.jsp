<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">Accounts</h4>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th><mytaglib:sort-link pageUrl="${pagesAccount}" column="id">id</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesAccount}" column="email">Email</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesAccount}" column="password">Password</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesAccount}" column="role_id">RoleId</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesAccount}" column="updated">Updated</mytaglib:sort-link></th>
        <th></th>
    </tr>
    <c:forEach var="account" items="${gridItems}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${account.id}"/></td>
            <td><c:out value="${account.email}"/></td>
            <td><c:out value="${account.password}"/></td>
            <td><c:out value="${account.roleId}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${account.updated}"/></td>
            <td class="right"><a class="btn-floating" href="${pagesAccount}/${account.id}"><i class="material-icons">info</i></a>
                <a
                        class="btn-floating" href="${pagesAccount}/${account.id}/edit"><i class="material-icons">edit</i></a>
                <a
                        class="btn-floating red" href="${pagesAccount}/${account.id}/delete"><i
                        class="material-icons">delete</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right" href="${pagesAccount}/add"><i class="material-icons">add</i></a>