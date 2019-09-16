<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row ">
    <div class="col s8 offset-s2">
        <h1>Search vacancy by Company</h1>
    </div>
</div>

<div class="row">
    <form:form class="col s12" method="POST" modelAttribute="company" action="${findVacancy}/byCompany">

        <div class="row">
            <div class="input-field col s6 offset-s3">
                <form:input path="name" type="text"/>
                <form:errors path="name" cssClass="red-text"/>
                <label for="name">Input company name</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn blue darken-2" type="submit">Search</button>
        </div>
    </form:form>
</div>
<script>
    $(document).ready(function () {
        var input = $('#name');
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
