'use strict';

const zero = document.getElementById('zero');
const one = document.getElementById('one');
const result = document.getElementById('result');

zero.addEventListener('click', function (ev) {
	result.innerHTML = result.innerHTML + "0";
});

one.addEventListener('click', function (ev) {
	result.innerHTML = result.innerHTML + "1";
});