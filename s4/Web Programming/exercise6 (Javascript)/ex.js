'use strict';

const bodyObject = document.body;
const boxObject = document.getElementById('par');

document.getElementById('yelBack').addEventListener('click', function (ev) {
    bodyObject.style.backgroundColor = 'rgb(255,255,0)';
});

document.getElementById('whiBack').addEventListener('click', function (ev) {
    bodyObject.style.backgroundColor = 'rgb(255,255,255)';
});

document.getElementById('yelPar').addEventListener('click', function (ev) {
    boxObject.style.backgroundColor = 'rgb(255,255,0)';
});

document.getElementById('whiPar').addEventListener('click', function (ev) {
    boxObject.style.backgroundColor = 'rgb(255,255,255)';
});