import  {isCaptchaSame} from './captcha_verification.js'


var msg1="Password did not match";
var msg2="Incorrect Captcha";
var msg3="form submitted successfully";
var alertmsg="";

function validatePassword(){
    var password= document.querySelector('#password');
    var confirmPassword= document.querySelector('#confirmPassword');
        // console.log(password);
        // console.log(confirmPassword);
    let password_text_content="";
    let confirm_password_text_content="";
    if( password.getAttribute("type") === "password" ){
        password.setAttribute("type", "text");
        password_text_content= password.value;
        password.setAttribute("type", "password");
    }
    else{
        password_text_content= password.value;
    }

    if( confirmPassword.getAttribute("type") === "password" ){
        confirmPassword.setAttribute("type", "text");
        confirm_password_text_content= confirmPassword.value;
        confirmPassword.setAttribute("type", "password");
    }
    else{
        confirm_password_text_content= confirmPassword.value;
    }
    // console.log(password_text_content);
    // console.log(confirm_password_text_content);
     if (password_text_content=== confirm_password_text_content && confirm_password_text_content!="") {
        return true;       
     }else {
        //    alertmsg=msg1;
           return false;        
    }
}


var submitButton= document.querySelector("#submit-btn");
var firstName= document.querySelector("#first-name");
var lastName= document.querySelector("#last-name");
var email= document.querySelector("#email");
var password= document.querySelector('#password');
var confirmPassword= document.querySelector('#confirmPassword');

function ValidationEvent(){

// console.log(firstName.value);   
// console.log(lastName.value);   
// console.log(email.value);   
// console.log(password.value);   
// console.log(confirmPassword.value);  
 if(firstName.value ==="" ||  lastName.value==="" || email.value==="" || password.value==="" || confirmPassword.value==="" ){
    alert("Enter all fields first");
    return;
 }
const res1= validatePassword();
// console.log("res 1 = "+res1);
const res2= isCaptchaSame;
// console.log("res 2 = "+res2);
    if(res1===false)
    {
        alert(msg1);
    }
    else{
        if(res2===false)
        {
            alert(msg2);
        }
        else{
            alert(msg3);
        }
    }
}
submitButton.addEventListener('click', ValidationEvent);


// onsubmit button click we have to send a post request to the backend with payload







