var loginContainer = document.querySelector('#loginContainer');
var registerContainer = document.querySelector('#registerContainer');
var registerTab = document.querySelector('#register-tab');
var loginTab = document.querySelector('#login-tab');
var loginLink = document.querySelector('.loginLink');
var registerLink = document.querySelector('.registerLink');

registerTab.addEventListener('click', function () {
    registerActive();
});

loginTab.addEventListener('click', function () {
    loginActive();
});

loginLink.addEventListener('click', function () {
    loginActive();
});

registerLink.addEventListener('click', function () {
    registerActive();
});

function loginActive() {
    loginContainer.style.display = "block";
    registerContainer.style.display = "none";
    loginTab.classList.add('active');
    registerTab.classList.remove('active');
}

function registerActive() {
    loginContainer.style.display = "none";
    registerContainer.style.display = "block";
    registerTab.classList.add('active');
    loginTab.classList.remove('active');
}