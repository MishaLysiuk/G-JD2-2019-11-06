<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:set var="currentLocale"
       value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}"/>

<style>
    .highlighted-menu-${currentLocale!=null?currentLocale:'ru'} {
        text-decoration: underline;
    }
</style>

<header>
    <nav>
        <div class="nav-wrapper blue darken-2">
            <a href="#" class="brand-logo">FindDreamJob</a>
            <ul class="right hide-on-med-and-down">
                <sec:authorize access="hasRole('USER')">
                    <li><a href="${profile}/"><spring:message code="header.myAccount"></spring:message></a></li>
                    <li><a href="${education}/"><spring:message code="header.education"></spring:message></a></li>
                    <li><a href="${language}/"><spring:message code="header.language"></spring:message></a></li>
                    <li><a href="${workExperience}/"><spring:message code="header.workExperience"></spring:message></a></li>
                    <li><a href="${course}/"><spring:message code="header.course"></spring:message></a></li>
                    <li><a href="${skill}/"><spring:message code="header.skill"></spring:message></a></li>
                    <li><a href="${listWorker}"><spring:message code="header.workers"></spring:message></a></li>
                    <li><a href="${findVacancy}"><spring:message code="header.findVacancy"></spring:message></a></li>
                    <li><a href="${myVacancy}"><spring:message code="header.myVacancy"></spring:message></a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="${home}/"><spring:message code="header.myAccount"></spring:message></a></li>
                    <li><a href="${listWorker}"><spring:message code="header.workers"></spring:message></a></li>
                </sec:authorize>


                <%--<sec:authorize access="!isAnonymous()">
                    Id: <sec:authentication property="id"/>
                    Name: <sec:authentication property="principal"/>
                    RoleID:<sec:authentication property="authorities"/>
                </sec:authorize>--%>
                <sec:authorize access="!isAnonymous()">
                    <a class="right" href="${contextPath}/execute_logout" title="Log out"><i
                            class="material-icons">arrow_forward</i></a>
                </sec:authorize>
                <li><a class="highlighted-menu-ru" href="?lang=ru">RU</a></li>
                <li><a class="highlighted-menu-en" href="?lang=en">EN</a></li>
            </ul>
        </div>

        <div><spring:message code="page.home.title"/></div>
    </nav>
</header>