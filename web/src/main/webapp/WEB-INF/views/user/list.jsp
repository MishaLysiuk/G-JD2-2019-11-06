<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">Brands</h4>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th><mytaglib:sort-link pageUrl="${pagesUser}" column="id">id</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesUser}" column="first_name">First Name</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesUser}" column="created">created</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${pagesUser}" column="updated">updated</mytaglib:sort-link></th>
        <th></th>
    </tr>
    <c:forEach var="user" items="${gridItems}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.created}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.updated}"/></td>
            <td class="right"><a class="btn-floating" href="${pagesUser}/${user.id}"><i class="material-icons">info</i></a>
                <a
                        class="btn-floating" href="${pagesUser}/${user.id}/edit"><i class="material-icons">edit</i></a>
                <a
                        class="btn-floating red" href="${pagesUser}/${user.id}/delete"><i
                        class="material-icons">delete</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right" href="${pagesUser}/add"><i class="material-icons">add</i></a>