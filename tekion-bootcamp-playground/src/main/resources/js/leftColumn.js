"use strict";

//inputs
let fullName = { firstName: "Purav", lastName: "Kansara" };

const firstNameLabel = document.getElementsByClassName("first-name")[0];
const lastNameLabel = document.getElementsByClassName("last-name")[0];
const updateNameButton = document.getElementById("update-name-button");
const modal = document.querySelector(".modal");
const updateButton = document.querySelector(".update-button");
const userName = document.querySelector(".full-name");
const closeButton = document.querySelector(".close-button");
const popupMessage = document.querySelector(".popup-message");

const updatePwdButton = document.querySelector("#update-pwd-button");
const updatePwdButtonModal = document.querySelector(".update-pwd-button-modal");
const updatePwdModal = document.querySelector(".update-pwd-modal");
const pwdCloseButton = document.querySelector(".pwd-close-button");
const pwd = document.querySelector("#pwd");
const rePwd = document.querySelector("#re-pwd");
const wrongPwdMessage = document.querySelector(".wrong-pwd-message");
const popupPwdMessage = document.querySelector(".popup-pwd-message");
const checkBox = document.querySelector(".check-box");

updateNameButton.addEventListener("click", function (e) {
  e.preventDefault();
  popupMessage.style.display = "none";
  firstNameLabel.value = "";
  lastNameLabel.value = "";
  modal.showModal();
});

// const x = firstNameLabel.value;
// const y = lastNameLabel.value;
// console.log(x, y);
updateButton.addEventListener("click", function (e) {
  e.preventDefault();
  //   console.log(e);

  //   console.log(firstNameLabel.value, lastNameLabel.value);
  if (firstNameLabel.value && lastNameLabel.value) {
    // console.log(firstNameLabel.value, lastNameLabel.value);
    // console.log("hii");
    fullName.firstName = firstNameLabel.value;
    fullName.lastName = lastNameLabel.value;
    userName.textContent = `${fullName.firstName} ${fullName.lastName}`;
    modal.close();
  } else {
    popupMessage.style.display = "block";
  }
  firstNameLabel.value = "";
  lastNameLabel.value = "";
});

closeButton.addEventListener("click", function (e) {
  e.preventDefault();
  popupMessage.style.display = "none";
  firstNameLabel.value = "";
  lastNameLabel.value = "";
  modal.close();
});

updatePwdButton.addEventListener("click", function (e) {
  e.preventDefault();
  popupPwdMessage.style.display = "none";
  wrongPwdMessage.style.display = "none";
  checkBox.checked = false;
  pwd.value = "";
  rePwd.value = "";
  updatePwdModal.showModal();
});

pwdCloseButton.addEventListener("click", function (e) {
  e.preventDefault();
  popupPwdMessage.style.display = "none";
  wrongPwdMessage.style.display = "none";
  pwd.value = "";
  rePwd.value = "";
  checkBox.checked = false;
  updatePwdModal.close();
});

let passward;
updatePwdButtonModal.addEventListener("click", function (e) {
  e.preventDefault();
  if (pwd.value && rePwd.value) {
    if (pwd.value === rePwd.value) {
      passward = pwd.value;
      console.log(`your passward is ${passward}`);
      updatePwdModal.close();
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

function showPwd() {
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
}

const updatePicButton = document.querySelector("#update-pic-button");
const updatePicModal = document.querySelector(".update-pic-modal");
const picCloseButton = document.querySelector(".pic-close-button");
const popupPicMessage = document.querySelector(".popup-pic-message");
const updatePicButtonModal = document.querySelector(".update-pic-button-modal");
const chosenPic = document.querySelector("#files");
const logoutButton = document.querySelector("#logout-button");

updatePicButton.addEventListener("click", function (e) {
  e.preventDefault();
  popupPicMessage.style.display = "none";
  updatePicModal.showModal();
});

updatePicButtonModal.addEventListener("click", function (e) {
  e.preventDefault();
  // console.log(chosenPic.files);
  if (chosenPic.files[0]) {
    updatePicModal.close();
    console.log("your profile pic is updated.");
  } else {
    popupPicMessage.style.display = "block";
  }
  //   chosenPic.files.delete();
});
picCloseButton.addEventListener("click", function (e) {
  e.preventDefault();
  popupPicMessage.style.display = "none";
  //   chosenPic.files.delete();
  updatePicModal.close();
});

function previewFile() {
  console.log("profile pic is successfully uploaded.");
}

logoutButton.addEventListener("click", function (e) {
  e.preventDefault();
  location.replace("index.html");
});

// axios.get("https://api.github.com/users/mapbox").then((response) => {
//   console.log(response.data);
//   console.log(response.status);
//   console.log(response.statusText);
//   console.log(response.headers);
//   console.log(response.config);
// });
