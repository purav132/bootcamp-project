"use strict";

const submitButton = document.querySelector("#submit-button");
const wrongPwdMessage = document.querySelector(".wrong-pwd-message");
const popupPwdMessage = document.querySelector(".popup-pwd-message");
const pwd = document.querySelector("#pwd");
const rePwd = document.querySelector("#re-pwd");

let passward;

submitButton.addEventListener("click", function (e) {
  e.preventDefault();
  if (pwd.value && rePwd.value) {
    if (pwd.value === rePwd.value) {
      passward = pwd.value;
      location.replace("index.html");
    } else {
      wrongPwdMessage.style.display = "block";
      popupPwdMessage.style.display = "none";
      rePwd.value = "";
    }
  } else {
    wrongPwdMessage.style.display = "none";
    popupPwdMessage.style.display = "block";
  }
  pwd.value = "";
  rePwd.value = "";
});

document
  .getElementById("showPassword")
  .addEventListener("change", function (e) {
    e.preventDefault();
    // console.log("show passward");
    if (pwd.type === "password") {
      pwd.type = "text";
    } else {
      pwd.type = "password";
    }
    if (rePwd.type === "password") {
      rePwd.type = "text";
    } else {
      rePwd.type = "password";
    }
  });
