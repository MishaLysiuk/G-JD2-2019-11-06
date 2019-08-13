<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">Vacancies</h4>
<table class="stripped highlight ">
    <tbody>
    <tr>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="first_name">First Name</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="last_name">Last Name</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="password">Password</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="role_id">RoleId</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="updated">Updated</mytaglib:sort-link></th>
        <th></th>
    </tr>
    <c:forEach var="vacancy" items="${gridItems}" varStatus="loopCounter ">
        <tr>
            <td><c:out value="${vacancy.firstName}"/></td>
            <td><c:out value="${vacancy.lastName}"/></td>
            <td><c:out value="${vacancy.password}"/></td>
            <td><c:out value="${vacancy.roleId}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vacancy.updated}"/></td>
            <td class="right"><a class="btn-floating purple lighten-3" href="${listVacancy}/${vacancy.id}"><i
                    class="material-icons">info</i></a>
                <a
                        class="btn-floating purple lighten-3" href="${listVacancy}/${vacancy.id}/edit"><i
                        class="material-icons">edit</i></a>
                <a
                        class="btn-floating red" href="${listVacancy}/${vacancy.id}/delete"><i
                        class="material-icons">delete</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="purple lighten-3 btn right " href="${listVacancy}/add"><i class="material-icons">add</i></a>