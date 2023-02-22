//alert("hello");

let captchaImageField = document.getElementById("captcha");
//console.log(capchaImageField);
let captchaImage = captchaImageField.getContext("2d");
//console.log(capchaImage);
captchaImage.font = "30px Roboto";
captchaImage.fillStyle = "Black";

let refreshButton = document.getElementById("refreshCaptcha");
let captchaField = document.getElementById("captchaField");
let outputField = document.getElementById("output");
//console.log(validate);
const alphaNums = [
  "A",
  "B",
  "C",
  "D",
  "E",
  "F",
  "G",
  "H",
  "I",
  "J",
  "K",
  "L",
  "M",
  "N",
  "O",
  "P",
  "Q",
  "R",
  "S",
  "T",
  "U",
  "V",
  "W",
  "X",
  "Y",
  "Z",
  "a",
  "b",
  "c",
  "d",
  "e",
  "f",
  "g",
  "h",
  "i",
  "j",
  "k",
  "l",
  "m",
  "n",
  "o",
  "p",
  "q",
  "r",
  "s",
  "t",
  "u",
  "v",
  "w",
  "x",
  "y",
  "z",
  "0",
  "1",
  "2",
  "3",
  "4",
  "5",
  "6",
  "7",
  "8",
  "9",
];
let emptyArray = [];

for (let length = 0; length < 7; length++) {
  emptyArray.push(alphaNums[Math.floor(Math.random() * alphaNums.length)]);
}
let captchaString = emptyArray.join("");
//console.log(captchaString);
captchaImage.fillText(
  captchaString,
  captchaImageField.clientWidth / 4,
  captchaImageField.clientHeight / 2
);

refreshButton.addEventListener("click", function (e) {
  let refreshArray = [];
  captchaField.value = "";
  e.preventDefault();
  for (let length = 0; length < 7; length++) {
    refreshArray.push(alphaNums[Math.floor(Math.random() * alphaNums.length)]);
  }
  //console.log(refreshArray);
  captchaImage.clearRect(
    0,
    0,
    captchaImageField.width,
    captchaImageField.height
  );
  captchaString = refreshArray.join("");
  // console.log(captchaString);
  captchaImage.fillText(
    captchaString,
    captchaImageField.clientWidth / 4,
    captchaImageField.clientHeight / 2
  );
  outputField.innerHTML = "";
});

export { captchaField, captchaString, outputField };
