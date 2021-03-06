<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>


<div class="row ">
    <div class="col s6 offset-s3">
        <h1>Work experience</h1>
    </div>
</div>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>Job title</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${workExperienceList}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${item.jobTitle}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.startDate}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.endDate}"/></td>
            <td class="right"><a class="btn-floating blue darken-2" href="${workExperience}/${item.id}"><i
                    class="material-icons">info</i></a> <a
                    class="btn-floating blue darken-2" href="${workExperience}/${item.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red" href="${workExperience}/${item.id}/delete"><i class="material-icons">delete</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right blue darken-2" href="${workExperience}/add">Add new work</a>
