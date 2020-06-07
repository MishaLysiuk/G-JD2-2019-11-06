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
            <a href="${profile}/" class="brand-logo left">World Around You<i
                    class="material-icons right">brightness_3</i></a>
            <ul class="right hide-on-med-and-down">
                <sec:authorize access="hasRole('USER')">
                    <li><a href="${profile}/"><spring:message code="header.myAccount"></spring:message><i
                            class="material-icons left">account_box</i></a></li>
                    <ul id="additional" class="dropdown-content">
                        <li><a href="${education}/"><spring:message code="header.education"></spring:message></a></li>
                        <li><a href="${language}/"><spring:message code="header.language"></spring:message></a></li>
                        <li><a href="${workExperience}/"><spring:message
                                code="header.workExperience"></spring:message></a></li>
                        <li><a href="${course}/"><spring:message code="header.course"></spring:message></a></li>
                        <li><a href="${skill}/"><spring:message code="header.skill"></spring:message></a></li>
                    </ul>
                    <li><a class="dropdown-trigger" href="#!" data-target="additional"><spring:message
                            code="header.moreInformation"></spring:message><i
                            class="material-icons left">apps</i></a></li>

                    <ul id="searchVacancy" class="dropdown-content">
                        <li><a href="${findVacancy}/byCompany"><spring:message
                                code="header.searchVacancy.byCompany"></spring:message></a></li>
                        <li><a href="${findVacancy}/byCity"><spring:message
                                code="header.searchVacancy.byCity"></spring:message></a>
                        <li><a href="${findVacancy}/byJobTitle"><spring:message
                                code="header.searchVacancy.byJobTitle"></spring:message></a>
                        </li>
                    </ul>
                    <li><a class="dropdown-trigger" href="#!" data-target="searchVacancy"><spring:message
                            code="header.searchVacancy"></spring:message><i
                            class="material-icons left">search</i></a></li>

                    <ul id="searchWorker" class="dropdown-content">
                        <li><a href="${worker}"><spring:message code="header.searchWorker.all"></spring:message></a>
                        <li><a href="${worker}/byJobTitle"><spring:message
                                code="header.searchWorker.byJobTitle"></spring:message></a>
                        </li>
                    </ul>
                    <li><a class="dropdown-trigger" href="#!" data-target="searchWorker"><spring:message
                            code="header.searchWorker"></spring:message><i
                            class="material-icons left">group</i></a></li>

                    <li><a href="${myVacancy}"><spring:message code="header.myVacancy"></spring:message><i
                            class="material-icons left">work</i></a></li>
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