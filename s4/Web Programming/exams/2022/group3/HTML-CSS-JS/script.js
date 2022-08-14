'use strict';
const upDown = document.getElementById('upDown');
const leftRight = document.getElementById('leftRight');
const p = document.getElementById('box');

upDown.addEventListener('click', function (ev) {  
    if(p.style.borderTop == "solid" && p.style.borderBottom == "solid"){
        p.style.borderTop = 'none';
        p.style.borderBottom = 'none';
    }
    else{
         p.style.borderTop = 'solid';
         p.style.borderBottom = 'solid';
     }
}
);

leftRight.addEventListener('click', function (ev) {
    if(p.style.borderLeft == "solid" && p.style.borderRight == "solid"){
        p.style.borderLeft = 'none';
        p.style.borderRight = 'none';
    }
    else{
        p.style.borderLeft = 'solid';
        p.style.borderRight = 'solid';
     }

/*
ΕΝΑΛΛΑΚΤΙΚΟΣ ΜΕ hidden
upDown.addEventListener('click', function (ev) {  
    if(p.style.borderTopStyle == "solid" && p.style.borderBottomStyle == "solid"){
        p.style.borderTopStyle = 'hidden';
        p.style.borderBottomStyle = 'hidden';
    }
    else{
         p.style.borderTopStyle = 'solid';
         p.style.borderBottomStyle = 'solid';
     }
}
);

leftRight.addEventListener('click', function (ev) {
    if(p.style.borderLeftStyle == "solid" && p.style.borderRightStyle == "solid"){
        p.style.borderLeftStyle = 'hidden';
        p.style.borderRightStyle = 'hidden';
    }
    else{
        p.style.borderLeftStyle = 'solid';
        p.style.borderRightStyle = 'solid';
     }
*/

});

