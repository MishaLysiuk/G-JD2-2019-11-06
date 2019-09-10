<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>


<h4 class="header">Educations</h4>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>Job title</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th></th>
    </tr>
    <c:forEach var="experience" items="${workExperienceList}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${experience.jobTitle}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${experience.startDate}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${experience.endDate}"/></td>
            <td class="right"><a class="btn-floating" href="${workExperience}/${experience.id}"><i
                    class="material-icons">info</i></a> <a
                    class="btn-floating" href="${workExperience}/${experience.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red disabled" href="${workExperience}/${experience.id}/delete"><i class="material-icons">delete</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right" href="${workExperience}/add">Add new work</a>
