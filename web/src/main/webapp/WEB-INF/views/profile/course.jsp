<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Course</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <input id="name" type="text" class="autocomplete">
                <label for="name">Name</label>
            </div>
            <div class="input-field col s6">
                <input id="company" type="text" class="autocomplete">
                <label for="company">Company</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <input id="startDate" type="date" class="datepicker">
                <label for="startDate">Start date</label>
            </div>
            <div class="input-field col s4">
                <input id="endDate" type="date" class="datepicker">
                <label for="endDate">End date</label>
            </div>
            <div class="input-field col s4">
                <input id="finalResult" type="number" min="0" class="validate">
                <label for="finalResult">Final result</label>
            </div>
        </div>
        <div class="col s2 offset-s10">
            <a class="btn-floating btn-large blue darken-2"><i class="material-icons">add</i></a>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2 " type="submit" name="action">Save changes</button>
        </div>
    </form:form>
</div>