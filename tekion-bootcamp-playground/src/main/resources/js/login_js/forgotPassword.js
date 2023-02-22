const openModalButton = document.querySelector(".ForgotPassword");
const emailModal = document.querySelector("#ForgotPasswordModal");
const closeButton = document.querySelector(".close");
const submitButton = document.querySelector("#submitButtonModal");

openModalButton.addEventListener("click", function(e) {
    e.preventDefault();
    emailModal.style.display = "block";
//  console.log('clicked');

});

closeButton.addEventListener("click", function(e) {
    e.preventDefault();
  emailModal.style.display = "none";
});

submitButton.addEventListener("click", function(e) {
    e.preventDefault();
  const emailInput = document.querySelector("#emailInput");
  console.log("Email address entered:", emailInput.value);
});

window.addEventListener("click", function(event) {
  if (event.target === emailModal) {
    emailModal.style.display = "none";
  }
});
