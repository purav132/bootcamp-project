"use strict";

const rightmodal = document.querySelector(".rightmodal");
const overlay = document.querySelector(".overlay");
const btnCloseModal = document.querySelector(".close-modal");
const bntsOpenModal = document.querySelector(".show-modal");

console.log(bntsOpenModal);

const closemodal = function () {
  //console.log("Close button clicked");
  rightmodal.classList.add("hidden");
  overlay.classList.add("hidden");
};

bntsOpenModal.addEventListener("click", function () {
  //console.log(`Button "${bntsOpenModal.textContent}" Clicked`);
  rightmodal.classList.remove("hidden");
  overlay.classList.remove("hidden");
});

btnCloseModal.addEventListener("click", closemodal);
overlay.addEventListener("click", closemodal);

//Function that shall close the box when any keyboard key is pressed
document.addEventListener("keydown", function () {
  console.log("Keyboard Key pressed");
  rightmodal.classList.add("hidden");
  overlay.classList.add("hidden");
});

//Function that shall close the box when Esc key is pressed
document.addEventListener("keydown", function (e) {
  if (e.key == "Escape" && !modal.classList.contains("hidden")) {
    closemodal();
  }
});
