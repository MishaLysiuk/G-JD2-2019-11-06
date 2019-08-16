<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Your account</h1>
    <hr color="C433FF"/>

</div>

<div class="row">
    <form:form class="col s12" method="post">
        <h4>Education</h4>
        <hr color="C433FF"/>
        <div class="row">
            <div class="input-field col s6">
                <input id="university" type="text" class="validate">
                <label for="university">University</label>
            </div>
            <div class="input-field col s6">
                <input id="address" type="text" class="validate">
                <label for="address">Address</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s5">
                <input id="start_education" type="date" class="validate">
                <label for="start_education">Start date</label>
            </div>
            <div class="input-field col s5">
                <input id="end_education" type="date" class="validate">
                <label for="end_education">End date</label>
            </div>
            <label>
                <input type="checkbox" class="filled-in s2"/>
                <span>Ongoing studies</span>
            </label>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose your speciality</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Speciality</label>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose your degree</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Degree</label>
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