 function validate(){
    var emailReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var passwordReg = /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9@#$%]{6,20})/;
    var nameReg =  /^[A-Za-z]{2,16}$/;
    var pass1 = document.getElementById("password").value;
    var pass2 = document.getElementById("confirm_password").value;
    var email = document.getElementById("email").value;
    var name = document.getElementById("name").value;
    var lastName = document.getElementById("last_name").value;

    if(!nameReg.test(name)){
       alert("name must be between 2 and 16 a-z charaters");
    }
    else if(!nameReg.test(lastName)){
        alert("name must be between 2 and 16 a-z charaters");
    }
    else if(pass1 != pass2){
        alert("passwords do not match");     
    }
    else if(!passwordReg.test(pass1)){
        alert("Password is not valid");
    }
    else if(!emailReg.test(email)){
        alert("Not a valid email");
    }
    else{
        document.forms["paymentForm"].submit();
    }
}