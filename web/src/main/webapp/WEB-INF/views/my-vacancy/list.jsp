<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>

<div class="row ">
    <div class="col s6 offset-s3">
        <h1>My vacancies</h1>
    </div>
</div>

<table class="stripped highlight ">
    <tbody>
    <tr>
        <th>Job title</th>
        <th>Contact info</th>
        <th>Company</th>
        <th>Location</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${vacancies}" varStatus="loopCounter ">
        <tr>
            <td><c:out value="${item.jobTitle}"/></td>
            <td><c:out value="${item.contactInfo}"/></td>
            <td><c:out value="${item.companyName}"/></td>
            <td><c:out value="${item.address}"/></td>
            <td class="right"><a class="btn-floating blue darken-2" href="${myVacancy}/${item.id}"><i
                    class="material-icons">info</i></a>
                <a
                        class="btn-floating blue darken-2" href="${myVacancy}/${item.id}/edit"><i
                        class="material-icons">edit</i></a>
                <a
                        class="btn-floating red" href="${myVacancy}/${item.id}/delete"><i
                        class="material-icons">delete</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="blue darken-2 btn right " href="${myVacancy}/add">Post new vacancy</a>