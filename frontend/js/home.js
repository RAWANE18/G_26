let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");
let btn = document.getElementsByClassName("btn");
toggle.onclick = function () {
  navigation.classList.toggle("active");
  main.classList.toggle("active");
};
