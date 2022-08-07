'use strict';
const button1 = document.getElementById('playerbutton1');
const button2 = document.getElementById('playerbutton2');
const playerscore1 = document.getElementById('playerscore1');
const playerscore2 = document.getElementById('playerscore2');
const winner = document.getElementById('winner');

button1.addEventListener('click', function (ev) {
	playerscore1.innerHTML = Number(playerscore1.innerHTML) + 1 + '';
	if(Number(playerscore1.innerHTML)==5){
		winner.innerHTML = 'Νικητής: 1ος Παίκτης';       
	}
});

button2.addEventListener('click', function (ev) {
	playerscore2.innerHTML = Number(playerscore2.innerHTML) + 1 + '';
	if(Number(playerscore2.innerHTML)==5){
		winner.innerHTML = 'Νικητής: 2ος Παίκτης';
        
	}
});
