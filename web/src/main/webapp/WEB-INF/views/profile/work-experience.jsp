<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Work Experience</h1>
</div>
<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s12">
                <input id="jobTitle" type="text" class="autocomplete">
                <label for="jobTitle">Job title</label>
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
                <span>Ongoing works</span>
            </label>
        </div>

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
                <input id="company" type="text" class="autocomplete">
                <label for="company">Company</label>
            </div>
            <div class="input-field col s6">
                <input id="address" type="text" class="validate">
                <label for="address">Address</label>
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

<script>
    $(document).ready(function () {
        var input = $('#company');
        input.autocomplete({
            minLength: 3,
            limit: 10,
        });
        input.on("input change", function () {
            var currentValue = this.value;
            $.ajax({
                url: '${contextPath}/autocomplete/company?name=' + currentValue,
                type: 'get',
                success: function (data) {
                    var instance = M.Autocomplete.getInstance(input);
                    instance.updateData(data)
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
    });
</script>