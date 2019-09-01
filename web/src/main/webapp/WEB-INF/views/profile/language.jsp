<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Foreign languages</h1>
</div>

<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Group</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Language</label>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Skill</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Level</label>
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