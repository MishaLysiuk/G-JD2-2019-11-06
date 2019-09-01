<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Main information</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <input id="firstName" type="text" class="validate">
                <label for="firstName">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="lastName" type="text" class="validate">
                <label for="lastName">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="email" type="email" class="validate">
                <label for="email">Email</label>
            </div>
            <div class="col s6">
                <a class="btn blue darken-2">Change password</a>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="birthday" type="date" class="datepicker">
                <label for="birthday">Birthday</label>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose your mother tongue</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Mother tongue</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="jobTitle" type="text" class="autocomplete">
                <label for="jobTitle">Job title</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="contactInfo" type="text" class="validate">
                <label for="contactInfo">Contact info</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2 " type="submit" name="action">Save changes</button>
        </div>
    </form:form>
</div>