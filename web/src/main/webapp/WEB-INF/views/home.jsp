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

        <h4>Work Experience</h4>
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

        <h4>Course</h4>
        <hr color="C433FF"/>
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

        <h4>Skill</h4>
        <hr color="C433FF"/>
        <div class="row">
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Group</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Group</label>
            </div>
            <div class="input-field col s6">
                <select>
                    <option value="" disabled selected>Skill</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Skill</label>
            </div>
        </div>

        <div class="col s2 offset-s10">
            <a class="btn-floating btn-large purple lighten-3"><i class="material-icons">add</i></a>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="contact_info" type="text" class="validate">
                <label for="contact_info">Contact info</label>
            </div>
        </div>

        <div class="col s2 offset-s5">
            <button class="btn purple lighten-3 " type="submit" name="action">Save changes</button>
        </div>
    </form:form>
</div>