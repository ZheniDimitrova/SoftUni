
// function sum(n, m){
//     return n + m;
// }

// function subtract(n, m){
//     return n - m;
// }

// function addAndsubtract(x, y, z) {
//     console.log(subtract(sum(x, y), z)) ;
// }

function addAndsubtract(x, y, z) {
    console.log(subtract(z));

    function sum(x, y) {
        return x + y;
    }

    function subtract (z) {
        return sum(x, y) - z;
    }
}


addAndsubtract(23, 6, 10);