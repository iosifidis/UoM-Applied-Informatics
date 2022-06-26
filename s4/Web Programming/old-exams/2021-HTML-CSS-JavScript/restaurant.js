'use strict';

const inputs = document.getElementsByTagName('input');
const result = document.querySelector('span');

let message = 'Nothing has been chosen... ';
let food_message = '';
let salad_message = '';
let food_cost = 0;
let salad_cost = 0;
let total_cost = 0;

for(const elem of inputs) {
    elem.addEventListener('click', function (ev) {
    
       if(elem.name == "food") {
            food_message = "Κυρίως Πιάτο: " + elem.id + "<br>"; 
            food_cost = parseInt(elem.value);
        }
        
        if(elem.name == "salad") {
            salad_message = "Σαλάτα: " + elem.id + "<br>"; 
            salad_cost = parseInt(elem.value);
        }

        message = food_message + salad_message;
        total_cost = food_cost + salad_cost;

        message += "Συνολικό κόστος: " + total_cost;

        result.innerHTML = message;
    })
};
