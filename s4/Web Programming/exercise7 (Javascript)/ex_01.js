'use strict';

const inputs = document.getElementsByTagName('input');
const operator = document.querySelector('select');
const result = document.querySelector('span');

document.getElementById('calculate').addEventListener('click', function (ev) {
    let message = 'Και κλάμα η κυρία...'; 

    const num0 = Number(inputs[0].value);
    const num1 = Number(inputs[1].value);

    switch (operator.value) {
        case '+':
            message = num0 + num1 + '';
            break;
        case '-':
            message = num0 - num1 + '';
            break;
        case '*':
            message = num0 * num1 + '';
            break;
        case '/':
            message = num0 / num1 + '';
            break;
    }

    result.innerHTML = message;
});