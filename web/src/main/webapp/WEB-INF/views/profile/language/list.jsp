<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri" %>


<h4 class="header">Languages</h4>
<table class="bordered highlight">
    <tbody>
    <tr>
        <th>Language</th>
        <th>Level</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${userLanguages}" varStatus="loopCounter">
        <tr>
            <td><c:out value="${item.languageName}"/></td>
            <td><c:out value="${item.levelName}"/></td>
            <td class="right"><a class="btn-floating" href="${language}/${item.id}"><i
                    class="material-icons">info</i></a> <a
                    class="btn-floating" href="${language}/${item.id}/edit"><i class="material-icons">edit</i></a> <a
                    class="btn-floating red disabled" href="${language}/${item.id}/delete"><i class="material-icons">delete</i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jspFragments:paging/>
<a class="waves-effect waves-light btn right" href="${language}/add">Add new language</a>