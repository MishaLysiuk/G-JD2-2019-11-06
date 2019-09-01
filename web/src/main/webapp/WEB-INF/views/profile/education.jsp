<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Education</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post">

        <div class="row">
            <div class="input-field col s4">
                <select>
                    <option value="" disabled selected>Region</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Region</label>
            </div>
            <div class="input-field col s4">
                <select>
                    <option value="" disabled selected>Country</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Country</label>
            </div>
            <div class="input-field col s4">
                <select>
                    <option value="" disabled selected>City</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>City</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="university" type="text" class="autocomplete">
                <label for="university">University</label>
            </div>
            <div class="input-field col s6">
                <input id="address" type="text" class="validate">
                <label for="address">Address</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s5">
                <input id="startDate" type="date" class="datepicker">
                <label for="startDate">Start date</label>
            </div>
            <div class="input-field col s5">
                <input id="endDate" type="date" class="datepicker">
                <label for="endDate">End date</label>
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
            <a class="btn-floating btn-large blue darken-2"><i class="material-icons">add</i></a>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2 " type="submit" name="action">Save changes</button>
        </div>
    </form:form>
</div>