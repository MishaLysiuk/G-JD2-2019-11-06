<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Course</h1>
    <hr color="C433FF"/>
</div>

<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <input id="course_name" type="text" class="validate">
                <label for="course_name">Name</label>
            </div>
            <div class="input-field col s6">
                <input id="company_course" type="text" class="validate">
                <label for="company_course">Company</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <input id="start_course" type="date" class="validate">
                <label for="start_course">Start date</label>
            </div>
            <div class="input-field col s4">
                <input id="end_course" type="date" class="validate">
                <label for="end_course">End date</label>
            </div>
            <div class="input-field col s4">
                <input id="final_result" type="number" min="0" class="validate">
                <label for="final_result">Final result</label>
            </div>
        </div>
        <div class="col s2 offset-s10">
            <a class="btn-floating btn-large purple lighten-3"><i class="material-icons">add</i></a>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn purple lighten-3 " type="submit" name="action">Save changes</button>
        </div>
    </form:form>
</div>