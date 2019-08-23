<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">Vacancies</h4>
<table class="stripped highlight ">
    <tbody>
    <tr>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="job_title">Job title</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="contact_info">Contact info</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="company">Company</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${listVacancy}" column="address">Location</mytaglib:sort-link></th>
        <th></th>
    </tr>
    <c:forEach var="vacancy" items="${gridItems}" varStatus="loopCounter ">
        <tr>
            <td><c:out value="${vacancy.jobTitle}"/></td>
            <td><c:out value="${vacancy.contactInfo}"/></td>
            <td><c:out value="${vacancy.companyName}"/></td>
            <td><c:out value="${vacancy.address}"/></td>
            <td class="right"><a class="btn-floating purple lighten-3" href="${listVacancy}/${vacancy.id}"><i
                    class="material-icons">info</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>