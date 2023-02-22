import * as captcha from "./captcha.js";
let password = "password";
let emailField = document.getElementById("emailContainer");
let passwordField = document.getElementById("passwordContainer");
let submitButton = document.getElementById("submitButton");

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
    if (passwordField.value === password) {
        location.replace("homepage.html");
      //window.location.href = "https://www.google.com/";
      //window.location.replace("http://www.w3schools.com");
      // myFunc();
    } else {
     // alert("Your e-mail Id or password is incorrect. try again!!");
      emailField.innerHTML = "";
      passwordField.innerHTML = "";
      document.getElementById("refreshCaptcha").click();
      document.getElementById("popupMessagePassword").style.display="block";
      document.getElementById("popupMessageEmail").style.display="none";
      document.getElementById("popupMessageCaptcha").style.display="none";
      return;
    }
  } else {
    document.getElementById("popupMessageCaptcha").style.display="block";
    document.getElementById("popupMessagePassword").style.display="none";
    document.getElementById("popupMessageEmail").style.display="none";
    emailField.innerHTML = "";
    passwordField.innerHTML = "";
    document.getElementById("refreshCaptcha").click();
  }
});
