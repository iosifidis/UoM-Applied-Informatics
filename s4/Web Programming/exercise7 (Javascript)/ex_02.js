'use strict';

// Keyboard events + animation
var move = false, speed = 3, diagonalSpeed,
    circle = document.getElementsByClassName('circle')[0],
    myleft = Number.parseInt(getComputedStyle(circle).left),
    mytop =  Number.parseInt(getComputedStyle(circle).top),
    direction = {
        left:  false,
        right: false,
        up:    false,
        down:  false
    };

diagonalSpeed = Math.sqrt( speed * speed / 2 );

var moveCircle = function () {
    var moveHorizontally, moveVertically, moveDiagonally;
    var actualSpeed;

    moveHorizontally = ( direction.left ) ? !direction.right : direction.right;
    moveVertically   = ( direction.up   ) ? !direction.down  : direction.down;
    moveDiagonally   = moveHorizontally && moveVertically;
    actualSpeed      = ( moveDiagonally ) ? diagonalSpeed : speed;

    if ( moveHorizontally ) {
        if ( direction.left ) {
            myleft = myleft - actualSpeed;
        }
        else {
            myleft = myleft + actualSpeed;
        }
        circle.style.left = myleft + 'px';
    }
    if ( moveVertically ) {
        if ( direction.up ) {
            mytop = mytop - actualSpeed;
        }
        else {
            mytop = mytop + actualSpeed;
        }
        circle.style.top = mytop + 'px';
    }

    if ( moveHorizontally || moveVertically ) {
        move = true;
        requestAnimationFrame(moveCircle);
    }
    else {
        move = false;
    }
};

document.addEventListener('keydown', function (evt) {
    switch (evt.code) {
        case 'ArrowLeft':
            direction.left = true;
            break;
        case 'ArrowRight':
            direction.right = true;
            break;
        case 'ArrowUp':
            direction.up = true;
            break;
        case 'ArrowDown':
            direction.down = true;
            break;
    }
    if ( !move ) {
        requestAnimationFrame(moveCircle);
    }
}, false);

document.addEventListener('keyup', function (evt) {
    switch (evt.code) {
        case 'ArrowLeft':
            direction.left = false;
            break;
        case 'ArrowRight':
            direction.right = false;
            break;
        case 'ArrowUp':
            direction.up = false;
            break;
        case 'ArrowDown':
            direction.down = false;
            break;
    }
    if ( !move ) {
        requestAnimationFrame(moveCircle);
    }
}, false);
