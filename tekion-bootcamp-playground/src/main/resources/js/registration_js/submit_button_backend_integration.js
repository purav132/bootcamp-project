
// onsubmit button click we have to send a post request to the backend with payload
// formData object banakr we send data to the backend

async function sendrequest(formData) {
   // const formData = new FormData(signUpForm);
   // formData.delete("confirmPassword");
   try {
       const response = await fetch("http://localhost:8080/signup", {
           method: "POST",
           body: formData
       });
       const responseObject = response.json();
       if (responseObject.status == "sucess")
           location.replace(window.location.origin + "/index.html")
       else
           alert("Form not submitted due to some error");
   } catch (e) {
       alert("Server Error")
   }
}


var submitButton= document.querySelector("#submit-btn");
submitButton.addEventListener('submit', function(e){
   e.preventDefault();
   const signUpForm= document.querySelector("form");
   const formData= new FormData(signUpForm);
   sendrequest(formData);
   // for(let key of formData.keys())
   // {
   //  console.log(key , formData.get(key));
   // }
   //  console.log(formData);

});











