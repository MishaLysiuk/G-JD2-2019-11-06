<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>New vacancy</h1>
</div>

<div class="row">
    <form:form class="col s12" method="get">

        <div class="input-field col s12">
            <input id="jobTitle" type="text" class="validate" placeholder="Job title">
            <label for="jobTitle">Job title</label>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="company" type="text" class="validate">
                <label for="company">Company</label>
            </div>
            <div class="input-field col s6">
                <input id="address" type="text" class="validate">
                <label for="address">Address</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="contact_info" type="text" class="validate">
                <label for="contact_info">Contact info</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn purple lighten-3 " type="submit" name="action">Post vacancy</button>
        </div>
    </form:form>
</div>