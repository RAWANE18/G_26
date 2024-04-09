var connexion = document.getElementById("connexionLink");
var register = document.getElementById("registerLink");
var formContainer = document.getElementsByClassName("form-container")[0];
var connexionContainer = document.getElementsByClassName(
  "connexion_Container"
)[0];
var btn = document.getElementById("btn");

connexion.addEventListener("click", () => {
  if (window.getComputedStyle(connexionContainer).display === "none") {
    connexionContainer.style.display = "block";
    formContainer.style.display = "none";
  } else {
    connexionContainer.style.display = "none";
    formContainer.style.display = "block";
  }
});
register.addEventListener("click", () => {
  if (window.getComputedStyle(formContainer).display === "none") {
    connexionContainer.style.display = "none";
    formContainer.style.display = "block";
  } else {
    connexionContainer.style.display = "block";
    formContainer.style.display = "none";
  }
});
btn.addEventListener("click", () => {
  alert("compte créé avec succès");
});
