<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<c:set var="education" value="${contextPath}/education" scope="request"/>
<c:set var="workExperience" value="${contextPath}/work-experience" scope="request"/>
<c:set var="course" value="${contextPath}/course" scope="request"/>
<c:set var="skill" value="${contextPath}/skill" scope="request"/>
<c:set var="listWorker" value="${contextPath}/worker" scope="request"/>
<c:set var="findVacancy" value="${contextPath}/vacancy/find" scope="request"/>
<c:set var="myVacancy" value="${contextPath}/vacancy/my" scope="request"/>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><tiles:insertAttribute name="title"/></title>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

    <link rel="stylesheet" href="${contextPath}/resources/css/custom.css">
    <script src="${contextPath}/resources/js/init-materialize-forms.js"></script>
    <script src="${contextPath}/resources/js/init-menu.js"></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<main>
    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div>
</main>
<tiles:insertAttribute name="footer"/>
</body>
</html>