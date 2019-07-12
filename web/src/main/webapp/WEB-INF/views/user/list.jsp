<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h4 class="header">Brands</h4>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>id</th>
        <th>First Name</th>
        <th>created</th>
        <th>updated</th>
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
<a class="waves-effect waves-light btn right" href="${pagesUser}/add"><i class="material-icons">add</i></a>