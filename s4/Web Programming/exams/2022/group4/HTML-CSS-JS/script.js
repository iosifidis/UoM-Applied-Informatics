'use strict';
const changeVertical = document.getElementById('changeVertical');
const changeHorizontal = document.getElementById('changeHorizontal');
let p = document.getElementById('box');

changeVertical.addEventListener('click', function (ev) {    
    p.style.width = '200px';
    p.style.height = '300px';      
	}
);

changeHorizontal.addEventListener('click', function (ev) {
    p.style.width = '300px';
    p.style.height = '200px';     
	}
);

