<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">Accounts</h4>
<table class="stripped highlight ">
    <tbody>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Job title</th>
        <th>Contact info</th>
        <th>Birthday</th>
    </tr>
    <c:forEach var="item" items="${workers}" varStatus="loopCounter ">
        <tr>
            <td><c:out value="${item.firstName}"/></td>
            <td><c:out value="${item.lastName}"/></td>
            <td><c:out value="${item.jobTitle}"/></td>
            <td><c:out value="${item.contactInfo}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.birthday}"/></td>
            <td class="right"><a class="btn-floating blue darken-2" href="${worker}/${item.id}"><i class="material-icons">info</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>