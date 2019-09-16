<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>


<div class="row ">
    <div class="col s6 offset-s4">
        <h1>Course</h1>
    </div>
</div>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>Course</th>
        <th>Company</th>
        <th>Final result</th>
        <th>End Date</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${courses}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.companyName}"/></td>
            <td><c:out value="${item.finalResult}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.endDate}"/></td>
            <td class="right"><a class="btn-floating blue darken-2" href="${course}/${item.id}"><i
                    class="material-icons">info</i></a> <a
                    class="btn-floating blue darken-2" href="${course}/${item.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${course}/${item.id}/delete"><i class="material-icons">delete</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right blue darken-2" href="${course}/add">Add new course</a>
