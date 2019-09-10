<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>


<h4 class="header">Educations</h4>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>Speciality</th>
        <th>University</th>
        <th>Start date</th>
        <th></th>
    </tr>
    <c:forEach var="education" items="${educations}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${education.specialityName}"/></td>
            <td><c:out value="${education.university}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${education.startDate}"/></td>
            <td class="right"><a class="btn-floating" href="${education}/${education.id}"><i
                    class="material-icons">info</i></a> <a
                    class="btn-floating" href="${education}/${education.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red disabled" href="${education}/${education.id}/delete"><i class="material-icons">delete</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right" href="${education}/add">Add new education</a>
