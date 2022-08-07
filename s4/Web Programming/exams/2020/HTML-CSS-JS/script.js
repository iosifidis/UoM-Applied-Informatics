'use strict';

const inputs = document.getElementsByTagName('input');
const connect = document.getElementById('connect');

connect.addEventListener('click', function (ev) {
    
    if(inputs[0].value == "" && inputs[0].value == ""){
    	window.alert('Δεν συμπληρώσατε τους κωδικούς');
    }
    else{
    	window.alert('Επιτυχής σύνδεση');
    }

});
