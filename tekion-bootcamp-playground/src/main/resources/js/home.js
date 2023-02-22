const vis_btn = document.getElementById("visibility-btn");
const vis_modal = document.getElementById("vis-modal");
const submit_post = document.getElementById("password-submit");
const notes_pwd = document.getElementById("pass-word");
vis_btn.addEventListener("click", (e) => {
  console.log("gdg");
  vis_modal.showModal();
});
let notes_id = [];
let notes_pass = [];
// console.log(  )
var editor = new FroalaEditor("#example");
const curr_notes = document.getElementById("example");
// console.log(curr_notes);
const post_notes = document.getElementById("post-notes");
const post_block = document.getElementById("post-block");
// const notes_password =
// let curr_zpost_block = post_block;
const parent_notes = document.getElementsByClassName("parent-notes")[0];
let user_id = {};
let user_pwd = {};
submit_post.addEventListener("click", (e) => {
  let curr_post_block = post_block.cloneNode(true);
  curr_post_block.classList.add("block-post-content");
  let curr_post_block_text = curr_post_block.getElementsByTagName("p");
  console.log("xbdfb");
  // notes_id = date()+ Math.random();
  console.log(curr_notes);
  // console.log(curr_post_block_text[0].innerHTML);
  let cur_id = new Date().getTime() + Math.random();
  let cur_pwd = notes_pwd.value;
  //  user_id.push(cur_id);
  //  user_pwd.push(cur_pwd);
  console.log(cur_pwd, cur_id);
  curr_post_block_text[0].innerHTML = curr_notes.innerHTML;
  // console.log(curr_post_block_text[0]);
  parent_notes.insertBefore(curr_post_block, parent_notes.firstChild);
  // console.log(parent_notes.getElementsByTagName('p')[0].getElementsByTagName('div')[0]);
  parent_notes
    .getElementsByTagName("p")[0]
    .getElementsByTagName("div")[0].style.display = "none";
  // vis_modal.close();
});
post_notes.addEventListener("click", (e) => {
  let curr_post_block = post_block.cloneNode(true);
  curr_post_block.classList.add("block-post-content");
  let curr_post_block_text = curr_post_block.getElementsByTagName("p");
  console.log(curr_notes);
  console.log(curr_post_block_text[0].innerHTML);
  curr_post_block_text[0].innerHTML = curr_notes.innerHTML;
  console.log(curr_post_block_text[0]);
  parent_notes.insertBefore(curr_post_block, parent_notes.firstChild);
  console.log(
    parent_notes.getElementsByTagName("p")[0].getElementsByTagName("div")[0]
  );
  parent_notes
    .getElementsByTagName("p")[0]
    .getElementsByTagName("div")[0].style.display = "none";
  // parent_notes.appendChild(curr_post_block);
});
