<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row s12">
    <h1>Your account</h1>
</div>

<h4>Main information</h4>
<hr color="C433FF"/>
<div class="row">
    <form:form class="col s12" method="post">
        <div class="row">
            <div class="input-field col s6">
                <input id="first_name" type="text" class="validate">
                <label for="first_name">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="last_name" type="text" class="validate">
                <label for="last_name">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="email" type="email" class="validate">
                <label for="email">Email</label>
            </div>
            <div class="input-field col s6">
                <input id="password" type="password" class="validate">
                <label for="password">Password</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input id="birthday" type="date" class="validate">
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

        <h4>Work information</h4>
        <hr color="C433FF"/>
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
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Choose language</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Industry</label>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Level of language</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Position</label>
            </div>
        </div>

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

        <div class="col s2 offset-s5">
            <button class="btn purple lighten-3 " type="submit" name="action">Save changes</button>
        </div>
    </form:form>
</div>