<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<h4 class="header">My vacancies</h4>
<table class="stripped highlight ">
    <tbody>
    <tr>
        <th><mytaglib:sort-link pageUrl="${myVacancy}" column="job_title">Job title</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${myVacancy}" column="contact_info">Contact info</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${myVacancy}" column="company">Company</mytaglib:sort-link></th>
        <th><mytaglib:sort-link pageUrl="${myVacancy}" column="address">Location</mytaglib:sort-link></th>
        <th></th>
    </tr>
    <c:forEach var="vacancy" items="${gridItems}" varStatus="loopCounter ">
        <tr>
            <td><c:out value="${vacancy.jobTitle}"/></td>
            <td><c:out value="${vacancy.contactInfo}"/></td>
            <td><c:out value="${vacancy.companyName}"/></td>
            <td><c:out value="${vacancy.address}"/></td>
            <td class="right"><a class="btn-floating purple lighten-3" href="${myVacancy}/${vacancy.id}"><i
                    class="material-icons">info</i></a>
                <a
                        class="btn-floating purple lighten-3" href="${myVacancy}/${vacancy.id}/edit"><i
                        class="material-icons">edit</i></a>
                <a
                        class="btn-floating red" href="${myVacancy}/${vacancy.id}/delete"><i
                        class="material-icons">delete</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="purple lighten-3 btn right " href="${myVacancy}/add">Post new vacancy</a>