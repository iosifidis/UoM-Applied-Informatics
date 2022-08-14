'use strict';

const input = document.getElementsByTagName('input');
const button = document.getElementById('convert');

//const num = document.getElementsByClass('num');
// const zero = document.getElementById('zero');
// const one = document.getElementById('one');

const result = document.getElementById('result');

let message = '';

button.addEventListener('click', function (ev) {
	
	let miles = Number(input[0].value) / 0.62 ;
	message += input[0].value + " miles equals " + miles + " kilometers" + "<br />";
	result.innerHTML =  message;
});


// for(const e of num){
// 	e.addEventListener('click', function (ev) {
// 		if(num[11].value == )
// 		result.innerHTML = result.innerHTML + "0";
// 	});

// }

