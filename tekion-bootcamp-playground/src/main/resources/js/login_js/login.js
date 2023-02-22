import * as captcha from "./captcha.js";
const emailField = document.getElementById("emailContainer");
const passwordField = document.getElementById("passwordContainer");
const submitButton = document.getElementById("submitButton");


document
    .getElementById("showPassword")
    .addEventListener("change", function (e) {
        e.preventDefault();
        if (this.checked) {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    });



submitButton.addEventListener("click", function (e) {
    // alert("hello");
    e.preventDefault();
    if(!emailField.value)
    {
        document.getElementById("popupMessageEmail").style.display="block";
        return;
    }
    if (captcha.captchaField.value === captcha.captchaString) {

        const email = emailField.value;
        const password = passwordField.value;
        axios.post('http://localhost:8080/login', {
                email: email,
                password: password
            })
            .then(function (response) {
                console.log(JSON.stringify(response));
            })
            .catch(function (error) {
                emailField.innerHTML = "";
                passwordField.innerHTML = "";
                document.getElementById("refreshCaptcha").click();
                document.getElementById("popupMessagePassword").style.display="block";
                document.getElementById("popupMessageEmail").style.display="none";
                document.getElementById("popupMessageCaptcha").style.display="none";
                return;
            });


    } else {
        document.getElementById("popupMessageCaptcha").style.display="block";
        document.getElementById("popupMessagePassword").style.display="none";
        document.getElementById("popupMessageEmail").style.display="none";
        emailField.innerHTML = "";
        passwordField.innerHTML = "";
        document.getElementById("refreshCaptcha").click();
    }
});
