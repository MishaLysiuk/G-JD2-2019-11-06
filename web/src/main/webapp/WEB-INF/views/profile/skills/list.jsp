<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>


<div class="row ">
    <div class="col s6 offset-s4">
        <h1>Skills</h1>
    </div>
</div>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>Language</th>
        <th>Level</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${skills}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${item.groupName}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td class="right"><a
                    class="btn-floating red" href="${skill}/${item.id}/delete"><i class="material-icons">delete</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right blue darken-2" href="${skill}/add">Add new skill</a>