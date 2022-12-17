document.addEventListener('keyup', e => {
	if(e.target.matches('#buscador')){
		document.querySelectorAll('.festival').forEach(festival => {
			festival.textContent.toLowerCase().includes(e.target.value) 
			? festival.classList.remove('filtro')
			: festival.classList.add('filtro');
		})
	}
})

document.addEventListener("DOMContentLoaded", ready);

function ready(){
    let formulario = document.getElementById("boton_login");
    formulario.addEventListener('click', validar,false);

 
}


//VALIDAR NOMBRE Y APELLIDOS
function validarNombre(){
    let nombre = document.getElementById("nombreusuario").value;
    let soloLetras = /^([a-zA-Z\u00f1\u00d1]{1}[a-zA-Z\u00f1\u00d1]+[\s]*)+$/;
    //el más indica que tenga más letras, \s permite espacios, y \u00f1 es ñ minúscula y \u00d1 es Ñ mayúscula
    //el comienzo impide que se ponga un espacio vacio y se admita

    if (nombre =="" || nombre ==null) { 
        document.getElementById("nombreusuario").focus();   //lo identificamos así y no con la variable que hemos creado 
       //porque al obtener el valor da error, tiene que ser el elemento
        document.getElementById("errorNombre").innerHTML="Tienes que introducir nombre";
        return false;
    } else {
        return true;
    }
}



//VALIDAR EMAIL
function validarEmail(){
    let email = document.getElementById("email").value;

    let emailValido = /([^@]+)@([^@]+)(.[a-zA-Z]{2,})/;

    //indicamos con el (^) que acepte todos los valores menos el @ y se repitan(+) despues indicamos que tiene
    //que haber un @ y repetimos el codigo del principio para despues del @
    // y por último indicamos que tiene que haber un (.) y después de el solo acepte letras y mínimo 2 carácteres

    if(email=="" || email==null){
        document.getElementById("email").focus();
        document.getElementById("errorEmail").innerHTML="Tienes que introducir un EMAIL";
        return false;
    }else if (!email.match(emailValido)){
        document.getElementById("email").focus();
        document.getElementById("errorEmail").innerHTML="Tienes que introducir un EMAIL CORRECTO";
        return false;
    } else{
        return true;
    }
}



function validarContrasenha(){
    let password = document.getElementById("password").value;
    

    if (password =="" || password ==null) { 
        document.getElementById("password").focus();   
        document.getElementById("errorPassword").innerHTML="Tienes que introducir contraseña";
        return false;
    } else {
        return true;
    }
}



function validar(event) {

    if (validarNombre() && validarEmail() && 
    validarContrasenha() /*&& confirm("Pulsa aceptar si deseas enviar el formulario")*/) {
        //document.getElementById("exito").innerHTML="Usuario creado correctamente! Haz <a href='log.html '>log in </a>para acceder";
        return true;
    } else {
        event.preventDefault();  
        return false;
    }
}