document.getElementById("btn").addEventListener("click", function (event) {
  event.preventDefault(); // Empêche le formulaire de se soumettre

  var username = document.getElementById("username").value;
  var password = document.getElementById("passeword").value;
  var signinLink = document.querySelector(".signin-link");

  if (username === "doctor" && password === "1234") {
    window.location.href = "Doctor.html";
  } else {
    signinLink.textContent = "Nom d'utilisateur ou mot de passe incorrect.";
    signinLink.style.color = "red";
  }
});
