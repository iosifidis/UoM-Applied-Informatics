'use strict'

console.log('1η Άσκηση');
let i, powerOf2 = 2;

for ( i= 1; i < 11; i++) {
    console.log(i+'η δύναμη του 2: '+powerOf2);
    powerOf2 = powerOf2*2;
}

console.log('2η άσκηση');
function findMax(a,b,c) {
    var max = a;
    if ( b > max ) {
        max = b;
    }
    if ( c > max ) {
        max = c;
    }
    return max;
}
console.log('Κλήση συνάρτησης με ορίσματα: 10,14,9');
console.log(findMax(10,14,9));
console.log('Κλήση συνάρτησης με ορίσματα: \'aa\',\'ba\',\'ca\'');
console.log(findMax('aa','ba','ca'));

console.log('3η άσκηση');
function myPower(x,y) {
    var i, product = x;
    if ( (typeof x != 'number') || (typeof y != 'number') ) {
        return undefined;
    }
    if ( ( x < 1 ) || ( y < 1 ) ) {
        return undefined;
    }
    if ( ( x%1 != 0 ) || ( y%1 != 0 ) ) {
        return undefined;
    }
    for (i=1; i<y; i++) {
        product = product * x;
    }
    return product;
}
console.log('Κλήση συνάρτησης με ορίσματα: 3,3');
console.log(myPower(3,3));
console.log('Κλήση συνάρτησης με ορίσματα: 3.2,3');
console.log(myPower(3.2,3));
console.log('Κλήση συνάρτησης με ορίσματα: -3,3');
console.log(myPower(-3,3));
console.log('Κλήση συνάρτησης με ορίσματα: \'aa\',\'ba\'');
console.log(myPower('aa','ba'));
