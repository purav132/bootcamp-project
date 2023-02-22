const togglePassword = document.querySelector("#togglePassword");
const toggleConfirmPassword = document.querySelector("#toggleConfirmPassword");
var password = document.querySelector("#password");
var confirmPassword= document.querySelector("#confirmPassword");


togglePassword.addEventListener("click", function (e) {
    e.preventDefault();
    // toggle the type attribute
    const type = password.getAttribute("type") === "password" ? "text" : "password";
    password.setAttribute("type", type);
    
    // toggle the icon
    this.classList.toggle("bi-eye");
});

toggleConfirmPassword.addEventListener("click", function (e) {
    e.preventDefault();
    // toggle the type attribute
    const type = confirmPassword.getAttribute("type") === "password" ? "text" : "password";
    confirmPassword.setAttribute("type", type);
    
    // toggle the icon
    this.classList.toggle("bi-eye");
});

// prevent form submit
// const form = document.querySelector("form");
// form.addEventListener('submit', function (e) {
//     e.preventDefault();
// });


