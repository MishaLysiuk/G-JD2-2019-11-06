<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Work Experience</h1>
</div>
<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose your industry</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Industry</label>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose your position</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Position</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s5">
                <input id="start_working" type="date" class="validate">
                <label for="start_working">Start date</label>
            </div>
            <div class="input-field col s5">
                <input id="end_working" type="date" class="validate">
                <label for="end_working">End date</label>
            </div>
            <label>
                <input type="checkbox" class="filled-in s2"/>
                <span>Ongoing works</span>
            </label>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="company_experience" type="text" class="validate">
                <label for="company_experience">Company</label>
            </div>
            <div class="input-field col s6">
                <input id="address_experience" type="text" class="validate">
                <label for="address_experience">Address</label>
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

<script>
    $(document).ready(function () {
        var input = $('#company_experience');
        input.autocomplete({
            data: {
                "Apple": null,
                "Microsoft": null,
                "Google": 'https://placehold.it/250x250'
            },
        });


        input.on("input change", function () {
            var autocompleteField = this;
            var currentValue = autocompleteField.value;


            $.ajax({
                url: '${contextPath}/autocomplete/company?name=' + currentValue,
                type: 'get',

                success: function (data) {
                    /*alert('ajax response received')*/
                    data = JSON.parse(data);
                    autocompleteField.autocomplete("updateData", data);
                },
                error: function (err) {

                    console.log(err);
                }
            });
        });
    });
</script>