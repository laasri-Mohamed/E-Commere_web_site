function showAdmin() {
    var contact = document.getElementById("contact");
    var adresse = document.getElementById("adresse");
    contact.style.display = "none";
    adresse.style.display = "none";
    
    var fname = document.getElementById("fname");
    var lname = document.getElementById("lname");
    var email = document.getElementById("email");
    var password = document.getElementById("pass");
    
    fname.style.display = "table-row";
    lname.style.display = "table-row";
    email.style.display = "table-row";
    password.style.display = "table-row";
}

function showClient() {
    var contact = document.getElementById("contact");
    var adresse = document.getElementById("adresse");
    var fname = document.getElementById("fname");
    var lname = document.getElementById("lname");
    var email = document.getElementById("email");
    var password = document.getElementById("pass");
    
    contact.style.display = "table-row";
    adresse.style.display = "table-row";
    fname.style.display = "table-row";
    lname.style.display = "table-row";
    email.style.display = "table-row";
    password.style.display = "table-row";
}



